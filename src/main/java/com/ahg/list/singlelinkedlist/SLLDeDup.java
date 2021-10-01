package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

import java.util.HashSet;
import java.util.Set;

public class SLLDeDup {

    public static <T> void dedup1(ListNode<T> head) {
        if(head == null || head.getNext() == null) {
            return;
        }

        while(head != null) {
            ListNode<T> lastNode = head;
            ListNode<T> nextNode = head.getNext();
            while(nextNode != null) {
                if(nextNode.getData().equals(head.getData())) {
                    lastNode.setNext(nextNode.getNext());
                } else {
                    lastNode = nextNode;
                }
                nextNode = nextNode.getNext();
            }
            head = head.getNext();
        }
    }

    public static <T> void dedup2(ListNode<T> head) {
        if(head == null || head.getNext() == null) {
            return;
        }

        Set<T> dataSet = new HashSet<>();
        ListNode<T> prevNode = null;

        while(head != null) {
            if(dataSet.contains(head.getData())) {
                prevNode.setNext(head.getNext());
            } else {
                prevNode = head;
                dataSet.add(prevNode.getData());
            }
            head = head.getNext();
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> head = SingleLinkedListUtil.createList(1, 1, 3, 9, 1, 2, 6, 2, 9);
        dedup1(head);
        SingleLinkedListUtil.printList(head);

        dedup2(head);
        SingleLinkedListUtil.printList(head);
    }
}
