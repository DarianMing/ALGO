package com.lm.demo.review_0925;

public class Sort {

    public void bubble (int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]){
                    swap(arr , j - 1 , j);
                    flag = false;
                }

            }
            if (flag) return;
        }
    }
    
    public void insertSort (int[] a) {
        for (int i = 0; i < a.length ; i++) {
            int val = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > val) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = val;
        }
    }

    public void selectSort (int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(a , min , i);
            }
        }
    }

    public void swap (int[] a , int i , int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void print (int[] arr) {
        for (int k = 0; k < arr.length ; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,12,46,89,13,5};
        Sort sort = new Sort();
//        sort.bubble(arr);
//        sort.insertSort(arr);
        sort.selectSort(arr);
        sort.print(arr);
    }
}
