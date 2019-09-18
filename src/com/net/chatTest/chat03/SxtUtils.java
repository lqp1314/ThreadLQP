package com.net.chatTest.chat03;

import java.io.Closeable;

/**
 * 工具类
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class SxtUtils {
	/**
	 * 释放资源
	 Closeable   关闭的类   socket实现了 这个类 所以可以直接用
	 clas...   自=自定义多个 数组  很有用的类 在不知道具体几个类的时候 使用
	 */
	public static void close(Closeable... targets ) {
		for(Closeable target:targets) {
			try {
				if(null!=target) {
					target.close();
				}
			}catch(Exception e) {
				
			}
		}
	}
}
