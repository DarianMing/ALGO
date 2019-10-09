package com.lm.demo.review_1009;

public class Sort {


    public void bubbleSort (int[] arr) {
        for (int i = 0; i < arr.length - 1 ; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    swap(arr , j , j + 1);
                }
            }
            if (flag) return;
        }
        print(arr);
    }

    public void insertSort (int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int value = arr[i + 1];
            int j = i;
            for (; j >= 0 ; j--) {
                if (arr[j] > value) {
                    swap(arr , j , j + 1);
                } else {
                    break;
                }
            }
            if (j != i) arr[j + 1] = value;
        }
        print(arr);
    }

    public void selectSort (int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) swap(arr , minIndex , i);
        }
        print(arr);
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
        int[] a = new int[]{7,8,6,4,3};
        Sort sort = new Sort();
        //sort.bubbleSort(a);
        //sort.insertSort(a);
        sort.selectSort(a);
    }



}
