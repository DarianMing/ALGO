package com.lm.demo.string;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class BM {

    public int[] generateStr (String s) {
        int len = s.length();
        int[] a = new int[256];
        for (int i = 0; i < 256; i++) {
            a[i] = -1;
        }
        for (int i = 0; i < len ; i++) {
            int ascii = (int)s.charAt(i);
            a[ascii] = i;
        }
        return a;
    }

    public int bm (String s1 , String s2) {
        int lenS1 = s1.length();
        int lenS2 = s2.length();
        if (lenS1 < lenS2) return -1;
        int[] matchArr = generateStr(s2);
        int i = 0;
        while (i <= lenS1 - lenS2) {
            boolean isEqual = true;
            int j = lenS2 - 1;
            for ( ; j >= 0 ; j--) {
                if (s1.charAt(i + j) != s2.charAt(j)){
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) return i;
            int index = matchArr[(int)s1.charAt(i + j)];
            i = index == -1 ? i + lenS2 : i + j - index;
        }
        return -1;
    }

    public static void main(String[] args) {
        BM bm = new BM();
        String s1 = "compareString";
        String s2 = "compareString";
        String s3 = "compareStrStr";
        String s4 = "ring";
        System.out.println(bm.bm(s1 , s4));
    }


}
