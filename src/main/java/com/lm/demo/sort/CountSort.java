package com.lm.demo.sort;

/**
 *  计数排序 桶排序的特殊形式时间复杂度O（n）
 */
public class CountSort {

    public void countSort (int[] a) {
        if (a.length < 2) return;
        int min = a[0];
        int max = a[1];
        //找到最大值和最小值
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            } else if (a[i] < min) {
                min = a[i];
            }
        }
        int diff = max - min;
        // 申请一个计数数组c，下标大小[0,diff]
        int[] c = new int[diff + 1];
        // 计算每个元素的个数，放入c中
        for (int i = 0; i < a.length ; i++) {
            c[a[i] - min]++;
        }
        // 依次累加
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i-1];
        }
        // 临时数组r，存储排序之后的结果
        int[] r = new int[a.length];
        // 计算排序的关键步骤
        for (int i = a.length - 1; i >= 0; i--) {
            int index = c[a[i] - min]-- - 1;
            r[index] = a[i];
            //c[a[i] - min]--;
        }
        // 将结果拷贝会a数组
        for (int i = 0; i < a.length ; i++) {
            a[i] = r[i];
        }
    }

    public void print (int[] a) {
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,4,7,9,8,11};
        CountSort countSort = new CountSort();
        countSort.countSort(a);
        countSort.print(a);
    }

}
