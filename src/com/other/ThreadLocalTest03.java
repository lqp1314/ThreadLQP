package com.other;
/**
 * ThreadLocal:分析上下文 环境  起点
 * 1、构造器: 哪里调用 就属于哪里 找线程体
 * 2、run方法:本线程自身的
 * @author 裴新 QQ:3401997271
 *
 */
public class ThreadLocalTest03 {	
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()-> 1);
	public static void main(String[] args) {
		new Thread(new MyRun()).start();
		new Thread(new MyRun()).start();
	}	
	public static  class MyRun implements Runnable{
		public MyRun() {  //这里面的 ThreadLocal 是 属于 main方法的  而不是新线程的  构造器: 哪里调用 就属于哪里 找线程体
			threadLocal.set(-100);
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());	//-100
		}
		public void run() { //在new Thread().start（） 方法之后调用  属于新线程的
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());	//1
			//new Thread(new MyRunxxx()).start();
		}
	}
	
}
