package com.other;
/**
 * 指令重排: 代码执行顺序与预期不一致
 * 目的:提高性能
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class HappenBefore {
	//变量1
	private  static int a = 0;
	//变量2
	private static boolean flag = false;

	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<100;i++) {
			a = 0;
			flag = false;
			
			//线程1 更改数据
			Thread t1 = new Thread(()->{
				a = 1;
				flag = true;
			}) ;
			//线程2 读取数据
			Thread t2 = new Thread(()->{
				if(flag) {
					a *=1;
				}
				//指令重排   按理说这里应该不会执行的  因为有 join 的先后顺序  但是指令重排的话 可能会执行
				if(a == 0) {
					System.out.println("happen before a->"+a);    // 1 / 0 都有可能
				}
			}) ;
			
			t1.start();
			t2.start();
			
			//合并线程
			t1.join();
			t2.join();
		}
	}

}
