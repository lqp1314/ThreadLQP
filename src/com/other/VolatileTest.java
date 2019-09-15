package com.other;
/**
 * volatile用于保证数据的同步，也就是可见性
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class VolatileTest {
	private volatile static int num = 0;   //添加volatile 保证数据的 同步
	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{
			while(num==0) { //此处不要编写代码   模拟电脑忙的不可开交
				//没有时间 及时的同步数据
				//一般情况下   没存在这种情况
			}
		}) .start();
		
		Thread.sleep(1000);
		num = 1;   //为1时   子线程停止
	}

}
