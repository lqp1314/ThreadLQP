package com.net.tcp;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * 熟悉流程
 * 创建 客户端 Socket  服务端 ServerSocket
 * 1 建立连接  使用socket创建客户端+服务的地址和端口   端口号为对象服务器的端口号
 * 2 操作：  输入输出流的操作  和upd 不同  udp是 发送 和 接受数据包
 * 3 释放资源
 */
public class Client {
    public static void main(String[] args) throws  Exception{
        System.out.println("----client-----");
        //		//1、建立连接: 使用Socket创建客户端 +服务的地址和端口
        Socket client=new Socket("localhost",8888);
        // 操作 输入输出输入操作
        //client.getInputStream();//输入流 相当于 获得服务器的响应数据
         //client.getOutputStream();//输出流 相当于 给服务器发送请求数据
         //对输入输出流进行封装 以便更好地操作数据
        DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        String data= "hello";
        dos.writeUTF(data);
        dos.flush();//强行冲刷剩余资源
        //释放那个资源
        dos.close();
        client.close();
    }

}
