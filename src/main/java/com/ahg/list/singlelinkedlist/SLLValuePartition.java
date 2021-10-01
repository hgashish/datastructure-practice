package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLValuePartition {

    public static <T extends Comparable> ListNode<T>[] partition(ListNode<T> head, T value) {
        ListNode<T>[] result = new ListNode[2];
        if(head == null || head.getNext() == null) {
            result[0] = head;
            return result;
        }

        ListNode<T> lowPartitionCurrNode = null, highPartitionCurrNode = null;
        while(head != null) {
            ListNode<T> nextNode = head.getNext();
            if(head.getData().compareTo(value) < 0) {
                if(lowPartitionCurrNode != null) {
                    lowPartitionCurrNode.setNext(head);
                    head.setNext(null);
                } else {
                    result[0] = head;
                }
                lowPartitionCurrNode = head;
            } else {
                if(highPartitionCurrNode != null) {
                    highPartitionCurrNode.setNext(head);
                    head.setNext(null);
                } else {
                    result[1] = head;
                }
                highPartitionCurrNode = head;
            }
            head = nextNode;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = SingleLinkedListUtil.createList(1, 5, 2, 9, 1, 7, 3, 4, 7);
        ListNode<Integer>[] result = partition(head, 5);

        System.out.println("Low partition :");
        SingleLinkedListUtil.printList(result[0]);

        System.out.println("High partition :");
        SingleLinkedListUtil.printList(result[1]);
    }
}
