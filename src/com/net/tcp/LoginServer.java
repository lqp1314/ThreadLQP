package com.net.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/** 模拟登录 单向
 * 创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作: 输入输出流操作
 * 4、释放资源
 *
 */
public class LoginServer {

    public static void main(String[] args) throws  Exception{
        // 1、指定端口 使用ServerSocket创建服务器
        ServerSocket server =new ServerSocket(8888);
        // 2、阻塞式等待连接 accept
        Socket client =server.accept();
        System.out.println("一个客户端建立了连接");
        // 3、操作: 输入输出流操作
        DataInputStream dis= new DataInputStream(client.getInputStream());
        String data=dis.readUTF();
        System.out.println(data);
        /* 分析数据 */
        String[] datas=data.split("&");
        if (datas[0].equals("lqp")&&datas[1].equals("1234")){
            System.out.println("用户登录成功");
        }else {
            System.out.println("登录失败");
        }

    }


}
