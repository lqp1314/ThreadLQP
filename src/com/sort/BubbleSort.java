package com.sort;

import java.util.Arrays;

/**
 * 交换排序之----冒泡排序算法
 * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 *1、冒泡排序（Bubble Sort）
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 *
 * 1.1 算法描述
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * 重复步骤1~3，直到排序完成。
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array=new int[]{2,33,55,63,6,9};

        bubbleSort01(array);
        System.out.println(Arrays.toString(array));

    }

    /**
     *
     * @param array
     * @return
     */
     public static int[] bubbleSort(int array[]){

         //比较的次数
         for (int i = 0; i < array.length - 1; i++) {
              //每一层比较的次数 逐渐变少
             for (int j = 0; j < array.length-1-i; j++) {

                 if (array[j]>array[j+1]){
                     int temp= array[j+1];
                     array[j+1]=array[j];
                     array[j]=temp;
                 }
             }

             System.out.println(Arrays.toString(array));
         }
         return  array;
     }
    /**
     * [2, 33, 55, 6, 9, 63]
     * [2, 33, 6, 9, 55, 63]
     * [2, 6, 9, 33, 55, 63]
     * [2, 6, 9, 33, 55, 63]
     * [2, 6, 9, 33, 55, 63]
     * [2, 6, 9, 33, 55, 63]
     *
     * 剩下的排序是多余的 没有必要往下进行  这里使用 标记进行优化处理
     */
    public static int[] bubbleSort01(int array[]){


        //比较的次数
        for (int i = 0; i < array.length - 1; i++) {
           boolean flag=false;
            //每一层比较的次数 逐渐变少
            for (int j = 0; j < array.length-1-i; j++) {

                if (array[j]>array[j+1]){
                    int temp= array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                    flag=true;
                }
            }
            if (!flag){  //如果标记为true 表示没有进行比较  也就是说 已经是排好序的元素了  所以直接返回数组就行了 没必要继续进行
                return  array;
            }
            System.out.println(Arrays.toString(array));
        }
        return  array;
    }

}


