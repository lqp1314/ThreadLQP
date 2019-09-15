package com.collections.myselftest;

import javafx.beans.binding.ObjectExpression;

/**
 * 自定义的链表数组 实现
 * 添加 删除 方便 查询麻烦
 */
public class LinkedListTest<E> {

    private  Node first;  //首个元素
    private  Node last; //z最后一个

    private int size; // 长度

    //添加数据
    public void add(E element){
        Node node= new Node(element);
        if (first==null){  //是否是第一个元素
            first=node;
            last=node;
        }else{
            node.previous=last;  //指向最后一个元素  因为他就变成了最后一个
            node.next=null;

            last.next=node; //上一个元素 指向它
            last=node;  //   自己变成最后一个元素
        }
        size++ ;  //元素+1
    }

    //确定边界
    private  void  checkRange(int index){
        if(index<0||index>size-1){
            throw  new RuntimeException("索引数字不合法:"+index);
        }
    }

    private Node getNode(int index){
        checkRange(index);
        Node temp= null;
        //通过类似于二分法的方式 缩小查找范围
        if (index<=(size>>1)){
            //从头找
            temp=first;
            for (int i=0;i<index;i++){
                temp=temp.next;  //一个一个往下移动
            }
        }else{
            //从尾部找
            temp=last;
            for (int i=size-1;i>index;i--){
                temp=temp.previous;
            }
        }
        return  temp;
    }
    //获得元素的真正 方法   所以说 速度很慢
    public E get(int index){
        checkRange(index);
        Node node = getNode(index);
        return  node!=null?(E) node.element:null;  //向下转型
    }

    //移除  和数组比 就快了很多了
    public  void remove(int index){
        checkRange(index);
        Node temp = getNode(index);
        if (temp!=null){
            //获得这个元素的 上一个和下一个
            Node up= temp.previous;
            Node down=   temp.next;
            if (up!=null){
                up.next=down;  //  上一个的  下一个节点
            }
            if (down!=null){
                down.previous=up;//  下一个的 上一个节点  互换
            }

            //被删除的元素师第一个元素
            if (index==0){
                first=down;
            }
            //被删除的元素是最后一个元素时
            if(index == size-1){
                last = up;
            }

            size--;
        }

    }


    public  void  add(int index, Object  element) {   //alt+shift+R

        checkRange(index);

        Node  newNode = new Node(element);
        Node  temp  =  getNode(index);

        if(temp!=null){
            Node up = temp.previous;

            up.next = newNode;
            newNode.previous = up;

            newNode.next = temp;
            temp.previous = newNode;

        }
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedListTest{");
        Node node= first;   //从first开始 一次加入系你的元素
        while (node!=null){
            stringBuilder.append(node.element+",");
            node = node.next;  //每次向下一个元素移动
        }
        //处理最后一个的， 问题
        stringBuilder.setCharAt(stringBuilder.length()-1,']');

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
       LinkedListTest<String>  list = new LinkedListTest<>();

        list.add("a");
        list.add("b");
        System.out.println(list.first.element);

        System.out.println(list.get(1));

        System.out.println("*******************************");
        StringBuilder sb = new StringBuilder();
        sb.append("sa");
        sb.append("sa");
        sb.append("sa");
        sb.append("sa");
        System.out.println(sb.length());
        //sb.setCharAt(sb.length(),']');
        System.out.println(sb);
    }




}

