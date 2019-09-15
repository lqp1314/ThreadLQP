package com.collections.myselftest;

/**
 * 测试泛型
 */
public class TestGeneric {
    public  static  int ss;
    public static void main(String[] args) {
        My<String> my = new My<>();
        my.set("sa",1);
        ss++;
        TestGeneric generic = new TestGeneric();
        generic.setSs();
        TestGeneric generic01 = new TestGeneric();
        generic01.setSs();

        TestGeneric generic02 = new TestGeneric();
        generic02.setSs();
    }
    public  void setSs(){
        ss++;
        System.out.println(ss);
    }

   static class My<V>{
        Object object[]=new Object[5];

        public  void  set(V v,int index){
            object[index]=v;
        }
        public  V  get(int index){
            return  (V) object[index];
        }
    }

}
