package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLSwapPairs {

    public static <T> ListNode<T> pairSwap(ListNode<T> head) {
        if(head == null || head .getNext() == null) {
            return head;
        }

        ListNode<T> currentNode = null, newHead = null;
        while(head != null && head.getNext() != null) {
            ListNode<T> nextNode = head.getNext().getNext();
            head.getNext().setNext(head);
            if(currentNode != null) {
                currentNode.setNext(head.getNext());
            } else {
                newHead = head.getNext();
            }
            currentNode = head;
            head.setNext(null);
            head = nextNode;
        }
        if(head != null) {
            currentNode.setNext(head);
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = SingleLinkedListUtil.createList(1, 2, 3, 4, 5, 6, 7, 8);
        head = pairSwap(head);
        SingleLinkedListUtil.printList(head);
    }
}
