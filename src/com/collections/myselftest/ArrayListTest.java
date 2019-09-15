package com.collections.myselftest;

/**
 * 手写 ArrayList集合
 *  数据实现   默认为10  每次增长一半
 *  数据内容可重复     有顺序的数组 （索引下标）
 */
public class ArrayListTest {
    //设置数组
    private  Object[] elementData;
    private int size; //数组的大小   千万不能使静态的 因为静态的就是这个类所有了  而不是这个对象了
    //m默认数组的大小
    private static final int default_capacity=10;

    //构造函数 01  默认
    public ArrayListTest(){
        elementData=new Object[default_capacity];
    }
    //自定义的大小
    public ArrayListTest(int  capacity){
        if (capacity<0){
           //手动抛出异常
            throw  new RuntimeException("容量必须大于0");
        }else if(capacity==0){
            elementData=new Object[default_capacity];
        }else {
            elementData=new Object[capacity];
        }

    }


    //添加元素
    public  void add(Object element){
        //什么时候扩容
        if(size==elementData.length){
             //扩容操作   右移一位
            Object[] newArray=new Object[elementData.length+(elementData.length>>1)];
            //将老的数组赋值到新的数组里面  系统自带的操作
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData=newArray; //交换

        }

        elementData[size++]=element;
    }

    public  void  checkRange(int index ){
        //索引合法判断 [0,size)    10    0-9
        if(index<0||index>size-1){
            //不合法
            throw  new RuntimeException("索引不合法:"+index);
        }
    }
    public  Object get(int index){
        checkRange(index);
        return  elementData[index];
    }
    // 原来的元素被替换掉了
    public  void set(Object element,int index){
        checkRange(index);
        elementData[index]=element;
    }

    //打印数组元素
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int i=0;i<size;i++){
            stringBuilder.append(elementData[i]+",");
        }
        stringBuilder.setCharAt(stringBuilder.length()-1, ']');

        return  stringBuilder.toString();

    }

    public static void main(String[] args) {
        ArrayListTest s= new ArrayListTest();
        for (int i=0;i<80;i++){
            s.add("ss"+i);
        }
        System.out.println(s.size);
        s.set("lqp",5);
        System.out.println(s);
    }
}
