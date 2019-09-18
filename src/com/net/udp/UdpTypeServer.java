package com.net.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpTypeServer {
    public static void main(String[] args) throws  Exception {
        DatagramSocket server = new DatagramSocket(6666);

       DatagramPacket packet= new DatagramPacket(new byte[1024*20],1024*20);

       server.receive(packet);
       byte[] datas=packet.getData();
       DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
       //顺序写出
        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readChar());
        System.out.println(dis.readChar());

        server.close();
    }

    }

