package com.other;
/**
 * InheritableThreadLocal:继承上下文 环境的数据 ，拷贝一份给子线程
 * @author 裴新 QQ:3401997271
 *
 */
public class ThreadLocalTest04 {	
	private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
	public static void main(String[] args) throws InterruptedException {
		threadLocal.set(2);
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());	
		
		//线程由main线程开辟    InheritableThreadLocal:继承上下文   会继承该ThreadLocal的内容  并且子线程可以进行修改
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());	
			threadLocal.set(200);
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());	
		}) .start();


		//再次查看main线程里面的数值 是否被修改  加上sleep（） 等待一下再获取数据
	//	Thread.sleep(200);
		threadLocal.set(300);
		System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get()); //2
		//还是2   虽然是继承过去的值 但是 依然是 子线程的值的修改 不会影响到主线程
		// 但是主线程的修改会影响到子线程   set的修改必须写在 子线程启动之前 不然没有效果
	}	
	
	
 }
