package com.lm.demo.tree;

public class PrintTree {

    /**
     * 前序遍历
     */
    public void preOrder (TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder (TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder (TreeNode node) {
        if (node == null) return;;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * 层次遍历
     */
    public void levelOrder (TreeNode node) {
        TreeQueue queue = new TreeQueue();
        queue.enq(node);
        while (queue.length != 0) {
            TreeNode data = queue.deq().data;
            System.out.print(data.data + " ");
            if (data.left != null) queue.enq(data.left);
            if (data.right != null) queue.enq(data.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrintTree print = new PrintTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        print.preOrder(node1);
        System.out.println();
        print.inOrder(node1);
        System.out.println();
        print.postOrder(node1);
        System.out.println();
        print.levelOrder(node1);
    }



}
