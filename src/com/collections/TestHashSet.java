package com.collections;

import java.util.*;

/**
 * ����HashSet�Ļ����÷�
 * Set:û��˳�򣬲����ظ���
 * List����˳�򣬿��ظ���
 * @author Administrator
 *
 */
public class TestHashSet {
	public static void main(String[] args) {
		Set<String>  set1 = new HashSet<>();
		
		set1.add("aa");
		set1.add("bb");
		set1.add("aa");
		System.out.println(set1);
		set1.remove("bb");
		System.out.println(set1);
		
	
		Set<String>  set2 = new HashSet<>();
		set2.add("���");
		set2.addAll(set1);
		System.out.println(set2);


		Hashtable<Object, Object> hashtable = new Hashtable<>();

		int l=1>>30 ;
		System.out.println(l);   //10亿   hashmap 的最大不超过 10 亿
/*
这个算法应该如何设计呢？

我们首先可能会想到采用%取余的操作来实现。但是，重点来了：“取余(%)操作中如果除数是2的幂次则等价于与其除数减一的与(&)操作（也就是说 hash%length==hash&(length-1)的前提是 length 是2的 n 次方；）。”
并且 采用二进制位操作 &，相对于%能够提高运算效率，
这就解释了 HashMap 的长度为什么是2的幂次方。
 */
		System.out.println(44 & 7);
		System.out.println(44%8);
		System.out.println(Math.log10(1000));


		//TreeMap<Object, Object> map = new TreeMap<>();
		HashMap<Object, Object> map = new HashMap<>();
		map.put("01","sa");
		map.put("02","sa");
		map.put("03","sa");
		map.put("04","sa");
		map.put("05","sa");
		map.put("06","sa");
//		Set<Map.Entry<Object, Object>> set = map.entrySet();
//		Iterator<Map.Entry<Object, Object>> entryIterator = set.iterator();
//		for (entryIterator.hasNext();
//			 entryIterator){
//
//		}

		Set<Object> set = map.keySet();
		for (Object o :
				set) {
			System.out.println(o.toString());
		}
		
		//迭代器 方法1  
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("A", "高淇");
		map1.put("B", "高小七");
		Set<Map.Entry<String, String>> ss = map1.entrySet();

		for (Iterator<Map.Entry<String, String>> iterator = ss.iterator(); iterator.hasNext();) {
			Map.Entry<String, String> next = iterator.next();
			System.out.println(next.getKey() + "--" + next.getValue());
		}


	}
}
