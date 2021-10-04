package com.ahg.queue.common;

import java.util.Arrays;

public class DynamicArrayCircularQueue<T> implements Queue<T> {

    private static final int MIN_CAPACITY = 4;
    private T[] array;
    private int size, front, rear;

    public DynamicArrayCircularQueue() {
        this(MIN_CAPACITY);
    }

    public DynamicArrayCircularQueue(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }
    @Override
    public T removeFront() throws QueueEmptyException {
        if(isEmpty()) {
            throw new QueueEmptyException();
        }
        T item = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;

        if(((float)size / array.length) <= 0.25f && (array.length * 2) > MIN_CAPACITY) {
            shrinkArray();
        }

        return item;
    }

    private void copyItemsToArray(T[] src, T[] dest, int srcStart, int destStart, int size) {
        while(size-- > 0) {
            dest[destStart++ % dest.length] = src[srcStart++ % src.length];
        }
    }

    private void shrinkArray() {
        int newCapacity = Math.max(array.length / 2, MIN_CAPACITY);
        T[] newArray = (T[]) new Object[newCapacity];
        copyItemsToArray(array, newArray, front, 0, size);
        array = newArray;
        front = 0;
        rear = size;
    }

    @Override
    public void addRear(T item) throws QueueFullException {
        if(size() == array.length) {
            expandArray();
        }
        array[rear] = item;
        rear = (rear + 1) % array.length;
        size++;
    }

    private void expandArray() {
        int newCapacity = array.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        copyItemsToArray(array, newArray, front, 0, size);
        array = newArray;
        front = 0;
        rear = size;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
        rear = front = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T peekFront() throws QueueEmptyException {
        return array[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "DynamicArrayCircularQueue{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("***ADD***");
        Queue<Integer> queue = new DynamicArrayCircularQueue<>();
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

        System.out.println("***ADD***");
        queue.addRear(6);
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
