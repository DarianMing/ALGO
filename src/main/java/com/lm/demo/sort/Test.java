package com.lm.demo.sort;

/**
 *  荷兰国旗问题
 */
public class Test {


    public void func (char[] test) {
        int lower_letter = -1, upper_letter = test.length - 1, current = 0;
        while (test[upper_letter] >= 'A' && test[upper_letter] <= 'Z') upper_letter--;
        while (current <= upper_letter) {
            if (test[current] >= '0' && test[current] <= '9') {
                current++;
            } else if (test[current] >= 'a' && test[current] <= 'z') {
                swap(test , current, lower_letter + 1);
                current++;
                lower_letter++;
            } else {
                swap(test , current , upper_letter);
                while (test[upper_letter] >= 'A' && test[upper_letter] <= 'Z') upper_letter--;
            }
        }
        print(test);
    }

    public void test (char[] chars) {
        int small = 0;
        int big = chars.length - 1;
        int current = 0;
        while (current <= big) {
            if (chars[current] >= 'a' && chars[current] <= 'z') {
                swap(chars , small , current);
                small++;
                current++;
            } else if (chars[current] >= 'A' && chars[current] <= 'Z') {
                swap(chars , big , current);
                big--;
                while (chars[big] >= 'A' && chars[big] <= 'Z') big--;
            } else {
                current++;
                while (chars[current] >= '0' && chars[current] <= '9' && current <= big) current++;
            }
        }
    }

    public void swap (char[] chars , int a , int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    public void print (char[] chars) {
        for (int i = 0; i < chars.length ; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'D', 'a', '3', 'F', '1', 'B', 'c', 'A', 'z', '2'};
        //vector<char> test = {'D', 'a', '3', 'F', '1', 'B', 'c', 'A', 'z', '2'};
        Test test = new Test();
        //test.func(chars);
        test.test(chars);
        test.print(chars);
//        test.print(chars);
    }

}
