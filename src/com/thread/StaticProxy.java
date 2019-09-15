package com.thread;

/**
 * 静态代理模式
 *   公共接口：
 *     真实角色
 *     代理角色
 */
public class StaticProxy {

    public static void main(String[] args) {
        Marry marry= new You();
        WeddingCompany company= new WeddingCompany(marry);
        company.happMarry();
    }
}

interface  Marry{
    void happMarry();
}
//真实角色
class You implements Marry{

    @Override
    public void happMarry() {
        System.out.println("恭喜你 结婚了");
    }
}

//代理对象
class WeddingCompany implements  Marry{

    //真实对象  必须存在  可以是具体的对象  也可以是接口对象 最好是接口 因为可以换
    private Marry  marry;

    //构造器 用来接存 marry 对象
    public  WeddingCompany(Marry marry){
        this.marry=marry;
    }
    @Override
    public void happMarry() {
        System.out.println("我祝福你！！");
        this.marry.happMarry();  //这个 happmarry方法 必须是要代理类的 方法
        System.out.println("我是你的新郎");
    }
}
