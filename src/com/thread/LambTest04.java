package com.thread;
/**
 * lambda推导
 *
 * @author 裴新 QQ:3401997271
 *
 */
public class LambTest04 {

    public static void main(String[] args) {
        new Thread(()->{
            for(int i=0;i<100;i++) {
                System.out.println("一边学习lambda");
            }
        }) .start();

        new Thread(()->	System.out.println("一边学习奔溃")) .start();
    }
}