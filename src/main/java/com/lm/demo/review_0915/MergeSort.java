package com.lm.demo.review_0915;

public class MergeSort {


    public void resolve (int a[] , int p , int r){
        if (p >= r) return;
        int q = p + ((r - p) >> 1);
        resolve(a , p , q);
        resolve(a , q + 1 , r);
        merge(a , p , q, r);
    }

    public void merge (int[] a , int p , int q , int r) {
        int[] left = new int[q - p + 2];
        int[] right = new int[r - q + 1];
        left[left.length - 1] = Integer.MAX_VALUE;
        for (int i = 0; i < left.length - 1 ; i++) {
            left[i] = a[p + i];
        }
        for (int i = 0; i < right.length - 1 ; i++) {
            right[i] = a[q + 1 + i];
        }
        right[right.length - 1] = Integer.MAX_VALUE;
        int k = p;
        int i = 0;
        int j = 0;
        while (k <= r) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }
    }

    public void print (int[] a) {
        for (int anA : a) {
            System.out.print(anA + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a  = new int[]{1,8,9,4,3,7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.resolve(a , 0 , a.length - 1);
        mergeSort.print(a);
    }
}
