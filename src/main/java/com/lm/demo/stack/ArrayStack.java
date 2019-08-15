package com.lm.demo.stack;

public class ArrayStack {

    public int[] items; //数组
    public int count;   //栈中元素个数
    public int n;       //栈的大小

    public ArrayStack (int n) {
        items = new int[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push (int item) {
        if (count == n) return false;
        items[count++] = item;
        return true;
    }

    public int pop () {
        if (count == 0) throw new RuntimeException("stack is empty");
        return items[count-- - 1];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }


}
