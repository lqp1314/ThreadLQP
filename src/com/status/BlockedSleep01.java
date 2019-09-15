package com.status;

/**
 * sleep 模拟 网络延迟 放大了发生问题的可能性
 * sleep指定当前线程阻塞的毫秒数  存在异常
 * sleep时间到达后 线程进入就绪状态  而不是 运行状态 切记
 * 每个对象都有一个锁  sleep不会释放锁
 */

/**
 *   网络延时   数据不准确   和并发有关
 *
 *   如在抢火车票的时候的时间延长情况  就会导致 数据出错
 */
 public class BlockedSleep01 {
}
