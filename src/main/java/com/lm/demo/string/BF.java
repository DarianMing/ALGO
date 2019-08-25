package com.lm.demo.string;

public class BF {

    public static boolean inChild (String s1 , String s2) {
        int lenS1 = s1.length();
        int lenS2 = s2.length();
        if (lenS1 < lenS2) return false;
        for (int i = 0; i <= lenS1 - lenS2; i++) {
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

    public static boolean comp (String s1 , String s2) {
        for (int i = 0; i < s1.length() ; i++) {
            if (s1.charAt(i) != s2.charAt(i) ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "compareString";
        String s2 = "compareString";
        String s3 = "compareStrStr";
        System.out.println(BF.comp(s1 , s2));
        System.out.println(BF.comp(s1 , s3));
        System.out.println(BF.inChild(s1 , "com"));
        System.out.println(BF.inChild(s1 , "Str"));
        System.out.println(BF.inChild(s1 , "sr"));
    }
}
