package com.collections.myselftest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 使用 java.util 包下的 comparator 接口
 */
public class ComparatorTest {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add("s1");
        list.add("s5");
        list.add("s2");
        list.add("s3");
        list.add("s5");
        list.add("s4");
        list.add("s5");
        System.out.println(list);
        Collections.reverse(list);// 顺序翻转
        System.out.println(list);
        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {

                if (o1.hashCode()>o2.hashCode()){  //比较hashcode
                    return  1;
                }else{
                    return  -1;
                }

            }
        });
        System.out.println(list);
    }
}
