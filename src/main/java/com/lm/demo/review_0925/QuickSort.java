package com.lm.demo.review_0925;

public class QuickSort {

    public void sort (int[] arr , int p , int r) {
        if (p >= r) return;
        int patition = patition(arr, p, r);
        sort(arr , p , patition - 1);
        sort(arr , patition + 1 , r);
    }

    public int patition (int[] a , int p , int r) {
        int value = a[r];
        int x = p;
        for (int i = p; i < r; i++) {
            if (a[i] < value) {
                swap(a , x , i);
                x++;
            }
        }
        swap(a , x , r);
        return x;
    }

    public void swap (int[] a , int i , int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void print (int[] a) {
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{7,12,46,89,13,5};
        quickSort.sort(arr , 0 , arr.length - 1);
        quickSort.print(arr);
    }


}
