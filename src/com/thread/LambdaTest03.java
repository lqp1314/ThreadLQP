package com.thread;

/**
 * lambda推导+参数 + 返回值
 */
public class LambdaTest03 {


    public static void main(String[] args) {

        IInterest iInterest=(int a,int b)->{
            return  a+b;
        };

        iInterest.lambda(200,200);

        iInterest = (a,c)-> {
            return a+c;
        };

        //如果接口方法里 只有一个返回值 那么可以直接写返回的内容  return也可以不写

        iInterest = (a,c)-> a+c;

        iInterest = (a,c)-> 100;

        System.out.println(iInterest.lambda(10, 20));
    }


}
interface IInterest{
    int lambda(int a,int b);
}
//外部类
class Interest implements IInterest{

    @Override
    public int lambda(int a,int c) {
        System.out.println("i like lambda -->"+(a+c));
        return a+c;
    }

}