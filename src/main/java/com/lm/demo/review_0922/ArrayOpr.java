package com.lm.demo.review_0922;

public class ArrayOpr {

    /**
     *  找出数组中第二大元素
     */
    public void secondMax (int[] arr) {
        int max1 = arr[0];
        int max2 = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2) {
                max2 = arr[i];
            }
        }
        System.out.println(max2);
    }

    /**
     * 最大子数组之和
     */
    public void maxSubArray (int[] a) {
        int low = 0;
        int high = 0;
        int sum = 0;
        for (int i = 0; i < a.length ; i++) {
            for (int j = i; j < a.length; j++) {
                int curSum = 0;
                for (int k = i; k <= j ; k++) {
                    curSum += a[k];
                }
                if (curSum > sum) {
                    sum = curSum;
                    low = i;
                    high = j;
                }
            }
        }
        System.out.println("起始位置：" + low + " 终止位置：" + high + " 和为：" + sum);
    }

    /**
     * 最大子数组之和
     */
    public void maxSubArray1 (int[] a) {
        int low = 0;
        int high = 0;
        int sum = 0;
        int[] sumArr = new int[a.length];
        sumArr[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            sumArr[i] = a[i] + sumArr[i-1];
        }
        for (int i = 0; i < a.length ; i++) {
            int max = i;
            int curSum = sum;
            for (int j = i; j < sumArr.length; j++) {
                if (sumArr[j] > curSum) {
                    curSum = sumArr[j];
                    max = j;
                }
            }
            if (curSum > sum) {
                sum = sumArr[max];
                low = i;
                high = max;
            }
            for (int j = i+1; j < sumArr.length ; j++) {
                sumArr[j] -= a[i];
            }
        }
        System.out.println("起始位置：" + low + " 终止位置：" + high + " 和为：" + sum);
    }

    /**
     * 数组两元素和等于给定值
     */
    public void findSum (int[] a , int sum) {
        for (int i = 0; i < a.length ; i++) {
            for (int j = i + 1; j < a.length ; j++) {
                if ((a[i] + a[j] == sum)) {
                    System.out.println("i = " + a[i] + " j = " + a[j]);
                }
            }
        }
    }

    /**
     * 反转数组
     */
    public void reverse (int[] a ,int low , int high) {
        while (low < high) {
            int tmp = a[low];
            a[low] = a[high];
            a[high] = tmp;
            low++;
            high--;
        }
        print(a);
    }

    /**
     * 找出数组中第k小的树
     */
    public int findMinK (int[] a , int p , int r , int k) {
        int index = patition(a, p, r);
        if ((index + 1) == k) return a[index];
        if ((index + 1) > k) return findMinK(a , p , index - 1 , k);
        else return findMinK(a , index + 1 , r , k);
    }

    public int patition (int[] a , int p , int r) {
        int value = a[r];
        int i = p;
        for (int j = p; j < r ; j++) {
            if (a[j] < value) {
                swap(a , i , j);
                i++;
            }
        }
        swap(a , i , r);
        return i;
    }

    /**
     * 找出数组中只出现一次的数字
     */
    public void findOnce (int[] a , int k) {
        if ( k % 2 == 0 ) {
            findOnceO(a);
        } else {
            findOnceJ(a , k);
        }
    }
    
    public void findOnceO (int[] a) {
        int ret = a[0];
        for (int i = 1; i < a.length ; i++) {
            ret ^= a[i];
        }
        System.out.println(ret);
    }


    public void findOnceJ (int[] a , int k) {
        int[] count = new int[32];
        for (int i = 0; i < a.length ; i++) {
            for (int j = 0; j < 32 ; j++) {
                count[j] += ((a[i] >> j) & 1);
            }
        }
        int ret = 0;
        for (int i = 0; i < 32 ; i++) {
            if (count[i] % k != 0) {
                ret += (1 << i);
            }
        }
        System.out.println(ret);
    }

    public int findMax (int[] a , int i) {
        if (i + 1 == a.length) {
            return a[i];
        }
        return Math.max(a[i] , findMax(a , ++i));
    }

    public void getMax (int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length ; i++) {
            for (int j = i; j < a.length ; j++) {
                if (a[i] - a[j] > max) {
                    max = a[i] - a[j];
                }
            }
        }
        System.out.println(max);
    }

    /**
     * 求数组中两个元素的最小距离
     */
    public void minDistance (int[] a , int n1 , int n2) {
        int i = -1;
        int j = -1;
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < a.length ; k++) {
            if (a[k] == n1) {
                i = k;
                if (j != -1) {
                    int abs = Math.abs(k - j);
                    if (abs < min) min = abs;
                }
            } else if (a[k] == n2) {
                j = k;
                if (i != -1) {
                    int abs = Math.abs(k - i);
                    if (abs < min) min = abs;
                }
            }
        }
        System.out.println(min);
    }

    public void swap (int[] a, int p , int r) {
        int tmp = a[p];
        a[p] = a[r];
        a[r] = tmp;
    }

    /**
     * 数组循环右移k位
     */
    public void shiftK (int[] a , int k) {
        reverse(a , 0 , a.length - k - 1);
        reverse(a , a.length - k , a.length - 1);
        reverse(a , 0 , a.length - 1);
    }

    public void print (int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{1,5,2,8,12,20};
//        int[] arr = new int[]{1,4,17,3,2,9};
       // int[] arr = new int[]{1,1,1,4,4,4,6,2,2,2};
        int[] arr = new int[]{4,5,6,4,7,4,6,4,7,8,5,6,4,3,10,8};
        ArrayOpr arrayOpr = new ArrayOpr();
//        arrayOpr.secondMax(arr);
//        arrayOpr.maxSubArray(arr);
//        arrayOpr.maxSubArray1(arr);
//        arrayOpr.findSum(arr , 20);
//        arrayOpr.reverse(arr , 0 , arr.length - 1);
//        arrayOpr.shiftK(arr , 2);
//        int minK = arrayOpr.findMinK(arr, 0, arr.length - 1, 5);
//        System.out.println(minK);
//        arrayOpr.findOnceJ(arr , 3);
//        System.out.println(arrayOpr.findMax(arr , 0));
//        arrayOpr.getMax(arr);
        arrayOpr.minDistance(arr , 4 , 8);
    }

}
