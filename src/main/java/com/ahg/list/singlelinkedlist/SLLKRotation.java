package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLKRotation {

    public static <T> ListNode<T> rotateKTimes(ListNode<T> head, int k) {
        if(head == null || head.getNext() == null || k <= 0) {
            return head;
        }

        ListNode<T> kthNode = head;
        while(k > 0) {
            kthNode = kthNode.getNext();
            if (kthNode == null) {
                kthNode = head;
            }
            k--;
        }

        if(kthNode == head) {
            return head;
        }
        ListNode<T> tailNode = head;
        while(kthNode.getNext() != null) {
            kthNode = kthNode.getNext();
            tailNode = tailNode.getNext();
        }

        kthNode.setNext(head);
        head = tailNode.getNext();
        tailNode.setNext(null);

        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = SingleLinkedListUtil.createList(1, 2, 3, 4, 5);
        SingleLinkedListUtil.printList(head);
        head = rotateKTimes(head, 2);
        SingleLinkedListUtil.printList(head);
    }
}
