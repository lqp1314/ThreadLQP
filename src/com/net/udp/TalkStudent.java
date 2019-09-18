package com.net.udp;

/***
 * 实现多线程交流
 *  * 加入多线程，实现双向交流 模拟在线咨询
 教师 : 我不好
 教师 : 我不是
 不  你就是
 教师 : 不不不 你才是
 傻逼
 教师 : 你才是傻逼

 */

public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"localhost",9999),"学生").start(); //发送
        new Thread(new TalkReceive(8888)).start(); //接收
    }
}
