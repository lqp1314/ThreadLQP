package com.test;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();

      set.add("ss");
      set.add("ss");
      set.add("as");
      set.add("asa");
      set.add("oo");


        System.out.println(set);
        ArrayList<Object> list = new ArrayList<>();
        list.add("sas01");
        list.add("02");
        list.add("03");
        list.add("04");

        System.out.println(list);



        Collection<String> collection = new ArrayList<>();
       collection.add("gao");
       collection.add("gao");
       collection.add("sa");
       collection.add("ll");
       //collection.remove("gao"); //只会移走一个

        System.out.println(collection);


        Collection<String> collection01 = new ArrayList<>();
        collection01.add("gao");
        collection01.add("gao1");
        collection01.add("sa");
        //移除所有 和 collection01 一样的元素
        collection.removeAll(collection01);

        System.out.println(collection);


        System.out.println("****************");
        List<Object> arrayList = new ArrayList<>();
        arrayList.add("sss");
        arrayList.add("ssasas");
        arrayList.add("020");
        arrayList.add("sss");

        System.out.println(arrayList);

        //在指定位置插入元素 以前的元素后移
        arrayList.add(0,"01");
        System.out.println(arrayList);
        //修改指定位置的元素   list  默认是10
        arrayList.set(0,"001");
        System.out.println(arrayList);
        int indexOf = arrayList.indexOf("001");
        System.out.println(indexOf);

        System.out.println(arrayList.lastIndexOf("sss"));

      //数组   默认为0
        int a[]=new int[2];
        a[1]=12;
        for (int aa:a
             ) {
            System.out.println(aa);
        }


        System.out.println("*********");
        int as=10;
        int i = as << 1;
        System.out.println(i);

        LinkedList<Object> list1 = new LinkedList<>();

        list1.add("sss");
        list1.add("sasas");
        list1.addFirst("first  ");
        list1.addLast("last");
        System.out.println(list1);


         Set set1=new HashSet<>();
         set1.add("sas01");
        set1.add("sas02");
        set1.add("sas03");
        set1.add("sas04");
        System.out.println(set1);

        HashMap<Object, Object> map = new HashMap<>();

    }
}
