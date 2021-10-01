package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLFindTailNode {

    public static <T> ListNode<T> findTail(ListNode<T> head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        while(head.getNext() != null) {
            head = head.getNext();
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = SingleLinkedListUtil.createList(1, 2, 3, 4, 5, 6);
        ListNode<Integer> tail = findTail(head);
        System.out.println(tail);
    }
}
