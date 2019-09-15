package com.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全：操作容器  有的数据被覆盖  没有达到相应的数据
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class UnsafeTest03 {
	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<10000;i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}) .start();
		}
		System.out.println(list.size());
	}
}

