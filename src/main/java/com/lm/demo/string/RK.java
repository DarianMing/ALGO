package com.lm.demo.string;

public class RK {

    public boolean inChild (String s1 , String s2) {
        int lenS1 = s1.length();
        int lenS2 = s2.length();
        if (lenS1 < lenS2) return false;
        int hashS2 = calHash(s2 ,0 , lenS2);
        int[] hashArr = new int[lenS1];
        hashArr[0] = calHash(s1 , 0 , 1);
        for (int i = 1; i < lenS1; i++) {
            hashArr[i] = hashArr[i-1] - (int)Math.pow(57 , lenS2) * (s1.charAt(i - 1) - 'a') + s1.charAt(i + lenS2 - 1) - 'a';
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (hashArr[i] != hashS2) continue;
            boolean isEqual = true;
            for (int j = i , k = 0; j < i + lenS2 ; j++) {
                if (s1.charAt(j) != s2.charAt(k++) ) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) return true;
        }
        return false;
    }

    public int calHash (String s , int start , int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += s.charAt(i) - 'a';
        }
        return sum;
    }
    
    public static boolean comp (String s1 , String s2) {
        for (int i = 0; i < s1.length() ; i++) {
            if (s1.charAt(i) != s2.charAt(i) ){
                return false;
            }
        }
        return true;
    }

    public static int rK(String a,String b) {
        int m=a.length(),n=b.length(),s,j;
        int[] hash=new int[m-n+1];
        int[] table=new int[26];
        char[] a1=a.toCharArray();
        char[] b1=b.toCharArray();
        s=1;
        //将26的次方存储在一个表里，取的时候直接用,虽然溢出，但没啥问题
        for(j=0;j<26;j++) {
            table[j]=s;
            s*=26;
        }
        for(int i=0;i<=m-n;i++) {
            s=0;
            for(j=0;j<n;j++) {
                s+=(a1[i+j]-'a')*table[n-1-j];
            }
            hash[i]=s;
        }
        s=0;
        for(j=0;j<n;j++) {
            s+=(b1[j]-'a')*table[n-1-j];
        }
        for(j=0;j<m-n+1;j++) {
            if(hash[j]==s) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RK rk = new RK();
        System.out.println();
    }

}
