package com.net.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 接受基本数据类型  发送端   IO操作  不过还是需要 字节流
 *  1、使用DatagramSocket  指定端口 创建发送端
 *  * 2、将基本类型  转成字节数组
 *  * 3、 封装成DatagramPacket 包裹，需要指定目的地
 *  * 4、发送包裹send​(DatagramPacket p) *
 */
public class UdpTypeClient {

    public static void main(String[] args)  throws  Exception {
        System.out.println("发送方启动中.... ");
        //s使用DatagramSocket 指定端口 创建发送端
         DatagramSocket client= new DatagramSocket(8888);
        //准备基本类型  转成字节数组
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(baos));
        //操作数据类型+数据
        dos.writeInt(8080);
        dos.writeBoolean(false);
        dos.writeChars("wos奥迪");
        dos.flush();
        byte[] datas=baos.toByteArray();
        //3、 封装成DatagramPacket 包裹，需要指定目的地
        DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",6666));
       client.send(packet);
    }
}
