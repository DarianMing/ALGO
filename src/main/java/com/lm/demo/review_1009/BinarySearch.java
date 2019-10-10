package com.lm.demo.review_1009;

public class BinarySearch {

    public int search1 (int[] arr , int low , int high , int data) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (arr[mid] > data) {
            return search1(arr , low , mid - 1 , data);
        } else if (arr[mid] < data) {
            return search1(arr , mid + 1 , high , data);
        } else {
            return mid;
        }
    }
    


    public static void main(String[] args) {
        int[] a = new int[]{1,4,6,8,12,20,24};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search1(a , 0 , a.length - 1 , 8));
    }
}
