package com.lm.demo.list;

/**
 * @author lm
 * @since 2019-08-14 19:19
 **/
public class ListOpr {


    public static Node rever (Node node) {
        Node pre = node;
        Node cur = node.next;
        pre.next = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void pringAll (Node node) {
        Node p = node;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n5 = Node.createNode(5);
        Node n4 = Node.createNode(4);
        Node n3 = Node.createNode(3);
        Node n2 = Node.createNode(2);
        Node n1 = Node.createNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        pringAll(n1);
        Node rever = rever(n1);
        pringAll(rever);
    }

}
