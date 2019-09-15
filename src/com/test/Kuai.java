package com.test;

/**
 * java 中 关于快 有 局部块 构造块 静态块
 * 局部方法快  在方法调用的时候 执行
 * 构造块 是 加载对象的时候使用的
 * 静态块 是 加载类信息使用的 只加载一次  先于构造块执行
 * 同步块 是 同步使用的
 *
 * 执行顺序
 * 我是静态块
 * 我是构造块
 * 我是方法快
 */
public class Kuai {

    {
        System.out.println("我是构造块");
    }

    static {
        System.out.println("我是静态块");
    }

    public static void main(String[] args) {
        Kuai kuai = new Kuai();

        {
            System.out.println("我是方法快");
        }
    }
}
