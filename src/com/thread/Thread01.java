package com.thread;

public class Thread01 extends  Thread {
    @Override
    public void run() {
       Test test = new Test();
        try {
            test.ss();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Thread01 thread=new Thread01();
        Thread01 thread01=new Thread01();
        Thread01 thread011=new Thread01();
        long l = System.currentTimeMillis();
//多线程执行
//        thread.start();
//         thread01.start();
//        thread011.start();
//
        //单线程执行
        thread.run();
        thread01.run();
        thread011.run();

        long l1l = System.currentTimeMillis();
        System.out.println(l1l-l);


    }
}
