package com.net.chatTest.chatBest;

import java.io.*;
import java.net.Socket;

/**
 * @Author: lqp
 * @Date: 2019/9/18 12:42
/**
 * 使用多线程封装:发送端
 * 1、发送消息
 * 2、从控制台获取消息
 * 3、释放资源
 * 4、重写run

    对发送 和 接收操作 添加线程 使得他们彼此的操作不受限制  不分先后顺序
 */

public class Send implements  Runnable {
    private BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    private  volatile boolean isRunning; // 线程结束的标准  添加 volatile 对isRunning的修改及时响应
    private  String name; //每个线程的名字   这个我自己用开启多个程序复制的方法 所以不用也行
    //构造器
    public Send(Socket client) {
        this.client = client;
        //获得控制台的数据
        console=new BufferedReader(new InputStreamReader(System.in));
        this.isRunning=true;
        try {
            dos=new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        } catch (IOException e) {
            System.out.println("发送端初始化出错！！！");
            this.release();//释放资源
        }
    }


    @Override
    public void run() {
       while (isRunning){
           String msg = getStrFromConsole();
           if (!msg.equals("")){
               // 名字加信息 一并发送
               send(Thread.currentThread().getName()+":"+msg);
           }
       }
    }

    //发送消息
    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("发送消息失败!!!!");
           this.release();
        }
    }
    //从控制台获取消息
    private  String getStrFromConsole(){
        try {
           return console.readLine();// 从控制台收到信息
        } catch (IOException e) {
            System.out.println("控制台获得信息失败！！");
            this.release();
        }
        return  "";
    }

    //释放资源
    private void release() {
        this.isRunning = false; //将标志位设为false  线程结束
        Utils.close(dos,client);
    }
}
