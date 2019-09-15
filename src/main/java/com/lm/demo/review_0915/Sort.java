package com.lm.demo.review_0915;

public class Sort {

    public void bubbleSort (int[] a){
        for (int i = 0; i < a.length - 1 ; i++) {
            boolean flag = true;
            for (int j = 1; j < a.length - i; j++) {
                if (a[j - 1] > a[j]) {
                    flag = false;
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
            if(flag) break;
        }
        print(a);
    }

    public void insertSort (int[] a){
        int len = a.length;
        for (int i = 1; i < len ; i++) {
            int val = a[i];
            int j = i - 1;
            for (; j >= 0  ; j--) {
                if (a[j] > val) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = val;
        }
        print(a);
    }
    
    public void selectSort (int[] a){
        int len = a.length;
        for (int i = 0; i < len ; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
        print(a);
    }

    public void print (int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,7,2,9,6};
        Sort sort = new Sort();
        //sort.bubbleSort(a);
        //sort.insertSort(a);
        sort.selectSort(a);
    }


}
