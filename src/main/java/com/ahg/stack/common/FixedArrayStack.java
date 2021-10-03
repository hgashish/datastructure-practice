package com.ahg.stack.common;

import java.util.Arrays;

public class FixedArrayStack<T> implements Stack<T> {

    private int capacity;
    private int top = -1;
    private T[] array;

    public FixedArrayStack() {
        this(16);
    }

    public FixedArrayStack(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public int size() {
        return (top + 1);
    }

    public void push(T item) throws StackFullException {
        if(size() == capacity) {
            throw new StackFullException();
        }
        array[++top] = item;
    }

    public T pop() throws StackEmptyException {
        if(size() <= 0) {
            throw new StackEmptyException();
        }

        return array[top--];
    }

    public T top() throws StackEmptyException {
        if(size() <= 0) {
            throw new StackEmptyException();
        }

        return array[top];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("capacity=").append(capacity)
                .append(", top=").append(top).append(", array=[");
        for(int i = 0; i < size(); i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(" TOP]");
        return sb.toString();
    }

    public static void main(String[] args) throws StackFullException, StackEmptyException {
        FixedArrayStack<Integer> stack = new FixedArrayStack<>();
        stack.push(1);
        System.out.println(stack);

        stack.push(2);
        System.out.println(stack);

        stack.push(3);
        System.out.println(stack);

        System.out.println(stack.top());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
    }
}