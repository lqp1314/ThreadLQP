package com.thread;

/**
 * Lambda表达式的推导
 *   从 外部类  到 内部类 到
 *   方法内部类  到
 *   匿名内部类  到lambda
 */

public class LambTest01 {
    //内部类
    static class Like2 implements ILike{
        public void lambda() {
            System.out.println("i like lambda2 ");
        }

    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();


        class Like3 implements ILike{
            public void lambda() {
                System.out.println("i like lambda3 ");
            }

        }

        like = new Like3();
        like.lambda();

        //匿名内部类
       like = new Like() {
           @Override
           public void lambda() {
               System.out.println(" i like lambda 表达式4");
           }
       };
        like.lambda();


        //lambda 接口 只有一个方法才可以
        //lambda  接口只能有一个方法才可以推到
        like = ()-> {
            System.out.println("i like lambda5 ");
        };
        like.lambda();

    }
}
interface  ILike{
    void lambda();
}
//外部类
class Like implements  ILike{
    @Override
    public void lambda() {
        System.out.println("i like lambda 1");
    }
}
