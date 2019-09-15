package com.thread01;

import com.thread.Thread01;

/**
 *  创建线程方式二
 *   接口 Runnable方式
 *   创建：实现Runnable+ 重写run
 *   启动 创建实现类对象+Thread对象+start
 *   推荐使用  优先使用接口
 *   方便共享资源
 */
public class StartRun implements  Runnable {
    //继承run方法
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("我要唱歌");
        }
    }

    public static void main(String[] args) {
//        //创建实现类对象
//        StartRun startRun = new StartRun();
//        //创建代理类对象
//        Thread thread = new Thread(startRun);
//        //启动
//       thread.start();// 不保证立即运行 cpu调用
//     //thread.run();
        //如果是只有一个方法运行的话  可以使用内部类的形式
        Thread thread1 = new Thread(new StartRun());
        thread1.start();

        for(int i=0;i<100;i++){
            System.out.println("我要喝酒");
        }
        //三个
        System.out.println("查看有多少个线程在运行"+Thread.activeCount());



//        Thread01 thread0=new Thread01();
//        Thread01 thread01=new Thread01();
//        Thread01 thread011=new Thread01();
//        long l = System.currentTimeMillis();
////多线程执行
//        thread0.start();
//         thread01.start();
//        thread011.start();
//
////        //单线程执行
////        thread0.run();
////        thread01.run();
////        thread011.run();
//
//        long l1l = System.currentTimeMillis();
//        System.out.println(l1l-l);
    }
}
