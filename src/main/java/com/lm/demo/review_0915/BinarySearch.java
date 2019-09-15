package com.lm.demo.review_0915;

public class BinarySearch {

    public int search1 (int[] a , int low , int high , int key){
        if(low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] > key) {
            return search1(a , low , mid - 1 , key);
        } else if (a[mid] < key) {
            return search1(a , mid + 1 , high , key);
        } else {
            return mid;
        }
    }

    public int search2 (int[] a , int key){
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key){
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search3 (int[] a , int low , int high , int key){
        if(low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] > key) {
            return search3(a , low , mid - 1 , key);
        } else if (a[mid] < key) {
            return search3(a , mid + 1 , high , key);
        } else {
            if (mid == low || a[mid - 1] != key) {
                return mid;
            } else {
                return search3(a , low , mid - 1 , key);
            }
        }
    }

    public int search4 (int[] a , int key){
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key){
                low = mid - 1;
            } else {
                if (mid == high || a[mid + 1] != key) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public int search5 (int[] a , int key){
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > key) {
                if (mid == low || a[mid - 1] < key) {
                    return a[mid];
                } else {
                    high = mid - 1;
                }
            }  else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int search6 (int[] a , int key){
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < key) {
                if (mid == high || a[mid + 1] > key){
                    return a[mid];
                } else {
                    low = mid + 1;
                }
            }  else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,4,4,8,9,12,24,36,36,36};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search6(a ,36));
    }




}
