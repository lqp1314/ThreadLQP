package com.net.net01;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL: 统一资源定位器,互联网三大基石之一(html http),区分资源
 * 1、协议
 * 2、域名、计算机
 * 3、端口: 默认80
 * 4、请求资源
 *  http://www.baidu.com:80/index.html?uname=shsxt&age=18#a
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class URLTest01 {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.baidu.com:80/index.html?uname=shsxt&age=18#a");
		//获取四个值
		System.out.println("协议:"+url.getProtocol());
		System.out.println("域名|ip:"+url.getHost());
		System.out.println("端口:"+url.getPort());
		//获取此URL的文件名。 返回的文件部分将与getPath()相同，加上值为getQuery() （如果有）。 如果没有查询部分，此方法和getPath()将返回相同的结果。
		System.out.println("请求资源1:"+url.getFile());
		//获取这个 URL的路径部分。
		System.out.println("请求资源2:"+url.getPath());
		
		//参数
		System.out.println("参数:"+url.getQuery());
		//锚点
		System.out.println("锚点:"+url.getRef());
	}

}
