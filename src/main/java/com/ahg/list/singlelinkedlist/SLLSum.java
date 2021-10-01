package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLSum {

    public static ListNode<Integer> sum(ListNode<Integer> head1, ListNode<Integer> head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }

        ListNode<Integer> resultHead = null, lastNode = null;
        int carryForward = 0;
        do {
            int sum = head1.getData() + head2.getData() + carryForward;
            carryForward = sum / 10;
            ListNode<Integer> newNode = new ListNode<>(sum % 10, null);
            if(lastNode != null) {
                lastNode.setNext(newNode);
            } else {
                resultHead = newNode;
            }
            lastNode = newNode;
            head1 = head1.getNext();
            head2 = head2.getNext();
        } while (head1 != null && head2 != null);

        while(head1 != null) {
            int sum = head1.getData() + carryForward;
            carryForward = sum / 10;
            ListNode<Integer> newNode = new ListNode<>(sum % 10, null);
            lastNode.setNext(newNode);
            lastNode = newNode;
            head1 = head1.getNext();
        }

        while(head2 != null) {
            int sum = head2.getData() + carryForward;
            carryForward = sum / 10;
            ListNode<Integer> newNode = new ListNode<>(sum % 10, null);
            lastNode.setNext(newNode);
            lastNode = newNode;
            head2 = head2.getNext();
        }

        if(carryForward > 0) {
            ListNode<Integer> newNode = new ListNode<>(carryForward, null);
            lastNode.setNext(newNode);
        }

        return resultHead;
    }

    public static void main(String[] args) {
        ListNode<Integer> head1 = SingleLinkedListUtil.createList(5, 3, 6);
        ListNode<Integer> head2 = SingleLinkedListUtil.createList(4, 7, 9);

        ListNode<Integer> sumList = sum(head1, head2);
        SingleLinkedListUtil.printList(sumList);
    }
}
