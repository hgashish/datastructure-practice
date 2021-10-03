package com.ahg.stack;

import com.ahg.stack.common.SingleListStack;
import com.ahg.stack.common.Stack;
import com.ahg.stack.common.StackEmptyException;
import lombok.SneakyThrows;

public class MinStackSpaceOptimized<T extends Comparable> implements Stack<T> {

    private SingleListStack<T> dataStack = new SingleListStack<>();
    private SingleListStack<T> minStack = new SingleListStack<>();

    @Override
    public void push(T item) {
        dataStack.push(item);
        try {
            if(minStack.isEmpty() || minStack.top().compareTo(item) >= 0) {
                minStack.push(item);
            }
        } catch (StackEmptyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T pop() throws StackEmptyException {
        T val = dataStack.pop();
        if(val == minStack.top()) {
            minStack.pop();
        }
        return val;
    }

    @Override
    public T top() throws StackEmptyException {
        return dataStack.top();
    }

    public T min() throws StackEmptyException {
        return minStack.top();
    }

    @Override
    public int size() {
        return dataStack.size();
    }

    @Override
    public boolean isEmpty() {
        return dataStack.isEmpty();
    }

    @SneakyThrows
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("minStack=")
                .append(minStack.toString()).append(", dataStack=")
                .append(dataStack.toString());
        return sb.toString();
    }

    public static void main(String[] args) throws StackEmptyException {
        MinStackSpaceOptimized<Integer> stack = new MinStackSpaceOptimized<>();
        stack.push(4);
        System.out.println(stack);

        stack.push(3);
        System.out.println(stack);

        stack.push(5);
        System.out.println(stack);

        stack.push(1);
        System.out.println(stack);

        stack.push(3);
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
