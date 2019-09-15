package com.status;

/**
 * 终止线程
 *   线程正常执行完毕 --》次数的设定
 *   外部干涉 -- 加入标识
 *   不要使用stop  destory 方法
 */
public class TerminateThread implements  Runnable{


    private volatile boolean flag=true;
    private  String name;
    public TerminateThread(String name){
        this.name=name;
    }
    @Override
    public void run() {
        int i=0;
        while(flag){
            System.out.println(name+"--->"+i++);
        }
    }
    public void  lag(){
        this.flag=false;
    }




    public static void main(String[] args) throws InterruptedException {
        TerminateThread thread1 = new TerminateThread("C罗");
        Thread thread = new Thread(thread1);

                thread.start();

        //Thread.sleep(200);  //停顿一会 效果更好
        //thread.join();  //如果让 thread执行 那么 就进行不了下面了

        thread.join(200); //先执行一会 这个线程 然后再重新分配
        for (int i=0;i<100;i++){
            if (i==19){
                thread1.lag();  //不可能是到达 C罗到达19 才会停的  这个和那个没关系   哈哈
                System.out.println("信息");
            }
            System.out.println("main-"+i);
        }



    }
}
