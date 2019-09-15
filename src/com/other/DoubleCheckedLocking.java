package com.other;
/**
 * DCL单例模式: 懒汉式套路基础上加入并发控制，保证在多线程环境下，对外存在一个对象
 * 1、构造器私有化 -->避免外部new构造器
 * 2、提供私有的静态属性 -->存储对象的地址
 * 3、提供公共的静态方法 --> 获取属性
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class DoubleCheckedLocking {
	//2、提供私有的静态属性
	//没有volatile其他线程可能访问一个没有初始化的对象  因为在多线程情况下 在new对象 和取对象的时候 可能出现指令重排
	private static volatile DoubleCheckedLocking instance;	
	//1、构造器私有化 
	private DoubleCheckedLocking() {		
	}
	//3、提供公共的静态方法 --> 获取属性
	public static DoubleCheckedLocking getInstance() {	
		//再次检测     提高性能
		if(null!=instance) { //避免不必要的同步 ，已经存在对象
			return instance;
		}
		synchronized(DoubleCheckedLocking.class) { //直接进行同步的话  那么可能会存在延迟等问题  多个线程进入 多了一个不必要的等待  所以要进行上面的再次检测 提高性能
			if(null == instance) {				
				instance = new DoubleCheckedLocking();
				//1、开辟空间 //2、初始化对象信息 //3、返回对象的地址给引用
			}
		}
		return instance;
	}	
	public static DoubleCheckedLocking getInstance1(long time) {		
			if(null == instance) {
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new DoubleCheckedLocking();
				//1、开辟空间 //2、初始化对象信息 //3、返回对象的地址给引用
			}
		return instance;
	}
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			System.out.println(DoubleCheckedLocking.getInstance());
		}) ;
		t.start();
		System.out.println(DoubleCheckedLocking.getInstance());
	}

}
