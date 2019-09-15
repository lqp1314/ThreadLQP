package com.status;

/**
 * 线程的优先级   1-10   默认是5    不能超过它的范围
 *    线程的调度按照线程的优先级决定应该调用那个来执行
 * Thread.MAX_PRIORITY       10
 * 线程可以拥有的最大优先级。
 * static int MIN_PRIORITY    1
 * 线程可以拥有的最小优先级。
 * static int NORM_PRIORITY    5
 * 分配给线程的默认优先级。
 * 优先级的设定建议在start（）调用之前 优先级低只意味着获得调度的概率的低
 * 不是绝对的概念   这里是 概率  不代表先后顺序
 *
 * 在start（）就绪状态之前 加入线程的优先级
 */
public class PriorityTest {
    public static void main(String[] args) {
        //获得当前线程的优先级   默认是5
        System.out.println(Thread.currentThread().getPriority());

        Myself myself = new Myself();

        Thread th1 = new Thread(myself,"th1");
        Thread th2 = new Thread(myself);
        Thread th3 = new Thread(myself);
        Thread th4 = new Thread(myself);
        Thread th5 = new Thread(myself);
        Thread th6 = new Thread(myself);
        Thread th7 = new Thread(myself);
     //在start（）就绪状态之前 加入线程的优先级
        th1.setPriority(Thread.MAX_PRIORITY);//设置线程的优先级  priority
        th2.setPriority(10);
        th2.setPriority(6);
        th2.setPriority(9);
        th2.setPriority(8);
        th2.setPriority(Thread.MIN_PRIORITY);
         th7.setPriority(Thread.MAX_PRIORITY);
     //q开启线程
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
        th7.start();
    // 9个 当前的线程加上 主线程 加一个父线程
        System.out.println("查看有多少个线程在运行"+Thread.activeCount());
    }



    static  class Myself implements Runnable{

        @Override
        public void run() {
            ///打印线程的名字和优先级
            System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
        }
    }

}
