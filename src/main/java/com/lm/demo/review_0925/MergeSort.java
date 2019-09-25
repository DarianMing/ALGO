package com.lm.demo.review_0925;

public class MergeSort {

    public void sort (int[] arr , int p , int r) {
        if (p >= r) return;
        int mid = p + ((r - p) >> 1);
        sort(arr , p , mid);
        sort(arr , mid + 1 , r);
        merge(arr , p , mid , r);
    }

    public void merge (int[] arr , int p , int q , int r) {
        int[] left = new int[q - p + 2];
        int[] right = new int[r - q + 1];
        left[left.length - 1] = Integer.MAX_VALUE;
        right[right.length - 1] = Integer.MAX_VALUE;
        for (int i = 0; i < left.length - 1; i++) {
            left[i] = arr[p + i];
        }
        for (int i = 0; i < right.length - 1; i++) {
            right[i] = arr[q + i + 1];
        }
        int k = p;
        int i = 0;
        int j = 0;
        while (k <= r) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
    }


    public void print (int[] a) {
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{7,12,46,89,13,5};
        mergeSort.sort(arr , 0 , arr.length - 1);
        mergeSort.print(arr);
    }



}
