package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLCommonItemList {

    public static <T extends Comparable> ListNode<T> commonList(ListNode<T> head1, ListNode<T> head2) {
        if (head1 == null || head2 == null) {
             return null;
        }

        ListNode<T> head = null, currentNode = null;
        while(head1 != null && head2 != null) {
            int compValue = head1.getData().compareTo(head2.getData());
            if(compValue == 0) {
                ListNode<T> temp = new ListNode<>(head1.getData(), null);
                if(currentNode != null) {
                    currentNode.setNext(temp);
                } else {
                    head = temp;
                }
                currentNode = temp;
                head1 = head1.getNext();
                head2 = head2.getNext();
            } else if(compValue < 0) {
                head1 = head1.getNext();
            } else {
                head2 = head2.getNext();
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> head1 = SingleLinkedListUtil.createList(1, 2, 5, 8, 10);
        ListNode<Integer> head2 = SingleLinkedListUtil.createList(2, 3, 6, 8, 10, 12);

        ListNode<Integer> head = commonList(head1, head2);
        SingleLinkedListUtil.printList(head);
    }
}
