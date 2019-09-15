package com.thread;

/**
 * lambda推导+参数
 */
public class LambdaTest02 {
    public static void main(String[] args) {

        //静态的类 接口 抽象类  不可变的
        ILove love = (int a)->{
            System.out.println("i like lambda"+a);
        };
        love.lambda(100);

        //简化
        love=a -> {
            System.out.println("sasa"+a);
        };
        love.lambda(50);
        //如果只有一个参数的话 括号可以省略 会自动匹配
        love =a -> {
            System.out.println("i like lambda -->"+a);
        };

        love.lambda(5);


        //如果只有一行代码的话  大括弧+分号可以省略
        love =a ->System.out.println("i like lambda -->"+a);
        love.lambda(0);
    }


}


interface ILove{
    void lambda(int a);
}
//外部类
class Love implements ILove {

    @Override
    public void lambda(int a) {
        System.out.println("i like lambda -->" + a);
    }
}
