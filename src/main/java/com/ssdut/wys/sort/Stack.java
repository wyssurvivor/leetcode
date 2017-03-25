package com.ssdut.wys.sort;

/**
 * Created by Ryan on 17/3/19.
 */

/**
 * not thread safe
 */
public class Stack {
    private int[] data;
    private int capacity;
    private int topIndex;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.data = new int[this.capacity];
        this.topIndex = -1;
    }

    public boolean isEmpty() {
        return this.topIndex<0;
    }

    public boolean isFull() {
        return this.topIndex>=this.capacity-1;
    }

    public boolean push(int value) throws Exception {
        if(isFull()) {
            throw new Exception("stack is full");
        }

        this.data[++this.topIndex] = value;
        return true;
    }

    public int pop() throws  Exception {
        if(isEmpty()) {
            throw new Exception("stack is empty");
        }


        return this.data[this.topIndex--];
    }

    public int top() throws Exception {
        if(isEmpty()) {
            throw new Exception("stack is empty");
        }

        return this.data[this.topIndex];
    }


}
