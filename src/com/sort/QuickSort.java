package com.sort;

import java.util.Arrays;

/**
 * 交换排序之----快速排序
 * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)　
 *快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 *
 * 6.1 算法描述
 * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 *
 * 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 *  使用到了递归的思想
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array= new int[]{9,3,56,4,6,8,20};
         qucikSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    private static void qucikSort(int[] array,int start,int end) {
          //递归的出口
        if (start>=end||array.length<2){
            return ;
        }

        //把数组中的第0个数字做为标准数
        int stard=array[start];
        //记录需要排序的下标  方便做下标的移动
        int low=start;
        int high=end;
        //以标准数为界 循环找比标准数大的数和比标准数小的数
        while (low<high){
            //右边的数字比标准数大 直接向左移一位继续比较直到找到小于的为止
            while (low<high&&stard<=array[high]){
                high--;
            }
            //左边的数小于标准数  使用右边的数字替换左边的数
             array[low]=array[high];
            //开始和左边的数字比较  如果左边的数字比标准数小 则继续移动
            while (low<high&&array[low]<=stard){
                low++;
            }
            //使用左边的数字替换右边的数字替换
            array[high]=array[low];
        }
       //当low=high时 把标准数赋给它 此时左边的都比标准数小 右边都比标准数大
       array[low]=stard;//array[high]=stard;
        //递归的处理剩下的数字   左边的数
        qucikSort(array,start,low);
        //右边的数
        qucikSort(array,low+1,end);

    }

}
