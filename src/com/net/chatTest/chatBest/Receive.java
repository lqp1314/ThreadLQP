package com.net.chatTest.chatBest;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author: lqp
 * @Date: 2019/9/18 12:59
 * 使用多线程封装:接收端
 * *  1、接收消息
 *  * 2、释放资源
 *  * 3、重写run
 *   写法和 发送端类似
 *   重要的是 对数据的封装
 *   */
public class Receive   implements  Runnable{
    private DataInputStream dis;
    private Socket client;
    private   volatile boolean isRunning;  //  对 该数据 及时更新  对其他数据可见性
    public Receive(Socket socket){
        this.client=socket;
        this.isRunning=true;
        try {
            dis=new DataInputStream(new BufferedInputStream(client.getInputStream()));
        } catch (IOException e) {
            System.out.println("接受数据 初始化出错！！！");
            relese();
        }
    }


    @Override
    public void run() {
       //z只要isRunning  不为false 程序就一直跑
        while (isRunning){
         String msg=receive();
         if (!msg.equals("")){
             System.out.println(msg);
         }
     }
    }

    //接收消息
    private String receive(){
        String  msg="";
        try {
            msg=dis.readUTF();
        } catch (IOException e) {
            System.out.println("接受消出错！！！");
           this.relese();
        }
        return  msg;
    }

    //释放资源
    private void relese() {
        this.isRunning = false;
        Utils.close(dis,client);
    }

}
