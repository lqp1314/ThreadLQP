package com.net.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 模拟登陆  单向
 *   创建 客户端
 *     创建客户端
 *  * 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
 *  * 2、操作: 输入输出流操作
 *  * 3、释放资源
 */
public class LoginClient {
    public static void main(String[] args) throws  Exception{
        System.out.println("---client---");
        //登录 需要连接控制台进行输入 system.in  需要进行字符字节流的转换
        BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名\n");
        String uname=console.readLine();// 换行表示结束
        System.out.println("请输入密码\n");
        String upwd=console.readLine();

        /// 建立连接 使用socket创建客户端+服务的地址+端口
        Socket client= new Socket("localhost",8888);
        //操作输入输出流
        DataOutputStream dos= new DataOutputStream(client.getOutputStream());
        dos.writeUTF(uname+"&"+upwd);
        dos.flush();

        //释放资源
        dos.close();
        client.close();


    }

}
