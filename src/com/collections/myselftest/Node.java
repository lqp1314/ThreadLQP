package com.collections.myselftest;

/**
 * 节点  上一个 下一个  自身
 */
public class Node {

    Node previous;
    Node next;
    Object element; //本身的元素

    //两个构造器

    //全面的信息
    public Node(Node previous, Node next, Object element) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    //设置元素本身
    public Node(Object element) {
        this.element = element;
    }
}
