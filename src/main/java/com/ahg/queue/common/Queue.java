package com.ahg.queue.common;

public interface Queue<T> {

    T removeFront() throws QueueEmptyException;

    void addRear(T item) throws QueueFullException;

    void clear();

    int size();

    T peekFront() throws QueueEmptyException;

    boolean isEmpty();
}
