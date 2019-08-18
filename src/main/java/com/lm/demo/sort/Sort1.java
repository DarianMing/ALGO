package com.lm.demo.sort;

public class Sort1 {

    /**
     * 冒泡排序 原地排序（空间复杂度为O（1）），稳定排序
     * 最好时间复杂度O（n） 数组有序 1次冒泡
     * 最坏时间复杂度O（n2） 数组倒序 n次冒泡
     * 平均时间复杂度O（n2）
     */
    public void bubble (int[] a) {
        for (int i = 0; i < a.length - 1 ; i++) {
            boolean flag = false;
            for (int j = 1; j < a.length  - i ; j++) {
                if (a[j-1] > a[j] ) {
                    flag = true;
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    /**
     * 插入排序 原地排序（空间复杂度为O（1）），稳定排序
     * 最好时间复杂度O（n） 数组有序
     * 最坏时间复杂度O（n2） 数组倒序
     * 平均时间复杂度O（n2） 数组单次插入平均时间复杂度为O(n),执行n次循环所以复杂度为O(n2)
     */
    public void insertion (int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0 ; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 选择排序 原地排序（空间复杂度为O（1）），不稳定排序
     * 最好时间复杂度O（n2）
     * 最坏时间复杂度O（n2）
     * 平均时间复杂度O（n2）
     */
    public void select (int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    public void printAll (int[] a) {
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,7,8,6,4};
        Sort1 sort = new Sort1();
        //sort.bubble(a);
        //sort.insertion(a);
        sort.select(a);
        sort.printAll(a);
    }



}
