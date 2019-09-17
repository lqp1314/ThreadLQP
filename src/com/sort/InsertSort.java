package com.sort;

import java.util.Arrays;

/**
 * 插入排序 ----- 直接插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array=new int[]{2,33,55,63,6,9};
        insertSort(array);
        System.out.println(Arrays.toString(array));

    }

    private static void insertSort(int[] array) {
        //以第一个数字为 有序数列 然后后面的数字 依次按顺序插入
        for (int i = 1; i < array.length; i++) {
            //如果当前数字比前一个数字小
            if (array[i]<array[i-1]){
                //把当前遍历的数字存起来 以此和已经排好的队列进行比较
                int temp=array[i];
                int  j ;
                // 遍历当前数字前面所有的数字 看看插入到什么地方
                for (j=i-1;j>=0&&temp<array[j];j--){
                    //把前一个数字 赋给后一个数字
                    array[j+1]=array[j];
                }
                //把临时变量（外层for循环的当前元素）赋给不满足条件的后一个元素
               array[j+1]=temp;
            }
        }
    }



}

