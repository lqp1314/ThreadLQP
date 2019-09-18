package com.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接受数据的一方
 * 基本流程: 接收端
 *  * Address already in use: Cannot bind  同一个协议下端口不允许冲突
 *  * 1、使用DatagramSocket  指定端口 创建接收端
 *  * 2、准备容器 封装成DatagramPacket 包裹
 *  * 3、阻塞式接收包裹receive​(DatagramPacket p)
 *  * 4、分析数据
 *  *    byte[]  getData​()
 *  *                getLength​()
 *  * 5、释放资源
 */
public class UdpServer {
    public static void main(String[] args) throws  Exception{
        System.out.println("接受放启动中");
        //使用DatgramSocket 指定端口   创建接受端 
        DatagramSocket server = new DatagramSocket(6666);
        //准备容器 封装成DatagramPacket 包 用于接收数据
         byte[] container= new byte[1024*20];
         DatagramPacket packet= new DatagramPacket(container,0,container.length);
         //阻塞式接收包囊 receive（DatagramPacket p）
        server.receive(packet);//阻塞式
        //  获得数据 分析数据     字节数组
        byte[] datas=packet.getData();
        int len=packet.getLength();
        System.out.println("数据包的长度："+len);
        System.out.println("字节数组的长度："+datas.length);

        //打印
        System.out.println(new String(datas,0,datas.length));
    }


}


