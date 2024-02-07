package com.algorithm.practice.stack;
//Ref: https://takeuforward.org/data-structure/implement-stack-using-array/
public class StackUsingArray {
    int[] arr;
    int top;

    public StackUsingArray() {
        arr = new int[1000];
        top = -1;
    }

    void push(int data) {
        top++;
        arr[top] = data;
    }

    void pop() {
        top--;
    }

    int peek() {
        return arr[top];
    }

    int size() {
        return top + 1;
    }

}

class Test{
    public static void main(String[] args) {

    }
}
