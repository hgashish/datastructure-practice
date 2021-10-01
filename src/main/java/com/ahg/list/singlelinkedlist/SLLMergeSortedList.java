package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLMergeSortedList {

    public static <T extends Comparable> ListNode<T> merge(ListNode<T> head1, ListNode<T> head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }

        ListNode<T> head = null, lastNode = null;
        while(head1 != null && head2 != null) {
            ListNode<T> nodeToAdd = null;
            if(head1.getData().compareTo(head2.getData()) <= 0) {
                ListNode<T> nextNode = head1.getNext();
                nodeToAdd = head1;
                head1 = nextNode;
            } else if(head2.getData().compareTo(head1.getData()) < 0) {
                ListNode<T> nextNode = head2.getNext();
                nodeToAdd = head2;
                head2 = nextNode;
            }
            if(lastNode != null) {
                lastNode.setNext(nodeToAdd);
                nodeToAdd.setNext(null);
            } else {
                head = nodeToAdd;
            }
            lastNode = nodeToAdd;
        }

        ListNode<T> pendHead = head1 == null ? head2 : head1;
        if(pendHead != null) {
            lastNode.setNext(pendHead);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> head1 = SingleLinkedListUtil.createList(1, 3, 4, 6, 8);
        ListNode<Integer> head2 = SingleLinkedListUtil.createList(2, 3, 5, 6, 10);

        ListNode<Integer> result = merge(head1, head2);
        SingleLinkedListUtil.printList(result);
    }
}
