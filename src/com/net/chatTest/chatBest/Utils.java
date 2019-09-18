package com.net.chatTest.chatBest;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @Author: lqp
 * @Date: 2019/9/18 12:30
 *   工具类  实现 资源释放
 */
public class Utils  {
    /**
     * 	/**
     * 	 * 释放资源
     * 	 Closeable   关闭的类   socket实现了 这个类 所以可以直接用
     *   IO 流都继承了这里类
     */

    public static  void close(Closeable... targets){
        for (Closeable target :
                targets) {
            try {
                //最好判断一个 这个类 是否不为空   如果为空 表示 还没有创建 就不用关闭
                if (target!=null){
                    target.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
