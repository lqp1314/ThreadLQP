package com.syn;
/**
 * 线程安全: 在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1、同步方法  同步方法的同步监视器监视器 为this 对象本身
 * 2、同步块 ,目标更明确  通过同步块 锁住具体的对象（obj）
 * obj推荐为 共享资源的 作为对象
 * obj 称之为同步监视器
 *
 * @author 裴新 QQ:3401997271
 *  
 */
public class SynBlockTest01 {
	public static void main(String[] args) {		
		//账户
		Account account =new Account(100,"结婚礼金");
		SynDrawing you = new SynDrawing(account,80,"可悲的你");
		SynDrawing wife = new SynDrawing(account,90,"happy的她");
		you.start();
		wife.start();
	}
}

////账户
//class Account{
//	int money;//金额
//	String name ; //名称
//
//	public Account(int money, String name) {
//		this.money = money;
//		this.name = name;
//	}
//}

 //模拟取款 线程安全
class SynDrawing extends Thread{
	Account account ; //取钱的账户
	int drawingMoney ;//取的钱数
	int packetTotal ; //口袋的总数	
	
	public SynDrawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test() ;
	}
	//目标锁定account
	public  void test() {
		//提高性能  当发现金额里面没有钱了 就不用去加入锁 去线程池中等待了  直接返回 提高性能
		if(account.money-drawingMoney<=0) {
			return ;
		}
		//同步块  对具体的操作数据的对象 进行锁  同步监视器
		synchronized(account) {
			if(account.money -drawingMoney<0) {
				return; 
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.money -=drawingMoney;
			packetTotal +=drawingMoney;
			System.out.println(this.getName()+"-->账户余额为:"+account.money);
			System.out.println(this.getName()+"-->口袋的钱为:"+packetTotal);
		}
	}
}
