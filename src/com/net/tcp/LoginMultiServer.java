package com.net.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: lqp
 * @Date: 2019/9/18 11:24
 *
 *  模拟登录 多个客户端请求
 *  * 创建服务器
 *  * 1、指定端口 使用ServerSocket创建服务器
 *  * 2、阻塞式等待连接 accept
 *  * 3、操作: 输入输出流操作
 *  * 4、释放资源
 */
public class LoginMultiServer {
    public static void main(String[] args)  throws  Exception{
        System.out.println("---server");
        //指定端口号 使用serversocket 创建服务器
        ServerSocket server= new ServerSocket(8888);
        boolean isRunning=true; // 连接信号
        // 阻塞式等待连接
        while(isRunning){
            Socket client=server.accept(); // 连接服务器 可以不断的监听 并连接
            System.out.println("一个客户端建立了连接");
            //启动多线程  连接多个客户端的操作并响应  使用封装
            new Thread(new Channel(client)).start();

        }

        server.close();

    }

    //一个channel 就贷记本一个客户端操作  最新设计风格在 NIO中
    static class Channel implements  Runnable{
        private Socket client;
        //输入流
        private DataInputStream dis;
        //输出流
        private DataOutputStream dos;
        //g构造器
        public Channel(Socket client){
            this.client=client;
            //获取输入输出流的操作
            try {
                dis=new DataInputStream(client.getInputStream());
                dos= new DataOutputStream(client.getOutputStream());

            } catch (IOException e) {
                e.getStackTrace();
                //如果出现异常 直接返会 释放资源 
                release();
            }
        }

        //线程里面 只做和业务相关的事情  把其他的公共的操作都可以移出去
        @Override
        public void run() {

            //3 操作 输入输出流操作
            String uname="";
            String upwd="";
            //分析
            String[] dataArray = receive().split("&"); //得到的数组
            for (String info :
                    dataArray) {
                String[] userInfo = info.split("=");
                if(userInfo[0].equals("uname")) {
                    System.out.println("你的用户名为:"+userInfo[1]);
                    uname = userInfo[1];
                }else if(userInfo[0].equals("upwd")) {
                    System.out.println("你的密码为:"+userInfo[1]);
                    upwd = userInfo[1];
                }
            }
          //判断密码是否正确   然后发送给客户端
            if(uname.equals("lqp") && upwd.equals("1234")) { //成功
                send("登录成功，欢迎回来");
            }else { //失败
                send("用户名或密码错误");
            }
            release();
        }

        //接收数据
        private String receive(){
            String datas="";
            try {
               datas= dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  datas;
        }

        //发送数据
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //释放资源
        private void release() {
            // 4、释放资源
            try {
                if(null != dos) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(null != dis) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(null != client) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
