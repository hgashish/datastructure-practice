package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLMidOfList {

    public static <T> ListNode<T> middleNode(ListNode<T> head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        ListNode<T> slowRunner = head, fastRunner = head.getNext();
        while(fastRunner != null && fastRunner.getNext() != null) {
            slowRunner = slowRunner.getNext();
            fastRunner = fastRunner.getNext().getNext();
        }

        return slowRunner;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = SingleLinkedListUtil.createList(1, 2, 3, 4, 5, 6);
        ListNode<Integer> middleNode = middleNode(head);
        System.out.println(middleNode);

        head = SingleLinkedListUtil.createList(1, 2, 3, 4, 5);
        middleNode = middleNode(head);
        System.out.println(middleNode);
    }
}
