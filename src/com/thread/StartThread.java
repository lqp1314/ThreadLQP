package com.thread;

/**
 * 创建线程的方式01   使用 thread 继承
 *   1 创建： 继承Thread+ 重新run 方法
 *   2 启动   创建子类对象 +start启动线程
 */
public class StartThread  extends Thread{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("我要唱歌");
        }
    }

    public static void main(String[] args) {
        //先开启线程 然后在执行 主方法里面的任务
        StartThread startThread= new StartThread();
        startThread.start();//  交给JVM给开线程
        //startThread.run();// 如果这个线程使用单独的Runnable运行对象构造，则调用该Runnable对象的run方法; 否则，此方法不执行任何操作并返回。
        for(int i=0;i<10;i++){
            System.out.println("我要喝酒");
        }
        System.out.println("查看有多少个线程在运行"+Thread.activeCount());

    }
}
