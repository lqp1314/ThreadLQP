package com.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ���Ե���������List��Set��Map
 * @author ���
 *
 */
public class TestIterator {
	public static void main(String[] args) {
//		testIteratorList();
//		testIteratorSet();
//		testIteratorMap();
		
		testRemove();
	}
	
	public static void testIteratorList(){
		List<String>  list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		//ʹ��iterator����List
		for(Iterator<String> iter=list.iterator();iter.hasNext();){
			String  temp = iter.next();
			System.out.println(temp);
		}
		
	}
	
	public static void testIteratorSet(){
		Set<String>  set = new HashSet<>();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		
		//ʹ��iterator����Set
		for(Iterator<String> iter=set.iterator();iter.hasNext();){
			String  temp = iter.next();
			System.out.println(temp);
		}
		
	}
	
	public static void testIteratorMap(){
		Map<Integer,String> map1 = new HashMap<>();
		map1.put(100, "aa");
		map1.put(200, "bb");
		map1.put(300, "cc");
		

		//��һ�ֱ���Map�ķ�ʽ
		Set<Entry<Integer,String>>  ss =  map1.entrySet();
		for(Iterator<Entry<Integer,String>> iter=ss.iterator();iter.hasNext();){
			Entry<Integer,String> temp = iter.next();
			
			System.out.println(temp.getKey()+"--"+temp.getValue());
			
		}
		System.out.println("++++++++++++++++++++++++");
		//�ڶ��ֱ���Map�ķ�ʽ
		Set<Integer>  keySet = map1.keySet();
		for(Iterator<Integer> iter=keySet.iterator();iter.hasNext(); ){
			Integer key = iter.next();
			System.out.println(key+"----"+map1.get(key));
		}
		
		
	}
	
	//���Ա߱�������ɾ��
	public static void testRemove(){
		List<String> list = new ArrayList<>();
		for(int i=0;i<20;i++){
			list.add("gao"+i);
		}
		
		for(int i=0;i<list.size();i++){
			String temp = list.get(i);
			if(temp.endsWith("2")){
				list.remove(i);
			}
			System.out.println(list.size()); 
			System.out.println(list.get(i));  
		}
		
		
	}
	
}
