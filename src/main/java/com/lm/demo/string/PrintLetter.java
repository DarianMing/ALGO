package com.lm.demo.string;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintLetter {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    public static void main(String[] args) {
        new Thread(new PrintThread("A",conditionA,0,lock)).start();
        new Thread(new PrintThread("B",conditionA,1,lock)).start();
        new Thread(new PrintThread("C",conditionA,2,lock)).start();
    }
 
}