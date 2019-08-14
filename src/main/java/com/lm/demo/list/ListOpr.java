package com.lm.demo.list;

/**
 *  1) 单链表反转
 *  2) 链表中环的检测
 *  3) 两个有序的链表合并
 *  4) 删除链表倒数第n个结点
 *  5) 求链表的中间结点
 *
 * @author lm
 * @since 2019-08-14 19:19
 **/
public class ListOpr {

    public static Node reverse (Node node) {
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

    public static boolean isLoop (Node node) {
        if (node == null) return false;
        Node slow = node;
        Node quick = node.next;
        while (quick != null && quick.next != null) {
            if (quick == slow) {
                return true;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return false;
    }

    public static Node merge (Node list1 , Node list2) {
//        if (list1 == null && list2 == null) {
//            return null;
//        }
//        if (list1 != null && list2 == null) {
//            return list1;
//        }
//        if (list1 == null) {
//            return list2;
//        }
        Node soldier = Node.createNode(0); //利用哨兵结点简化实现难度 技巧三
        //Node head = list1.data < list2.data ? list1 : list2;
        Node cur = soldier;
//        list1 = head == list1 ? list1.next : list1;
//        list2 = head == list2 ? list2.next : list2;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) cur.next = list1;
        if (list2 != null) cur.next = list2;
        return soldier.next;
    }

    public static Node middleNode (Node node) {
        if (node == null) return null;
        Node fast = node;
        Node slow = node;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printAll (Node node) {
        Node p = node;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node delReN (Node node , int n) {
        Node cur = node;
        int i = 1;
        while (cur != null && i < n) {
            cur = cur.next;
            ++i;
        }
        if (cur == null) return node;
        Node pre = null;
        Node slow = node;
        while (cur.next != null) {
            cur = cur.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre == null) {
            node = node.next;
        } else {
            pre.next = pre.next.next;
        }
        return node;
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
        //n5.next = n1;
        System.out.println(middleNode(n1).data);
        Node n6 = Node.createNode(1);
        Node n7 = Node.createNode(3);
        Node n8 = Node.createNode(6);
        Node n9 = Node.createNode(25);
        Node n10 = Node.createNode(100);
        Node n11 = Node.createNode(200);
        Node n12 = Node.createNode(300);
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = n12;
        Node node = delReN(n6, 2);
        printAll(node);
        //printAll(n6);
//        Node merge = merge(n1, n6);
//        pringAll(merge);
//        pringAll(n1);
//        Node reverse = reverse(n1);
//        pringAll(reverse);
    }

}
