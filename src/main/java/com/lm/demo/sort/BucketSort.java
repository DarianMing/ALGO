package com.lm.demo.sort;

/**
 *  桶排序 最好时间复杂度O（n）
 */
public class BucketSort {

    public void bucketSort (int[] a , int bucketSize) {
        if (a.length < 2) return;
        int max = a[0];
        int min = a[1];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            } else if (a[i] > max) {
                max = a[i];
            }
        }
        //桶数量 根据数组最大值和最小值以及桶容量计算
        int bucketCount = (max - min) / bucketSize + 1;
        //桶
        int[][] bucket = new int[bucketCount][bucketSize];
        //每个桶的实际数据容量数组
        int[] bucketIndex = new int[bucketCount];
        for (int i = 0; i < a.length; i++) {
            //计算出该元素的的桶索引
            int index = (a[i] - min) / bucketSize;
            //判断是否需要桶扩容
            if (bucket[index].length == bucketIndex[index]) {
                ensureCapacity(bucket , index);
            }
            //数据入桶
            bucket[index][bucketIndex[index]++] = a[i];
        }
        int k = 0;
        for (int i = 0; i < bucket.length ; i++) {
            //空桶无需排序
            if (bucketIndex[i] == 0) continue;
            //快排桶内数据
            quickSort(bucket[i] , 0 , bucketIndex[i] -1);
            for (int j = 0; j < bucketIndex[i]; j++) {
                a[k++] = bucket[i][j];
            }
        }
    }

    /**
     * 数组扩容
     */
    public void ensureCapacity (int[][] a , int bucketIndex) {
        int[] newArr = new int[2 * a[bucketIndex].length];
        for (int i = 0; i < a[bucketIndex].length ; i++) {
            newArr[i] = a[bucketIndex][i];
        }
        a[bucketIndex] = newArr;
    }

    /**
     * 快排递归函数
     */
    public void quickSort (int[] a , int p , int r) {
        if (p >= r) return;
        int partition = partition(a, p, r);
        quickSort(a , p , partition - 1);
        quickSort(a , partition + 1 , r);
    }

    /**
     * 快排分区函数
     */
    public int partition (int[] a , int p , int r) {
        int value = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] <= value) {
                swap(a , i , j);
                i++;
            }
        }
        swap(a , i , r);
        return i;
    }

    public void swap (int[] a , int i , int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void print (int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,8,7,6,9,5,12,96,45,78};
        BucketSort sort = new BucketSort();
        sort.bucketSort(a , 4);
        sort.print(a);
    }

}
