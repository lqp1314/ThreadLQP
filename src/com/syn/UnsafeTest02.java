package com.syn;
/**
 * 线程不安全：取钱
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class UnsafeTest02 {
	public static void main(String[] args) throws InterruptedException {
		//账户
		Account account =new Account(100,"结婚礼金");
		Drawing you = new Drawing(account,80,"可悲的你");
		Drawing wife = new Drawing(account,90,"happy的她");
		you.start();
		//you.join(); //加上 join方法 让 you 先操作
		wife.start();
	}
}
//账户
class Account{
	volatile int money;//金额
	String name ; //名称

	public Account(int money, String name) {
		this.money = money;
		this.name = name;
	}
}
//模拟取款
class Drawing extends Thread{
	Account account ; //取钱的账户
	int drawingMoney ;//取的钱数
	int packetTotal ; //口袋的总数	
	
	public Drawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		if(account.money -drawingMoney<0) {
			System.out.println("没钱了");
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(this.getName()+"在数据操作之前 获得的数据："+account.money);
		account.money -=drawingMoney;
		packetTotal +=drawingMoney;
		System.out.println(this.getName()+"-->账户余额为:"+account.money);
		System.out.println(this.getName()+"-->口袋的钱为:"+packetTotal);
	}
	
} 
