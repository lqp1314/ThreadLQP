package com.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 *   实现多线程的沟通方式
 *   发送端
 */
public class TalkSend  implements  Runnable {
    private DatagramSocket client;
    private BufferedReader reader ;
    private  String toIP;
    private  int    toPort;
    public  TalkSend(int port,String ip,int toPort)
    {
        this.toIP=ip;
        this.toPort=toPort;
        try {
            client=new DatagramSocket(port);
            //系统的输入的   将字节流转为字符流   缓冲的处理流
            reader =new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }    }


    @Override
    public void run() {
        while (true){
            String data;
            try {
                //带上发送者的 线程名字 如  教师/学生
                data=Thread.currentThread().getName()+" : "+reader.readLine();
                byte[] datas=data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length, new InetSocketAddress(toIP,toPort));

                client.send(packet);
                //当输入 bye  的时候 终止线程
                if(data.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //在循环外部关闭  不然 线程无法正常执行
        client.close();


    }
}
