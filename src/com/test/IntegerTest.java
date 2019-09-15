package com.test;

import java.util.*;

/**
 * 自动装箱后 数据类型的变化
 */
public class IntegerTest {
     Integer xx;
     int ll=10;
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
      //  System.out.println(IntegerTest.class.getField("xx"));
         IntegerTest integerTest= new IntegerTest();
        //反射
         System.out.println(integerTest.getClass().getDeclaredField("xx").get(integerTest));
        Integer y = 3;
      //  System.out.println(x == y);// true
        Integer a = new Integer(3);
        Integer b = new Integer(3);
        Integer k=3;
        String kk ="33";
        String intern = kk.intern();
        System.out.println("你好s"+ (intern==kk));
        System.out.println(Objects.equals(kk,intern));;
        System.out.println(a == b);//false
        System.out.println(a.equals(b));//true


        List<String> list = Arrays.asList("asas", "sas", kk);
        System.out.println(list);
        list.add("sas");
        System.out.println(list);

        Collections.reverse(list);
    }
}
