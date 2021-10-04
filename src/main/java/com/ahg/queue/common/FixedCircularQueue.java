package com.ahg.queue.common;

import java.util.Arrays;

public class FixedCircularQueue<T> implements Queue<T> {
    private T[] array = null;
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    public FixedCircularQueue() {
        this(4);
    }

    public FixedCircularQueue(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public T removeFront() throws QueueEmptyException {
        if(size() == 0) {
            throw new QueueEmptyException();
        }
        T item = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        return item;
    }

    @Override
    public void addRear(T item) throws QueueFullException {
        if(size() == array.length) {
            throw new QueueFullException();
        }
        array[rear] = item;
        rear = (rear + 1) % array.length;
        size++;
    }

    @Override
    public void clear() {
        size = 0;
        Arrays.fill(array, null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T peekFront() throws QueueEmptyException {
        if(size() == 0) {
            throw new QueueEmptyException();
        }
        return array[front];
    }

    @Override
    public String toString() {
        return "FixedCircularQueue{" +
                "array=" + Arrays.toString(array) +
                ", front=" + front +
                ", rear=" + rear +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("***ADD***");
        Queue<Integer> queue = new FixedCircularQueue<>();
        queue.addRear(1);
        System.out.println(queue);

        System.out.println("***peekFront***");
        System.out.println(queue.peekFront());
        System.out.println(queue);

        System.out.println("***removeFront***");
        System.out.println(queue.removeFront());
        System.out.println(queue);

        System.out.println("***ADD***");
        queue.addRear(2);
        System.out.println(queue);

        System.out.println("***ADD***");
        queue.addRear(3);
        System.out.println(queue);

        System.out.println("***ADD***");
        queue.addRear(4);
        System.out.println(queue);

        System.out.println("***ADD***");
        queue.addRear(5);
        System.out.println(queue);

        System.out.println("***removeFront***");
        System.out.println(queue.removeFront());
        System.out.println(queue);

        System.out.println("***removeFront***");
        System.out.println(queue.removeFront());
        System.out.println(queue);

        System.out.println("***removeFront***");
        System.out.println(queue.removeFront());
        System.out.println(queue);

        System.out.println("***removeFront***");
        System.out.println(queue.removeFront());
        System.out.println(queue);
    }
}
