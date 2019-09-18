package com.net.chatTest.chatBest;

/**
 * @Author: lqp
 * @Date: 2019/9/18 14:36
 */
public class TEST {
    public static void main(String[] args) {

        String  msg="李清坡:@王慧 我爱你";
        //如果是私聊  则要找到 是给谁私聊   切割
        String target = msg.split(":")[1];  //@李清坡 哈哈
        //因为名字不一样长  则只获取前两个
        String name = target.substring(1, 3);// 李清  切割字符  最右边的不包含
        System.out.println(name);
        System.out.println(msg.contains("李"));
        System.out.println(msg.subSequence(1,3));
    }


}
