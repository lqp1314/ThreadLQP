package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
    创建线程的第三种方式
 使用Callable 实现   多线程    这个是 JUC里面的内容  和 run方法相比 它有返回值 可以抛出异常
 而run方法   对于异常只能try catch
 */
public class CallableTest implements Callable{
    @Override
    public Object call() throws Exception {
        //方法类型可以根据要返回值的类型进行确认
        String str="多线程创建的第三种方法";
        return str;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callableTest = new CallableTest();
        FutureTask task = new FutureTask<>(callableTest);
        Thread thread = new Thread(task);

        //启动线程
        thread.start();
        //获取call方法的返回值  先启动线程才可以取到call的返回值
        System.out.println(task.get());
    }
}
