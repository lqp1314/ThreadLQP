package com.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全：操作容器
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class SynBlockTest02 {
	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<10000;i++) {
			new Thread(()->{
				//同步块
				synchronized(list) {
					list.add(Thread.currentThread().getName());
				}
			}) .start();
		}
		Thread.sleep(10000);
		System.out.println(list.size());
	}
}

