package com.status;

/**
 * 等待这个线程死亡。
 * 调用此方法的行为方式与调用完全相同
 * 然后再执行自己的方法
 *  join ： 合并线程  插队线程
 *  thread.join() 那个线程调用了join  哪个线程就先执行
 */
public class BlockedJoin01 {

    public static void main(String[] args) {

        //使用lambda表达式 建议一个线程
        Thread thread01 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("lambda-->" + i);
            }
        });
        thread01.start();

        for (int i = 0; i < 100; i++) {
            if (i==70){
                //主线程被阻塞  执行的是 thread01的线程
               thread01.yield();// 停止本线程的执行 去调用另一个线程（thread）的执行
            }
            System.out.println("main-->" + i);
        }
    //返回当前活动线程的估计数 不一定正确
        // 此方法主要用于调试
        //      *和监测目的。
        int i = Thread.activeCount();
        System.out.println(i);


    }


}
