package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

/**
 * Given a singly linked list L: L1-> L2-> L3...-> Ln–1-> Ln, reorder it to: L1->
 * Ln-> L2-> Ln–1......
 */
public class SLLReorderList {

    public static <T> void reorder(ListNode<T> head) {
        if(head == null || head.getNext() == null) {
            return;
        }

        ListNode<T> midNode = SLLMidOfList.middleNode(head);
        ListNode<T> head2 = midNode.getNext();
        midNode.setNext(null);

        ListNode<T> head1 = head;
        head2 = SLLReverseList.reverseIterative(head2);

        ListNode<T> prevNode = null;
        while(head1 != null && head2 != null) {
            ListNode<T> nextnode1 = head1.getNext(), nextnode2 = head2.getNext();
            if(prevNode != null) {
                prevNode.setNext(head1);
            }
            head1.setNext(head2);
            head2.setNext(null);

            prevNode = head2;
            head1 = nextnode1;
            head2 = nextnode2;
        }

        ListNode<T> pendingHead = head1 != null ? head1 : head2;
        prevNode.setNext(pendingHead);
    }

    public static void main(String[] args) {
        ListNode<Integer> head = SingleLinkedListUtil.createList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        reorder(head);
        SingleLinkedListUtil.printList(head);

        head = SingleLinkedListUtil.createList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        reorder(head);
        SingleLinkedListUtil.printList(head);
    }
}
