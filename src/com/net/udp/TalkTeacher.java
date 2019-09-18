package com.net.udp;

/**
 * 实现多线程 ---教师端
 *  * 加入多线程，实现双向交流 模拟在线咨询
 *
 *  学生 : 你好
 * 我不是
 * 学生 : 不  你就是
 * 不不不 你才是
 * 学生 : 傻逼
 * 你才是傻逼
 */
public class TalkTeacher {

    public static void main(String[] args) {
        new Thread(new TalkReceive(9999)).start(); //接收
        //加上 线程的名字
        new Thread(new TalkSend(5555,"localhost",8888),"教师").start(); //发送
    }
}
