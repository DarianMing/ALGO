package com.lm.demo.sort;

/**
 *  以O（n）时间复杂度寻找无序数组中第k大个数
 */
public class FindKMax {


    public int find (int[] a , int k) {
        if (k > a.length) return -1;
        int part = partition(a, 0, a.length - 1);
        while (part + 1 != k){
            if (part + 1 < k) {
                part = partition(a , part + 1 , a.length - 1);
            } else {
                part = partition(a , 0 , part - 1);
            }
        }
        return a[part];
    }

    public int partition (int[] a , int p , int r) {
        int value = a[r];
        int i = p;
        for (int j = p; j < r ; j++) {
            // 这里要是 <= ，不然会出现死循环，比如查找数组 [1,1,2] 的第二小的元素
            if (a[j] <= value) {
                swap(a , i , j);
                i++;
            }
        }
        swap(a , i , r);
        return i;
    }

    public void swap (int[] a , int i , int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        //int[] a = new int[]{1,5,8,3,9};
        int[] a = new int[]{1,1,2};
        FindKMax findKMax = new FindKMax();
        System.out.println(findKMax.find(a , 2));
    }

}
