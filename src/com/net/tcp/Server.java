package com.net.tcp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  熟悉流程  服务器的 建立
 *    创建服务器
 *     1 指定端口 使用 ServerSocket创建服务器
 *     2  阻塞式等待连接  accept  获得一个客户端的连接
 *     3 操作 输入输出流操作
 *     4 释放资源
 */
public class Server {
    public static void main(String[] args) throws  Exception{
        System.out.println("---Server---");
        // 1、指定端口 使用ServerSocket创建服务器
        ServerSocket server= new ServerSocket(8888);
        //阻塞式 等待连接 accept   连接成功的话等于创建了一个客户端的连接
        Socket client= server.accept();
        System.out.println("一个客户端建立了连接");
        // 操作 输入输出操作
        //客户端的输入输出 和服务器端输入输出更好相反
        DataInputStream dis= new DataInputStream(new BufferedInputStream(client.getInputStream()));

        String data=dis.readUTF();
        System.out.println(data);
        //是否资源
        dis.close();
        client.close();
        server.close();
    }
}
