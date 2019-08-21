package com.lm.demo.list;

import java.util.LinkedHashMap;

/**
 * 缓存淘汰策略LRU链表实现
 * @author lm
 * @since 2019-08-16 18:11
 **/
public class LRULinkedList {

    /**
     * 默认链表容量
     */
    private final static int DEFAULT_CAPACITY = 10;

    private Node head;

    private int length;

    private int capacity;

    public LRULinkedList () {
        this.capacity = DEFAULT_CAPACITY;
        this.head = Node.createNode(0);
        this.length = 0;
    }

    private LRULinkedList (int capacity) {
        this.capacity = capacity;
        this.head = Node.createNode(0);
        this.length = 0;
    }

    private Node findPre (int item) {
        if (head.next == null) return null;
        Node cur = head;
        while (cur.next != null){
            if (cur.next.data == item){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    private Node deleteHead() {
        if (head.next == null) return null;
        Node delNode = head.next;
        head.next = head.next.next;
        this.length--;
        return delNode;
    }

    private boolean addTail (Node node) {
        this.length++;
        if (head.next == null) {
            head.next = node;
            return true;
        }
        Node cur = head.next;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        return true;
    }

    private boolean offer (int data) {
        Node node = Node.createNode(data);
        Node pre = findPre(data);
        if (pre != null) {
            pre.next = pre.next.next;
            this.length--;
        } else {
            if (this.length == this.capacity) {
                deleteHead();
            }
        }
        return addTail(node);
    }


    private void printAll (){
        Node cur = head.next;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRULinkedList lruLinkedList = new LRULinkedList(5);
        lruLinkedList.offer(1);
        lruLinkedList.offer(2);
        lruLinkedList.offer(3);
        lruLinkedList.offer(4);
        lruLinkedList.offer(5);
        lruLinkedList.offer(2);
        lruLinkedList.offer(6);
        lruLinkedList.printAll();
    }



}
