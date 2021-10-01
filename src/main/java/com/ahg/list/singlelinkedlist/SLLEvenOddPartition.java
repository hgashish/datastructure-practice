package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLEvenOddPartition {

    public static ListNode<Integer> partition(ListNode<Integer> head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        ListNode<Integer> evenHead = null, evenCurrNode = null, oddHead = null, oddCurrNode = null;
        while(head != null) {
            ListNode<Integer> nextNode = head.getNext();
            if(head.getData() % 2 == 0) {
                if(evenCurrNode != null) {
                    evenCurrNode.setNext(head);
                } else {
                    evenHead = head;
                }
                evenCurrNode = head;
            } else {
                if(oddCurrNode != null) {
                    oddCurrNode.setNext(head);
                } else {
                    oddHead = head;
                }
                oddCurrNode = head;
            }
            head.setNext(null);
            head = nextNode;
        }

        evenCurrNode.setNext(oddHead);
        return evenHead;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = SingleLinkedListUtil.createList(1, 4, 2, 3, 5, 6, 1, 9, 8);
        head = partition(head);
        SingleLinkedListUtil.printList(head);
    }
}
