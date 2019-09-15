package com.test;

import java.math.BigInteger;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class QuickSortTest {
    private AtomicInteger stat=new AtomicInteger(0);

    //快速排序
    void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            for (int aa:s
            ) {
                System.out.print(aa+"\t");
            }
            //使用原子性的 integer 然后将其进行加1 操作
            System.out.println("\n*********"+"第"+ stat.addAndGet(1));
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }

    }

    public static void main(String[] args) {
        int a[]= {49,85,95,5,56,9,100};
        QuickSortTest test = new QuickSortTest();
        test.quick_sort(a,0,a.length-1);
        for (int aa:a
             ) {
            System.out.print(aa+"\t");

        }

    }
}
