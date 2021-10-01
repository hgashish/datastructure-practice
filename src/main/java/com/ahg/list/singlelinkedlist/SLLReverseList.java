package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLReverseList {

    public static <T> ListNode<T> reverseIterative(ListNode<T> head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        ListNode<T> prevNode = null;
        while(head != null) {
            ListNode<T> nextNode = head.getNext();
            head.setNext(prevNode);
            prevNode = head;
            head = nextNode;
        }

        return prevNode;
    }

    public static <T> ListNode<T> reverseRecursive(ListNode<T> head) {
        //TODO
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        ListNode<Integer> head = SingleLinkedListUtil.createList(1, 2, 3, 4, 5, 6, 6);
        head = reverseIterative(head);
        SingleLinkedListUtil.printList(head);
    }
}
