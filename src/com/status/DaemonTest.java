package com.status;

/**
 * 守护线程 Thread.daemon 当运行的唯一线程都是守护进程线程时，Java虚拟机将退出。
 * 线程启动前必须调用此方法  在start方法之间调用  优先级（Priority也是）
 * 守护线程：是为用户线程服务的；jvm停止不用等待守护线程执行完毕
 * 默认：用户线程 jvm等待用户线程线程执行完毕才会停止
 */
public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        My my = new My();
        Thread thread = new Thread(god);
        Thread thread1 = new Thread(my);
        //将上帝的线程设为 守护线程  jvm停止不用等待守护线程执行完毕
        //如果不设置的话 在 my线程执行完之后 这个线程会任然执行 不会停止
        thread.setDaemon(true); //在start之前设置
        thread.start();
        thread1.start();
    }

    //将上帝的存活时间设为守护线程
  static class God implements Runnable{

      @Override
      public void run() {
          while(true){  //永久存活
              System.out.println("God still is ....");
          }
      }
  }
  //我的存活时间为默认用户线程
    static class My implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 365*100; i++) {
                System.out.println("wo  still life");
            }
        }
    }
}
