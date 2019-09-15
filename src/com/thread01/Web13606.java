package com.thread01;

/**
 *  多线程   抢票
 */
public class Web13606 {

    public static void main(String[] args) {
        //一份资源
        Plane web = new Plane();
        //多个代理
        new Thread((Runnable) web,"码畜").start();
        new Thread((Runnable) web,"码农").start();
        new Thread((Runnable) web,"码蟥").start();
    }


  static   class Plane  implements  Runnable{

        private static  int ticket=20;//票数
        private  boolean flag=true;
        @Override
        public  void run() {
            while (flag){
                 //延迟模拟
                 try {
                     Thread.sleep(200);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 test();
             }

        }
   //加上 同步锁 就没事了
        public synchronized   void test()  {
            if (ticket<=0){
                flag=false;
                return;
            }
            //延迟模拟  添加延迟 可以测试 出票数为 负数的情况  因为他不是立即就去修改数据的 而是等待一会
            //这个等待的过程 会让其他的线程在不知道的情况下 也进来  会造成数据的 负数
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---->"+ticket--);
            }
        }


    }

