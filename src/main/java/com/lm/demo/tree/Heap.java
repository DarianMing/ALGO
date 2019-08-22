package com.lm.demo.tree;

public class Heap {

    private int[] a; //数组，下标从1开始存储元素
    private int capacity; //堆中可存储的数据数
    private int count; //堆中的数据个数

    public Heap (int capacity) {
        this.capacity = capacity;
        a = new int[capacity + 1];
    }

    public void insert (int data) {
        if (capacity <= count) return; //堆满了
        a[++count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]){ //自下往上堆化
            swap(i , i/2);
            i = i/2;
        }
    }

    //删除堆顶节点
    public void removeMax () {
        if (count == 0) return;//堆中没有数据
        a[1] = a[count--];
    }

    /**
     *  自上而下堆化
     */
    public void adjustUpToButton (int i) {
        while (true){
            int maxPos = i;
            if (i * 2 <= count && a[i] < a[i*2]) maxPos = i*2;
            if (i * 2 + 1 <= count && a[i] < a[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(maxPos , i);
            i = maxPos;
        }
    }

    public void print () {
        for (int i = 1; i <= count; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private void swap (int i , int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(100);
        heap.insert(33);
        heap.insert(17);
        heap.insert(21);
        heap.insert(16);
        heap.insert(13);
        heap.insert(15);
        heap.insert(9);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        heap.insert(22);
        heap.print();
    }

}
