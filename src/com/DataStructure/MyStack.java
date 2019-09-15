package com.DataStructure;

/**
 * 栈的应用
 */
public class MyStack {
   //栈的底层 我们使用数组来存储数据
    int[] arry  ;
    public MyStack(){
        arry=new int[0];
    }

    //亚茹元素
    public  void  push(int element){
        //创建一个新的数组
        int [] newArry=new int[arry.length+1];
        for (int i = 0; i < arry.length; i++) {
            newArry[i]=arry[i];
        }
        newArry[arry.length]=element;
        arry=newArry;
    }

    //出栈
    public int pop(){
        //如果栈底没有元素
        if (arry.length==0){
         throw new RuntimeException("展示空的");
        }
        //从最后一个元素还是出去
        int last=arry[arry.length-1];
        //创建新的数组
         int[] newArry= new int[arry.length-1];
        for (int i = 0; i < newArry.length; i++) {
            newArry[i]=arry[i];
        }
        //替换数组
        arry=newArry;
        return last;
    }


    //查看栈顶元素
    public int peek() {
        //栈中没有元素
        if(arry.length==0) {
            throw new RuntimeException("stack is empty");
        }
        return arry[arry.length-1];
    }
    //判断栈是否为空
    public boolean isEmpty() {
        return arry.length==0;
    }

    public static void main(String[] args) {
        MyStack  stack= new MyStack();
        stack.push(2);
        stack.push(4);

        System.out.println(stack.pop());
    }

}


