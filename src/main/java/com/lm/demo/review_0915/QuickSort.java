package com.lm.demo.review_0915;

public class QuickSort {


    public void quickSort (int[] a, int p , int r) {
        if (p >= r) return;
        int index = partition(a , p , r);
        quickSort(a , p , index - 1);
        quickSort(a , index + 1 , r);
    }

    public int partition (int[] a , int p ,int r) {
        int index = p;
        int value = a[r];
        for (int i = p; i < a.length ; i++) {
            if (a[i] < value) {
                int tmp = a[index];
                a[index] = a[i];
                a[i] = tmp;
                index++;
            }
        }
        int tmp = a[index];
        a[index] = value;
        a[r] = tmp;
        return index;
    }

    public void print (int[] a) {
        for (int anA : a) {
            System.out.print(anA + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a  = new int[]{1,8,9,4,3,7};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(a , 0 , a.length - 1);
        quickSort.print(a);
    }

}
