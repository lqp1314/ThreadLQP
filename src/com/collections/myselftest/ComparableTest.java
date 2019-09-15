package com.collections.myselftest;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 测试 java.lang 包下的 排序
 */
public class ComparableTest implements  Comparable<ComparableTest>{
    private int age;
    private  String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComparableTest(String name,int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(ComparableTest o) {
        if (this.age>this.age){
            return 1;
        }else {
            return  -1;
        }
    }

    public static void main(String[] args) {
        System.out.println();
        TreeMap<ComparableTest, String> pdata = new TreeMap<ComparableTest, String>();
        pdata.put(new ComparableTest("张三", 30), "zhangsan");
        pdata.put(new ComparableTest("李四", 20), "lisi");
        pdata.put(new ComparableTest("王五", 10), "wangwu");
        pdata.put(new ComparableTest("小红", 5), "xiaohong");
        // 得到key的值的同时得到key所对应的值
        Set<ComparableTest> keys = pdata.keySet();
        for (ComparableTest key : keys) {
            System.out.println(key.getAge() + "-" + key.getName());

        }

        System.out.println("********************");

    /*    Iterator<ComparableTest> iterator = keys.iterator();
        for (Iterator<ComparableTest> e= iterator ;e.hasNext();) {
              System.out.println("********************");
          }
*/


        Set<Map.Entry<ComparableTest, String>> set = pdata.entrySet();
        Iterator<Map.Entry<ComparableTest, String>> iterator = set.iterator();
        for (Iterator<Map.Entry<ComparableTest, String>> it = iterator; it.hasNext(); ) {
            Map.Entry<ComparableTest, String> entry = it.next();
            System.out.println(entry.getKey()+entry.getValue());


        }
    }


}
