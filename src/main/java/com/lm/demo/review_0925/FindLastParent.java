package com.lm.demo.review_0925;

public class FindLastParent {

    public Node find (Node node , Node left , Node right) {
        if (node.data > left.data && node.data < right.data)
            return node;
        if (node.data == left.data) return left;
        if (node.data == right.data) return right;
        if (node.data > right.data)
            return find(node.left , left , right);
        if (node.data < left.data)
            return find(node.right , left , right);
        return null;
    }

    public Node findOther (Node node , Node left , Node right) {
        if (node == null || node == left || node == right) {
            return node;
        }
        Node leftt = findOther(node.left, left , right);
        Node rifhtt = findOther(node.right , left , right);
        if (leftt != null && rifhtt != null) {
            return node;
        }
        return leftt == null ? rifhtt : leftt;
    }

    public static void main(String[] args) {
        FindLastParent findLastParent = new FindLastParent();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node5.left = node3;
        node5.right = node8;
        node3.left = node2;
        node3.right = node4;
        node8.left = node7;
        node7.left = node6;
        node2.left = node1;
        System.out.println(findLastParent.find(node5 , node4 , node7).data);
    }


}
