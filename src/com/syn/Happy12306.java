package com.syn;
/**
 * 快乐火车票
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class Happy12306 {

	public static void main(String[] args) {
		Web12306 c = new Web12306(4,"happy sxt");
		new  Passenger(c,"老高",3).start();
		new  Passenger(c,"老裴",2).start();
	}

}
//顾客
class Passenger extends  Thread{
	int seats;
	//线程套线程
	public Passenger(Runnable target,String name,int seats) {
		super(target,name);
		this.seats = seats;
	}
	
}
//火车票网
class Web12306 implements Runnable{
	volatile int available; //可用的位置
	String name; //名称
	public Web12306(int available, String name) {
		this.available = available;
		this.name = name;
	}
	
	public void run() {
		// 当前线程 转为子类
		Passenger p = (Passenger)Thread.currentThread();
		Thread thread = Thread.currentThread();

		boolean flag = this.bookTickets(p.seats);
			if(flag) {
				System.out.println("出票成功"+Thread.currentThread().getName()+"-<位置为:"+p.seats);
			}else {
				System.out.println("出票失败"+Thread.currentThread().getName()+"-<位置不够");			
			}
	}
	//购票
	//public synchronized boolean bookTickets(int seats)
    //这里可以不用 synchronized  也可以用 volatile 代替
	public  boolean bookTickets(int seats){
		System.out.println("可用位置为:"+available);
		if(seats>available) {
			return false;
		}
		available -=seats;
		System.out.println("剩余位置："+available);
		return true;
	}
}