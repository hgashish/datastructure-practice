package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLInsertionSort {

    public static <T extends Comparable> ListNode<T> sort(T... vals) {
        if(vals == null || vals.length == 0) {
            return null;
        }

        ListNode<T> head = new ListNode<>(vals[0], null);
        for(int i = 1; i < vals.length; i++) {
            SingleLinkedListUtil.printList(head);
            ListNode<T> currentNode = head, nextNode = head.getNext();

            ListNode<T> temp = new ListNode<>(vals[i], null);
            if(vals[i].compareTo(currentNode.getData()) <= 0) {
                temp.setNext(currentNode);
                head = temp;
            } else {
                while (nextNode != null && currentNode.getData().compareTo(vals[i]) <= 0
                        && nextNode.getData().compareTo(vals[i]) <= 0) {
                    currentNode = nextNode;
                    nextNode = nextNode.getNext();
                }

                currentNode.setNext(temp);
                temp.setNext(nextNode);
            }
        }
        SingleLinkedListUtil.printList(head);
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = sort(3, 1, 6, 4, 2, 1, 2, 9);
        SingleLinkedListUtil.printList(head);
    }
}
