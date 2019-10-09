package com.lm.demo.review_1009;

public class QuickSort {

    public void quickSort (int[] arr , int p , int r) {
        if (p >= r) return;
        int patition = patition(arr, p, r);
        quickSort(arr , p , patition - 1);
        quickSort(arr , patition + 1 , r);
    }

    public int patition (int[] arr , int p , int r) {
        int value = arr[r];
        int x = p;
        for (int i = p; i <= r ; i++) {
            if (arr[i] < value) {
                swap(arr , i , x);
                x++;
            }
        }
        swap(arr , x , r);
        return x;
    }

    public void swap (int[] arr , int i , int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void print (int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,8,6,4,3,1,12};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(a , 0 , a.length - 1);
        quickSort.print(a);
    }
}
