package com.ahg.stack.common;

import java.util.Arrays;

public class DynamicArrayStack<T> implements Stack<T> {
    private static final int MIN_CAPACITY = 4;
    private int capacity;
    private int top = -1;
    private T[] array;

    public DynamicArrayStack() {
        this(MIN_CAPACITY);
    }

    public DynamicArrayStack(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public int size() {
        return (top + 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T item) {
        if(size() == capacity) {
            increaseCapacity();
        }
        array[++top] = item;
    }

    private void increaseCapacity() {
        int currentSize = size();
        int newCapacity = currentSize * 2;
        T[] newArray = Arrays.copyOf(array, newCapacity);
        array = newArray;
        this.capacity = newCapacity;
    }

    private void shrinkCapacity() {
        if(capacity / 2 >= MIN_CAPACITY) {
            int newCapacity = capacity / 2;
            T[] newArray = Arrays.copyOf(array, newCapacity);
            array = newArray;
            this.capacity = newCapacity;
        }
    }

    public T pop() throws StackEmptyException {
        if(size() <= 0) {
            throw new StackEmptyException();
        }
        if(size() <= (capacity / 4)) {
            shrinkCapacity();
        }

        return array[top--];
    }

    public T top() throws StackEmptyException {
        if(size() <= 0) {
            throw new StackEmptyException();
        }

        return array[top];
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

    public static void main(String[] args) throws StackEmptyException {
        DynamicArrayStack<Integer> stack = new DynamicArrayStack<>();
        stack.push(1);
        System.out.println(stack);

        stack.push(2);
        System.out.println(stack);

        stack.push(3);
        System.out.println(stack);

        stack.push(4);
        System.out.println(stack);

        stack.push(5);
        System.out.println(stack);

        System.out.println(stack.top());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
    }
}