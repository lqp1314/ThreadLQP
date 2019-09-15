package com.other;
/**
 * 可重入锁: 锁可以延续使用
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class LockTest01 {
	public void test() {
	//  第一次获得锁
        synchronized(this) {
            while(true) {
                //  第二次获得同样的锁
                synchronized(this) {
                    System.out.println("ReentrantLock!");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	public static void main(String[] args) {

	    new LockTest01().test();
	}

}
