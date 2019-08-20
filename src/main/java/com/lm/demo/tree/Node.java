package com.lm.demo.tree;

public class Node {

    public TreeNode data;

    public Node next;

    public Node (int data) {
        this(new TreeNode(data));
    }

    public Node (TreeNode data) {
        this(data , null);
    }

    public Node (TreeNode data , Node next) {
        this.data = data;
        this.next = next;
    }


}
