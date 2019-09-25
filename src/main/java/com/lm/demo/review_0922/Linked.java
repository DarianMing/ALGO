package com.lm.demo.review_0922;

import com.lm.demo.list.Node;

public class Linked {

    /**
     * 找到链表倒数第K个节点
     */
    public void findK (Node head , int k) {
        Node node = head;
        while (k-- > 0){
            if (node == null) return;
            node = node.next;
        }
        Node cur = head;
        while (node != null){
            node = node.next;
            cur = cur.next;
        }
        System.out.println(cur.data);
    }

    /**
     * 链表反转
     */
    public void reverse (Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        print(pre);
    }

    /**
     * 倒序输出链表
     */
    public void reversePrint (Node node) {
        if (node == null) return;
        reversePrint(node.next);
        System.out.print(node.data + " ");
    }

    /**
     * 找到链表的中间节点
     */
    public void findMiddleNode (Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        System.out.println(slow.data);
    }

    /**
     * 判断链表是否有环
     */
    public boolean isLoop (Node node) {
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 找到带环链表的入环点
     */
    public void findLoopPoint (Node node){
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        Node x = node;
        while (x != slow){
            x = x.next;
            slow = slow.next;
        }
        System.out.println(x.data);
    }

    public void print (Node node){
        Node node1 = node;
        while (node1 != null){
            System.out.print(node1.data + " ");
            node1 = node1.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node node1 = Node.createNode(1);
        Node node2 = Node.createNode(2);
        Node node3 = Node.createNode(3);
        Node node4 = Node.createNode(4);
        Node node5 = Node.createNode(5);
        Node node6 = Node.createNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node2;
        Linked linked = new Linked();
//        linked.findK(node1 , 2);
//        linked.reverse(node1);
//        linked.reversePrint(node1);
//        linked.findMiddleNode(node1);
//        System.out.println();
//        System.out.println(linked.isLoop(node1));
        linked.findLoopPoint(node1);
    }


}
