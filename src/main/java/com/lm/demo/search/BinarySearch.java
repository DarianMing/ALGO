package com.lm.demo.search;

/**
 *  二分查找 时间复杂度O（nlogn）
 */
public class BinarySearch {

    /**
     * 递归实现 数组无重复
     */
    private int bSearchRecursion(int[] a, int low, int high, int data) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == data) {
            return mid;
        } else if (a[mid] > data) {
            return bSearchRecursion(a , low , mid - 1 , data);
        } else {
            return bSearchRecursion(a , mid + 1 , high , data);
        }
    }

    /**
     * 非递归实现 数组无重复
     */
    private int bSearchUnRecursion(int[] a, int data) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == data) {
                return mid;
            } else if (a[mid] > data){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变体一：查找第一个值等于给定值的元素
     * 非递归实现 数组有重复数据
     */
    public int bSearchArrDup1 (int[] a , int data) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] > data) {
                high = mid - 1;
            } else if (a[mid] < data) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] != data) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 变体二：查找最后一个值等于给定值的元素
     * 非递归实现 数组有重复数据
     */
    public int bSearchArrDup2 (int[] a , int data) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] > data) {
                high = mid - 1;
            } else if (a[mid] < data) {
                low = mid + 1;
            } else {
                if (mid == a.length - 1 || a[mid + 1] != data) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变体三：查找第一个大于等于给定值的元素
     */
    private int bSearchArrDup3 (int[] a , int data) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < data) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] < data) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 变体四：查找最后一个小于等于给定值的元素
     */
    private int bSearchArrDup4 (int[] a , int data) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= data) {
                if (mid == a.length - 1 || a[mid + 1] > data) return mid;
                else low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,4,4,6,8,9,12,12,24};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.bSearchRecursion(a , 0 , a.length - 1 , 12));
        System.out.println(binarySearch.bSearchUnRecursion(a , 12));
        System.out.println(binarySearch.bSearchArrDup1(a , 4));
        System.out.println(binarySearch.bSearchArrDup2(a , 4));
        System.out.println(binarySearch.bSearchArrDup3(a , 9));
        System.out.println(binarySearch.bSearchArrDup4(a , 23));
    }

}
