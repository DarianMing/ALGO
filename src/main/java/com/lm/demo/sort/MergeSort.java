package com.lm.demo.sort;

/**
 *  归并排序
 *  稳定排序
 *  最好、最坏、平均时间复杂度均为O（nlogn）
 *  不是原地排序算法
 *  空间复杂度O（n）
 */
public class MergeSort {


    public void sort (int[] a) {
        sort(a, 0 , a.length - 1);
    }

    //调用递归函数
    public void sort (int[] a , int p , int r) {
        //递归终止条件
        if (p >= r) return;
        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        //int q = (p + r)/2;
        int q = p + (r - p)/2;
        sort(a , p , q);
        sort(a , q + 1 , r);
        //merge(a , p ,q , r);
        mergeBySentry(a , p , q , r);
    }

    /**
     * 合并函数
     */
    public void merge (int[] a , int p , int q , int r) {
        int i = p , j = q + 1 , k = 0;
        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        int start = i , end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end){
            temp[k++] = a[start++];
        }
        for (int l = 0; l < k; l++) {
            a[p++] = temp[l];
        }
    }

    /**
     *  哨兵方式合并
     */
    public void mergeBySentry (int[] a , int p , int q , int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];
        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = a[p + i];
        }
        //第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;
        for (int i = 0; i < r - q; i++) {
            rightArr[i] = a[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r - q] = Integer.MAX_VALUE;
        int i = 0 , j = 0 , k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                a[k++] = leftArr[i++];
            } else {
                a[k++] = rightArr[j++];
            }
        }
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,7,5,18,22,4};
        //int[] a = new int[]{1,8,6,7,5};
        MergeSort sort = new MergeSort();
        sort.sort(a);
        print(a);
    }

}
