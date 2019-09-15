package com.other;

		import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:比较并交换    是一种思想
 * CAS是一组原子操作，不会被外部打断
 * 属于硬件级别的操作（ 利用CPU的CAS指令，同时借助JNI来完成的非阻塞算法
 * CAS的效率要比加锁操作高  它用的不是锁（synchronized）
 * 只要带  Atomic的对象  原子性的操作 都实现了cas功能
 *
 * @author 裴新 QQ:3401997271
 *
 */
public class CAS {
	//库存
	private static AtomicInteger stock = new AtomicInteger(5);
	public static void main(String[] args) {
		for(int i=0;i<6;i++) {
			new Thread(()->{
				//模拟网络延时
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Integer left = stock.decrementAndGet();
				if(left<1) {
					System.out.println("抢完了...");
					return ;
				}
				System.out.print(Thread.currentThread().getName()+"抢了一件商品");
				System.out.println("-->还剩"+left);
			},"线程"+i+"  ") .start();
		}
	}

}
