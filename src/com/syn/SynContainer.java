package com.syn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

/**
 * 线程安全：操作并发容器
 * 添加这类的并发容器后 就不用担心 锁定问题了
 * CopyOnWriteArrayList  涉及到的概念  可重入锁
 *
 * StringBuffer 也是
 * 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
 * 然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类
 * @author 裴新 QQ:3401997271
 *
 */
public class SynContainer {

	public static void main(String[] args) throws InterruptedException {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		for(int i=0;i<10000;i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}) .start();
		}
		Thread.sleep(1000);
		System.out.println(list.size());


		Test01();
	}

	static  void Test01() throws InterruptedException {
		//可以使用 Collections.synchronizedList(); 得到一个线程安全的 ArrayList。
		ArrayList<Object> list = new ArrayList<>();
		List<Object> synchronizedList = Collections.synchronizedList(list);
		for (int i = 0; i < 1000; i++) {
			new Thread(()->{
				synchronizedList.add(Thread.currentThread().getName());
			}).start();
		}
		Thread.sleep(1000);
		System.out.println("另一个方法的实现"+list.size());

	}

}

