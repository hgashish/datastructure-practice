package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLNthNodeFromEnd {

    public static <T> ListNode<T> findNthNodeFromEnd(ListNode<T> head, int n) {
        if(head == null) {
            return head;
        }
        ListNode<T> currentNode = head;
        while(currentNode != null && n > 0) {
            currentNode = currentNode.getNext();
            n--;
        }
        if (n > 0) {
            return null;
        }
        while(currentNode != null) {
            currentNode = currentNode.getNext();
            head = head.getNext();
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = SingleLinkedListUtil.createList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ListNode<Integer> nthNode = findNthNodeFromEnd(head, 2);
        System.out.println(nthNode);

        nthNode = findNthNodeFromEnd(head, 1);
        System.out.println(nthNode);

        nthNode = findNthNodeFromEnd(head, 5);
        System.out.println(nthNode);
    }
}
