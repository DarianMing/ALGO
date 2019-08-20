package com.lm.demo.tree;

public class TreeQueue {

    public Node head;
    public Node tail;
    public int length;

    public boolean enq (TreeNode node) {
        if (node == null) return false;
        this.length++;
        Node node1 = new Node(node);
        if (head == null) {
            head = tail = node1;
            return true;
        }
        tail.next = node1;
        tail = node1;
        return true;
    }

    public Node deq () {
        if (head == null) return null;
        this.length--;
        Node del = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return del;
    }

    public void print () {
        Node node = head;
        while (node != null) {
            System.out.print(node.data.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeQueue queue = new TreeQueue();
        System.out.println(queue.length);
        queue.enq(node1);
        queue.enq(node2);
        queue.enq(node3);
        queue.enq(node4);
        queue.enq(node5);
        queue.enq(node6);
        queue.print();
        queue.deq();
        queue.deq();
        queue.deq();
        queue.print();
        System.out.println(queue.length);
    }




}
