package com.lm.demo.list;

/**
 * @author lm
 * @since 2019-08-16 18:11
 **/
public class LRULinkedList {

    /**
     * 默认链表容量
     */
    private final static int DEFAULT_CAPACITY = 10;

    public Node head;

    public int length;

    public int capacity;

    public LRULinkedList () {
        this.capacity = DEFAULT_CAPACITY;
        this.head = Node.createNode(0);
        this.length = 0;
    }

    public LRULinkedList (int capacity) {
        this.capacity = capacity;
        this.head = Node.createNode(0);
        this.length = 0;
    }

    public Node findPre (int item) {
        if (head.next == null) return null;
        Node cur = head;
        while (cur != null){
            if (cur.next.data == item){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public Node deleteHead () {
        if (head.next == null) return null;
        Node delNode = head.next;
        head.next = head.next.next;
        this.length--;
        return delNode;
    }

    public boolean addTail (Node node) {
        if (head.next == null) {
            head.next = node;
            return true;
        }
        Node cur = head.next;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        this.length++;
        return true;
    }

    public boolean offer (int data) {
        Node node = Node.createNode(data);
        Node pre = findPre(data);
        if (pre != null) {
            pre.next = pre.next.next;
        } else {
            if (length == capacity) {
                deleteHead();
            }
        }
        return addTail(node);
    }


    public void printAll (){
        Node cur = head.next;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRULinkedList lruLinkedList = new LRULinkedList(10);
        lruLinkedList.offer(1);
        lruLinkedList.offer(2);
        lruLinkedList.offer(3);
        lruLinkedList.offer(4);
        lruLinkedList.offer(5);
        lruLinkedList.printAll();
    }



}
