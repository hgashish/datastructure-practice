package com.ahg.stack;

import java.util.Arrays;

public class MStack<T> {
    private T[] array = null;
    private int capacity;
    private int M;
    private int topArray[] = null;

    public MStack() {
        this(16, 2);
    }

    public MStack(int capacity, int M) {
        this.capacity = capacity;
        this.M = M;
        this.array = (T[]) new Object[capacity];
        this.topArray = new int[M];
        for(int i = 0; i < M; i++) {
            this.topArray[i] = (capacity / M * i) - 1;
        }
    }

    public void push(int stackId, T item) {
        if(stackId < 0 || stackId >= M) {
            return;
        }
        int maxCap = stackId == M - 1 ? capacity - 1 : (capacity / M * (stackId + 1) - 1);
        if(topArray[stackId] == maxCap) {
            System.out.println("Stack Full");
            return;
        }
        array[++topArray[stackId]] = item;
    }

    public T pop(int stackId) {
        if(stackId < 0 || stackId >= M) {
            return null;
        }
        if(topArray[stackId] == ((capacity / M * stackId) - 1)) {
            System.out.println("Stack empty");
            return null;
        }
        array[topArray[stackId]] = null;
        return array[topArray[stackId]--];
    }

    public T top(int stackId) {
        if(stackId < 0 || stackId >= M) {
            return null;
        }
        if(topArray[stackId] == ((capacity / M * stackId) - 1)) {
            System.out.println("Stack empty");
            return null;
        }
        return array[topArray[stackId]];
    }

    public int size(int stackId) {
        return topArray[stackId] - (capacity / M * stackId) + 1;
    }

    public boolean isEmpty(int stackId) {
        return size(stackId) == 0;
    }

    @Override
    public String toString() {
        return "MStack{" +
                "array=" + Arrays.toString(array) +
                ", topArray=" + Arrays.toString(topArray) +
                '}';
    }

    public static void main(String[] args) {
        MStack<Integer> stack = new MStack<>(6, 2);
        stack.push(1, 1);
        System.out.println(stack);
        stack.push(1, 2);
        System.out.println(stack);
        stack.push(1, 3);
        System.out.println(stack);
        stack.push(1, 4);
        System.out.println(stack);
        stack.push(0, 1);
        System.out.println(stack);
        stack.push(0, 2);
        System.out.println(stack);
        stack.push(0, 3);
        System.out.println(stack);
        stack.push(0, 4);
        System.out.println(stack);
        stack.pop(1);
        System.out.println(stack);
        stack.pop(0);
        System.out.println(stack);
    }
}
