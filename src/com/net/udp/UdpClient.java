package com.net.udp;

import java.io.IOException;
import java.net.*;

/**
 * 使用udp实现客户端
 *  基本流程: 发送端
 *  * 1、使用DatagramSocket  指定端口 创建发送端
 *  * 2、准备数据 一定转成字节数组
 *  * 3、 封装成DatagramPacket 包裹，需要指定目的地
 *  * 4、发送包裹send​(DatagramPacket p) *
 *  * 5、释放资源
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中");
     //  1、使用DatagramSocket  指定端口 创建发送端    发送端和客户端 各占一个端口  端口要不一致  不然会冲突 除非 是不同 的主机
        DatagramSocket client = new DatagramSocket(8888);

        //   2、准备数据 一定转成字节数组
        String data="我来哦是";
        byte[] bytes = data.getBytes();
// *  * 3、    封装成DatagramPacket 包裹，需要指定目的地   这里的端口地址 要设为 接收端的端口  不然 发布到接收端
        DatagramPacket packet=new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost",6666));
//   *  * 4、发送包裹send​(DatagramPacket p)
        client.send(packet);
// *  * 5、释放资源
        client.close();
    }

}


