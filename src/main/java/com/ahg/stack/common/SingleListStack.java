package com.ahg.stack.common;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SingleListStack<T> implements Stack<T> {

    private ListNode<T> head = null;
    private int size = 0;

    public void push(T item) {
        ListNode<T> newItem = new ListNode<>(item, head);
        size++;
        head = newItem;
    }

    public T pop() throws StackEmptyException {
        if(size <= 0) {
            throw new StackEmptyException();
        }
        ListNode<T> item = head;
        head = head.getNext();
        size--;

        return item.getData();
    }

    public T top() throws StackEmptyException {
        if(size <= 0) {
            throw new StackEmptyException();
        }

        return head.getData();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return SingleLinkedListUtil.toString(head);
    }

    public static void main(String[] args) throws StackEmptyException {
        SingleListStack<Integer> stack = new SingleListStack<>();
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
