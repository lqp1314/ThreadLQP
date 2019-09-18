package com.net.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 *  udp 传输 object对象 序列化的实现
 *  *  引用类型: 发送端
 *  * 1、使用DatagramSocket  指定端口 创建发送端
 *  * 2、将基本类型  转成字节数组
 *  * 3、 封装成DatagramPacket 包裹，需要指定目的地
 *  * 4、发送包裹send​(DatagramPacket p) *
 */
public class UdpObjClient {
    public static void main(String[] args) throws  Exception{
        System.out.println("客户端已启动");
        DatagramSocket client = new DatagramSocket(8888);//客户端的端口
        //  第一线的流   字节输出流  要单独拿出来 因为要将其转化成字节数组 然后里面添加了 处理流 buffer缓冲流 和 对象输出流
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos= new ObjectOutputStream(new BufferedOutputStream(bos));
        oos.writeObject(new Employee("ma",99));
        oos.flush();// 强行缓冲
        // 将其转成 字节数组
        byte[] datas=bos.toByteArray();
        //封装成DatagramPacket 包 传入地址+端(服务端的端口号)口 用于发送
        DatagramPacket packet= new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",6666));
     //发送数据包
     client.send(packet);
     //释放那个资源
        client.close();
    }
}
