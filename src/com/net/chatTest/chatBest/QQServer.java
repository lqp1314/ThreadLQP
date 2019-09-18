package com.net.chatTest.chatBest;

import com.net.tcp.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: lqp
 * @Date: 2019/9/18 13:18
 *    在线聊天室: 服务器
 *  * 目标: 加入容器实现群聊
 *      如果实现群聊  加入线程的集群  将他们统一存到一个容器中
 *      方便获取他们的 信息
 *    CopyOnWriteArrayList   实现这个 并发操作   便于进行读写操作
 *    防止出现 多线程的并发的 数据不一致的问题
 *
 *    +目标 私聊 通过对数据的筛选完成私聊操作   @李清坡 slsldlsdsd
 */
public class QQServer {
    // 类私有方法 存在 常量池中    用于存放所以的线程
    private  static CopyOnWriteArrayList<Channel> all=new CopyOnWriteArrayList<>() ;

    public static void main(String[] args)  throws  Exception{
        System.out.println("-----Server-----");
        // 1、指定端口 使用ServerSocket创建服务器
        ServerSocket server= new ServerSocket(8888);//在本机实现一个服务器   端口为8888
        //2 阻塞式等待连接 accept
        while(true){  // 实现无限循环的目的 是为了  不断的去 监听 并进行客户端的连接
            Socket client = server.accept();  //连接一个客户端
            System.out.println("一个客户端建立了连接");
            Channel c=new Channel(client);
            all.add(c);
            new Thread(c).start();
        }

    }

    //实现 服务器端的  多线程  以便进行多用户聊天
    // 一个客户表示一个channel
    static  class  Channel implements  Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket  client;
        private  String name ; // 获得客户端的用户名
        private volatile boolean isRunning;  //对所有数据的可见性 及时更新
       // 构造器 完成初始化操作
        public Channel(Socket client) {
            this.client = client;
            try {
                //接受数据
                dis=new DataInputStream(new BufferedInputStream(client.getInputStream()));
               //发送数据
                dos=new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
                isRunning=true;// 设置标志位  用于关闭线程

                ///获取名字 然后进行转发给他人   xxx:sasasasa  切割
                String msg = this.receive();  //用户第一次发送的数据
                this.name= msg.split(":")[0];  //获得的名字
                this.send("欢迎你 来到聊天室！！！");
                sendOthers(this.name+"来了聊天室");

                //将客户端第一次发送的消息 发送出去
                sendOthers(msg);
            } catch (IOException e) {
                System.out.println("聊天室初始化失败！！！");
                release();
            }
        }
        //多线程的实际业务操作
        @Override
        public void run() {
            while (isRunning){
                String msg = receive();
                if (!msg.equals("")){
                    sendOthers(msg);
                }
            }
        }
        /**
         * 群聊：获取自己的消息，发给其他人
           重点  获得容器中的 channel
         CopyOnWriteArrayList

            s私聊  通过对字符串信息的筛选 实现私聊   @李清坡 我爱你
         */
        private  void sendOthers(String msg){
            //如果是私聊  得到的信息为   李金刚：@李清坡  哈哈哈 这样的格式  所以要先找到@
            //boolean isPrivate = msg.startsWith("@"); //startsWith 是判断是否以该字符串开头 不是包含的关系
            boolean isPrivate = msg.contains("@");  //这个才是包含的关系
            // 如果有@ 说明是私聊
            if (isPrivate){
                //如果是私聊  则要找到 是给谁私聊   切割
                String target = msg.split(":")[1];  //@李清坡 哈哈
                //因为名字不一样长  则只获取前两个
                String name = target.substring(1, 3);// 李清  切割字符  最右边的不包含
                //查看容器中 是否存在
                for (Channel other : all) {
                    if (other.name.contains(name)){ //两个名字一样 则为
                        other.send(this.name+"悄悄对你说的完整信息："+target);
                        //@李清坡 哈哈
                    }
                    break;
                }
            }else { //不是私聊 则正常群发
                for (Channel other:all) {
                    if (other==this)// 自己
                    {
                        continue; // 自己发送的信息跳过
                    }
                    // 李清坡:sasassd 群发消息
                    other.send(msg);
                }
            }
        }
        //接收消息
        private String receive() {
            String msg ="";
            try {
                msg =dis.readUTF();
            } catch (IOException e) {
                System.out.println("---2------");
                release();
            }
            return msg;
        }
        //发送消息
        private void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("---3------");
                release();
            }
        }

        //释放资源
        private void release() {
            this.isRunning = false;
            Utils.close(dis,dos,client);
            //退出
            all.remove(this);
           sendOthers(this.name+"已退出聊天室...");
        }
    }


}
