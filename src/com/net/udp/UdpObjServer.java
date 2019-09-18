package com.net.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 *  udp 传输 object对象 序列化的实现
 *  * 引用类型: 接收端
 *  * Address already in use: Cannot bind  同一个协议下端口不允许冲突
 *  * 1、使用DatagramSocket  指定端口 创建接收端
 *  * 2、准备容器 封装成DatagramPacket 包裹
 *  * 3、阻塞式接收包裹receive​(DatagramPacket p)
 *  * 4、分析数据    将字节数组还原为对应的类型
 *  *    byte[]  getData​()
 *  *                getLength​()
 *  * 5、释放资源
 */
public class UdpObjServer {
    public static void main(String[] args) throws  Exception{
        System.out.println("接受端启动...");
        DatagramSocket server = new DatagramSocket(6666);//接受端的端口   发送端要连接这个端口
        //设置容器  封装成 DatagramPacket 用来 发送端发送来的数据包
        byte[] container=new byte[1024*20];
        DatagramPacket packet= new DatagramPacket(container,0,container.length);
        // 3、阻塞式接收包裹receive​(DatagramPacket p)
       server.receive(packet);
       //分析数据  接受数据  将对象 字节数组 还原成 对象  使用  ObjectInputStream 进行反序列化
        //读取 --》 反序列化
        int len = packet.getLength();// 接受到的数据的长度   不是 自己定义的容器的长度
        byte[] datas=packet.getData();  //接收到的数据

        ObjectInputStream  ois= new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));

        Employee employee=(Employee) ois.readObject();// zhuanhua
        System.out.println(employee);
    /*
    接受端启动...
Employee{name='null', salary=99.0}   因为 name 设置了 transient  所以无法对其序列化
     */
    }
}
