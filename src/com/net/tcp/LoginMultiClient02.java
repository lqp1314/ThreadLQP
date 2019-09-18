package com.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @Author: lqp
 * @Date: 2019/9/18 11:02
 *
 * **终极操作
 *  *  模拟登录  多个客户端请求  要实现不同的 客户端  就是讲这个程序复制多份并启动
 *  封装繁琐的操作
 *
 *  * 创建客户端
 *  * 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
 *  * 2、操作: 输入输出流操作
 *  * 3、释放资源
 */
public class LoginMultiClient02 {
    public static void main(String[] args) throws  Exception{
        System.out.println("-----Client-----");
//1、建立连接: 使用Socket创建客户端 +服务的地址和端口
        Socket client=new Socket("localhost",8888);
        //s输入输出操作
        new Send(client).send();  // 发送
        new Receive(client).receive();
        //3、释放资源
        client.close();
    }
    //静态内部类  发送数据
    static class  Send{
        private  Socket client;
        private  DataOutputStream dos;
        private  BufferedReader  console;  //控制台接受的数据
        private  String msg;
        Send(Socket client){
            console= new BufferedReader(new InputStreamReader(System.in)); //获得字符输入流的类
           this.msg=init();// s 控制台 最初的接收数据
            try {
            /// 准入输出数据
                dos= new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
          //获得账户和密码
        private String init() {
            try {
                System.out.println("请输入用户名\n");
                String uname=console.readLine();  //接收数据
                System.out.println("请输入密码\n");
               String upwd= console.readLine();
               //返回数据
                return "uname="+uname+"&"+"upwd="+upwd;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "";
        }
        //具体的发送数据
        public  void send(){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //接收
    static class Receive{
        private Socket client;
        private DataInputStream dis;
        public Receive(Socket client) {
            this.client = client;
            try {
                dis=new DataInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void receive() {
            String result;
            try {
                result = dis.readUTF();
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
