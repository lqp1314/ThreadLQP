package com.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间 sleep 模拟时间倒计时
 */
public class BlockedSleep02 {
    public static void main(String[] args) throws InterruptedException {
        //倒计时   十秒倒计时
        Date date = new Date(System.currentTimeMillis() + 1000*10);
        long time = date.getTime();//1970.1.1 的秒数
        System.out.println(time);
        while(true){
            System.out.println(new SimpleDateFormat("mm:ss").format(date));
            Thread.sleep(1000);
            //过一秒后 重新设置date的时间
            date=new Date(date.getTime()-1000);
            if (time-1000*10>date.getTime()){
                break;
            }
        }
    }
}
