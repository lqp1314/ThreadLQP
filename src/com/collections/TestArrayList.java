package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 測試
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add("sas");
        list.add("ss");
        list.add("as");

      //  Collections.sort(list);
        //做排序判斷
        list.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1.hashCode()>o2.hashCode()){
                    return  1 ;
                }else{
                    return  -1;
                }
            }
        });
        System.out.println(list);


        for (Object object:
             list)
            System.out.println(object);
    }
}

