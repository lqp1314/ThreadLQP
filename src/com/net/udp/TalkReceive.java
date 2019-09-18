package com.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *  实现多线程的沟通方式
 *  *   接受端
 */
public class TalkReceive implements Runnable {
    private DatagramSocket server ;
    public TalkReceive(int port) {

        try {
            server=new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(true) {
            // 2、准备容器 封装成DatagramPacket 包裹
            byte[] container =new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            // 3、阻塞式接收包裹receive​(DatagramPacket p)
            try {
                server.receive(packet);//阻塞式
                // 4、分析数据
                byte[]  datas =packet.getData();
                int len = packet.getLength(); //接受到的实际数据长度
                String data=new String(datas,0,len);
                if(data.equals("bye")) {
                    System.out.println("对方已离线！！！");
                    break;
                }
                System.out.println(data);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        // 5、释放资源
        server.close();

    }
}
