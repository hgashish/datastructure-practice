package com.ahg.list.singlelinkedlist.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingleLinkedListUtil {

    public static <T> void printList(ListNode<T> head) {
        System.out.println(toString(head));
    }

    public static <T> String toString(ListNode<T> head) {
        if(head == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder("[ ");
        while(head != null) {
            sb.append(head.getData()).append(" -> ");
            head = head.getNext();
        }
        sb.append("null ]");
        return sb.toString();
    }

    public static <T> ListNode<T> createList(T... vals) {
        if(vals == null || vals.length == 0) {
            return null;
        }

        ListNode<T> head = new ListNode<>(vals[0], null);
        ListNode<T> lastNode = head;
        for(int i = 1; i < vals.length; i++) {
            ListNode<T> newNode = new ListNode<>(vals[i], null);
            lastNode.setNext(newNode);
            lastNode = newNode;
        }

        return head;
    }

    public static <T> int size(ListNode<T> head) {
        if(head == null) {
            return 0;
        }
        int count = 0;
        while(head != null) {
            count++;
            head = head.getNext();
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("Null list");
        ListNode<Integer> head = createList(null);
        printList(head);

        System.out.println("empty list");
        head = createList();
        printList(head);

        System.out.println("One item in list");
        head = createList(1);
        printList(head);

        System.out.println("in list");
        head = createList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        printList(head);
    }
}
