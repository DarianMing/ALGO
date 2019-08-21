package com.lm.demo.tree;

/**
 *  二叉查找树 非完全二叉树
 *  中序遍历二叉查找树可以输出有序的数据序列，时间复杂度是O(n),非常高效，因此二叉查找树也叫二叉排序树
 */
public class BinarySearchTree {

    private TreeNode tree;

    private boolean insert (int data) {
        TreeNode node = new TreeNode(data);
        if (tree == null) {
            tree = node;
            return true;
        }
        TreeNode cur = tree;
        while (true) {
            if (cur.data < data) {
                if (cur.right == null) {
                    cur.right = node;
                    return true;
                }
                cur = cur.right;
            } else if (cur.data > data) {
                if (cur.left == null) {
                    cur.left = node;
                    return true;
                }
                cur = cur.left;
            } else {
                return false;
            }
        }
    }

    private TreeNode find (int data) {
        TreeNode node = tree;
        while (node != null) {
            if (node.data == data) {
                return node;
            } else if (node.data < data) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    private TreeNode findParent (int data) {
        if (tree.data == data) return null;
        TreeNode node = tree;
        while (node != null){
            if (node.left != null && node.left.data == data) return node;
            if (node.right != null && node.right.data == data) return node;
            if (node.data < data) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    /**
     *    三种情况
     *  1、待删除节点无子节点 只需要将父节点中指向待删除节点的指针置为null
     *  2、待删除节点有左或右子节点 只需要更新父节点中指向待删除节点的指针，让其指向待删除节点的子节点
     *  3、待删除节点有两个子节点 需要找到待删除节点的右子树的最小节点，把它替换到要删除的节点上，然后删除掉这个最小节点
     */
    public void delete (int data) {
        if (tree == null) return;
        if (tree.data == data) {
            tree = null;
            return;
        }
        //删除节点父节点
        TreeNode delParentNode = findParent(data);
        if (delParentNode == null) return;
        //待删除节点是父节点的那个子节点
        boolean isLeft = delParentNode.data > data;
        //待删除节点
        TreeNode delNode = isLeft ? delParentNode.left : delParentNode.right;
        //待删除节点无子节点
        if (delNode.left == null && delNode.right == null) {
            if (isLeft) delParentNode.left = null;
            else delParentNode.right = null;
        }
        //待删除节点有左或右子节点
        if ( (delNode.left != null && delNode.right == null) || ( delNode.left == null && delNode.right != null)) {
            TreeNode delNodeChild = delNode.left == null ? delNode.right : delNode.left;
            if (isLeft) delParentNode.left = delNodeChild;
            else delParentNode.right = delNodeChild;
        }
        //待删除节点有两个子节点
        if (delNode.left != null && delNode.right != null) {
            TreeNode mostLeft = delNode.right.left == null ? delNode.right : findMostLeft(delNode.right);
            int saveData  = mostLeft.data;
            delete(mostLeft.data);
            delNode.data = saveData;
        }
    }

    private void delete1 (int data) {
        //待删除的节点，初始化指向根节点
        TreeNode delNode = tree;
        //待删除节点的父节点
        TreeNode parent = null;
        while (delNode != null && delNode.data != data) {
            parent = delNode;
            if (delNode.data < data) {
                delNode = delNode.right;
            } else {
                delNode = delNode.left;
            }
        }
        if (delNode == null) return;
        //待删除节点有两个子节点
        if (delNode.left != null && delNode.right != null) {
            //待删除节点右子树的最小节点
            TreeNode mostLeft = delNode.right;
            //待删除节点右子树的最小节点的父节点
            TreeNode mostLeftParent = delNode;
            while (mostLeft.left != null) {
                mostLeftParent = mostLeft;
                mostLeft = mostLeft.left;
            }
            //交换待删除节点右子树的最小节点和待删除节点的数据
            delNode.data = mostLeft.data;
            //更新待删除节点的父节点
            parent = mostLeftParent;
            //更新待删除节点 此节点有右子节点或没有子节点
            delNode = mostLeft;
        }
        //待删除节点的子节点
        TreeNode child;
        if (delNode.left != null) {
            child = delNode.left;
        } else if (delNode.right != null) {
            child = delNode.right;
        } else {
            child = null;
        }
        if (parent == null) tree = null;
        else if (parent.left == delNode) parent.left = child;
        else parent.right = child;
    }

    private int height (TreeNode node) {
        if (node == null) return 0;
        int lh = node.left == null ? 0 : height(node.left) + 1;
        int rh = node.right == null ? 0 : height(node.right) + 1;
        return lh > rh ? lh : rh;
    }

    private TreeNode findMostLeft (TreeNode treeNode) {
        if (treeNode == null) return null;
        if (treeNode.left == null) return treeNode;
        return findMostLeft(treeNode.left);
    }

    public static void main(String[] args) {
        PrintTree print = new PrintTree();
        BinarySearchTree searchTree = new BinarySearchTree();
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(18);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        searchTree.tree = node1;
        TreeNode searchNode = searchTree.find(7);
        searchTree.insert(4);
        searchTree.insert(22);
        searchTree.insert(20);
        searchTree.insert(24);
        searchTree.insert(21);
        print.levelOrder(searchTree.tree);
        TreeNode parent = searchTree.findParent(5);
        System.out.println(parent == null ? -1 : parent.data);
        System.out.println(searchNode == null ? -1 : searchNode.data);
        TreeNode mostLeft = searchTree.findMostLeft(node3);
        System.out.println(mostLeft == null ? -1 : mostLeft.data);
        //searchTree.delete(18);
        searchTree.delete1(18);
        print.levelOrder(searchTree.tree);
        //中序遍历二叉查找树可以输出有序的数据序列，时间复杂度是O(n),非常高效
        print.inOrder(searchTree.tree);
        System.out.println();
        System.out.println(searchTree.height(searchTree.tree));
    }


}
