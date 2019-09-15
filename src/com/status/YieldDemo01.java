package com.status;

/**
 * yield 和 sleep都是 静态方法  都可以直接调用  Thread.yield();
 * yield方法 是将当前正在运行的线程  直接转入 就绪状态 释放cpu的资源 让别的线程执行 也可能还是自己执行由 cpu调度器重新调度
 * sleep是阻塞线程 然后进入就绪状态  而 yield  不用走阻塞的路径
 *
 *  Runnable 接口的好处 就是 可以让多个线程共享资源
 */
public class YieldDemo01 {
    public static void main(String[] args) {
        Myself myself = new Myself(); //静态的类才可以
        //让这俩个线程 可以互相礼让
        new  Thread(myself,"a").start();
        new  Thread(myself,"b").start();
    }


   static class Myself implements  Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"--->"+"start");
            Thread.yield(); // 礼让线程
            System.out.println(Thread.currentThread().getName()+"--->"+"end");
        }
    }
}

