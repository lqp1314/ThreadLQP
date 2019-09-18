package com.net.chatTest.chatBest;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author: lqp
 * @Date: 2019/9/18 13:13
 * 在线聊天室: 客户端
 *  * 目标: 加入容器实现群聊
 *
 *  //  这里可以建立多个客户端  开启多个线程 是他们实现群聊
 */
public class Client01 {
    public static void main(String[] args) throws IOException {
          //1、建立连接: 使用Socket创建客户端 +服务的地址和端口
        Socket client = new Socket("localhost",8888);// 连接服务器的端口和 主机
       //2、客户端发送消息   添加线程的姓名
        new Thread(new Send(client),"李清坡").start();
        new Thread(new Receive(client)).start();


    }
}
