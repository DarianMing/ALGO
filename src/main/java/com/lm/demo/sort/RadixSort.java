package com.lm.demo.sort;

/**
 *  基数排序 最好时间复杂度O（n）
 */
public class RadixSort {


    public void redisSort (long[] a) {
        long max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // 从个位开始，对数组arr按"指数"进行排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(a, exp);
        }

//        if (a.length < 2) return;
//        Long max = a[0];
//        for (int i = 1; i < a.length; i++) {
//            if (a[i] > max) {
//                max = a[i];
//            }
//        }
//        for (int i = 1; max / i > 0; i *= 10) {
//            countSort(a , i);
//        }
    }

    public void countSort (long[] arr , int exp) {
//        if (a.length < 2) return;
//        int[] c = new int[10];
//        for (int i = 0; i < a.length; i++) {
//            int ii = (int) ((a[i] / index) % 10);
//            c[ii]++;
//        }
//        for (int i = 1; i < c.length ; i++) {
//            c[i] = c[i] + c[i-1];
//        }
//        long[] r = new long[a.length];
//        for (int i = a.length - 1; i >= 0; i--) {
//            int in = c[(int)((a[i] / index) % 10)] - 1;
//            r[in] = a[i];
//            c[(int)((a[i] / index) % 10)]--;
//        }
//        for (int i = 0; i < a.length; i++) {
//            a[i] = r[i];
//        }
        if (arr.length <= 1) {
            return;
        }

        // 计算每个元素的个数
        int[] c = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int i1 = (int) ((arr[i] / exp) % 10);
            c[i1]++;
        }

        // 计算排序后的位置
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // 临时数组r，存储排序之后的结果
        long[] r = new long[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            r[c[(int)((arr[i] / exp) % 10)] - 1] = (int) arr[i];
            c[(int)((arr[i] / exp) % 10)]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r[i];
        }
    }

    public void print (long[] a) {
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        //long[] a = new long[]{742975641L , 315982643L , 734287614L , 874136975L};
        long[] a = new long[]{18742975641L , 75315982643L , 25734287614L , 25874136975L};
        RadixSort sort = new RadixSort();
        sort.redisSort(a);
        sort.print(a);
    }


}
