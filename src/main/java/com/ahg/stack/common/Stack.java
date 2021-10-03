package com.ahg.stack.common;

public interface Stack<T> {

    void push(T item) throws StackFullException;

    T pop() throws StackEmptyException;

    T top() throws StackEmptyException;

    int size();

    boolean isEmpty();
}
