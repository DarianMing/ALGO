package com.lm.demo.review_1009;

import com.lm.demo.list.Node;

public class LinkedNodeTest {


    public void reverse (Node node) {
        Node pre = null;
        Node cur = node;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        print(pre);
    }

    public void findK (Node node , int k) {
        Node cur = node;
        while (k > 0) {
            if (cur == null) return;
            cur = cur.next;
            k--;
        }
        Node pre = node;
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        System.out.println(pre.data);
    }

    public boolean isLoop (Node node) {
        Node slow = node;
        Node high = node.next;
        while (slow != high) {
            if (high == null || high.next == null) return false;
            slow = slow.next;
            high = high.next.next;
        }
        return true;
    }

    public void findLoopPoint (Node node) {
        Node slow = node;
        Node high = node.next;
        while (slow != high) {
            if (high == null || high.next == null) return;
            slow = slow.next;
            high = high.next.next;
        }
        Node pre = node;

        slow = slow.next;
        while (pre != slow) {
            pre = pre.next;
            slow = slow.next;
        }
        System.out.println(pre.data);
    }

    public void print (Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node n5 = Node.createNode(24);
        Node n4 = Node.createNode(20);
        Node n3 = Node.createNode(9);
        Node n2 = Node.createNode(8);
        Node n1 = Node.createNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;
        LinkedNodeTest linkedNodeTest = new LinkedNodeTest();
//        linkedNodeTest.reverse(n1);
//        linkedNodeTest.findK(n1 , 1);
//        System.out.println(linkedNodeTest.isLoop(n1));
        linkedNodeTest.findLoopPoint(n1);
    }

}
