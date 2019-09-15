package com.thread;

/**
 *  Lambda 表达式 简化线程（用一次）的使用
 *  Lamda表达式  只适合接口 有一个方法的时候   如果是俩个方法 就会出问题
 */
public class LambdaThread {



    //静态内部类 内部类的好处  如果外部类不访问 就不会被加载 节省资源
    static class Test implements  Runnable{

        @Override
        public void run() {
            for (int i = 0; i <20; i++) {
                System.out.println("一边听歌");
            }
        }
    }

    public static void main(String[] args) {
        //最初的方法
        //new Thread(new Test()).start();
        //局部内部类
        class Test2 implements Runnable{
            public void run() {
                for(int i=0;i<20;i++) {
                    System.out.println("一边听歌");
                }
            }
        }
        new Thread(new Test2()).start(); //写的还是不太方便

        //匿名内部类   必须借助接口或者父类
        //如果是接口 必须实现方法 不然会报错
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("一般听哦");
                }
            }
        }).start();   //也是不太方便

        //jdk8 简化  lambda表达式  只有简单的类或 接口才会使用lambda表达式 目的是为了简化操作
        //  接口里面 只有一个方法的可以推到出来 要是俩个的话 就无法识别了
       new Thread(()->{
           for (int i = 0; i < 20; i++) {
               System.out.println("我是lambda 表达式  哈哈哈");
           }
       }).start();





    }
}
