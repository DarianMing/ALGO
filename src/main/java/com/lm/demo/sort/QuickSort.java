package com.lm.demo.sort;

import java.util.Arrays;

/**
 *  原地、不稳定排序
 */
public class QuickSort {

    public void quickSort (int[] a) {
        quickSort(a , 0 , a.length - 1);
    }

    public void quickSort (int[] a , int p , int r) {
        if (p >= r) return;
        //获取分区点
        int q = partition2(a , p , r);
        quickSort(a , p , q - 1);
        quickSort(a , q + 1 , r);
    }

    public int partition (int[] a , int p , int r) {
        int[] left = new int[r - p];
        int[] right = new int[r - p];
        int value = a[r];
        int k = 0 , l = 0;
        for (int i = p; i < r; i++) {
            if (a[i] < value) {
                left[k++] = a[i];
            } else {
                right[l++] = a[i];
            }
        }
        int s = p;
        for (int i = 0; i < k ; i++) {
            a[s++] = left[i];
        }
        a[s++] = value;
        for (int i = 0; i < l ; i++) {
            a[s++] = right[i];
        }
        return k + p;
    }

    public int partition2 (int[] a , int p , int r) {
        int i = p;
        int value = a[r];
        for (int j = p; j < r ; j++) {
            if (a[j] < value) {
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

    public void print (int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] a = new int[]{1 , 8 , 9 , 5 , 4 , 6 , 10};
        QuickSort quick = new QuickSort();
        quick.quickSort(a);
        quick.print(a);
    }

}
