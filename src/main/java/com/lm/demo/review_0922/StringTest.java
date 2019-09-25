package com.lm.demo.review_0922;

public class StringTest {

    public void compare (String s1 , String s2) {
        int ret = s1.charAt(0) ^ s2.charAt(0);
        for (int i = 1; i < s1.length() ; i++) {
            ret = ret ^ s1.charAt(i) ^ s2.charAt(i);
        }
        System.out.println(ret == 0);
    }

    public void removeDup (String s) {
        char[] chars = s.toCharArray();
        int[] flag = new int[8];
        for (int i = 0; i < chars.length ; i++) {
            int i1 = chars[i] / 32;
            int i2 = chars[i] % 32;
            if ((flag[i1] & (1 << i2)) != 0) {
                chars[i] = '\0';
            }
            flag[i1] |= 1 << i2;
        }
        int l = 0;
        for (int i = 0; i < chars.length ; i++) {
            if (chars[i] != '\0') {
                chars[l++] = chars[i];
            }
        }
        System.out.println(new String(chars , 0 , l));
    }

    public void wordCount (String s) {
        int word = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                word = 0;
            } else if (word == 0) {
                count++;
                word = 1;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext
        StringTest stringTest = new StringTest();
//        stringTest.compare("aaaabbc" , "abcbaaa");
////        String s = new String("abcdc".toCharArray() , 0 , 1);
//        stringTest.removeDup("abcaabcd");
        stringTest.wordCount("how are     you");
    }

}
