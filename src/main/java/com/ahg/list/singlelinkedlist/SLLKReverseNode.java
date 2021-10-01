package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLKReverseNode {

    public static <T> ListNode<T> swapKNodes(ListNode<T> head, int k) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        ListNode<T> newListTail = null, newListHead = null;
        while(head != null) {
            ListNode<T> currBlockHead = head;
            ListNode<T> currBlockTail = findKthNode(head, k);
            if(currBlockTail == null) {
                newListTail.setNext(head);
                break;
            } else {
                ListNode<T> nextBlockHead = currBlockTail.getNext();

                currBlockTail.setNext(null);
                ListNode<T> prevNode = null;
                while (head != null) {
                    ListNode<T> nextNode = head.getNext();
                    head.setNext(prevNode);
                    prevNode = head;
                    head = nextNode;
                }

                if (newListTail != null) {
                    newListTail.setNext(currBlockTail);
                } else {
                    newListHead = currBlockTail;
                }
                newListTail = currBlockHead;
                head = nextBlockHead;
            }
        }

        return newListHead;
    }

    private static <T> ListNode<T> findKthNode(ListNode<T> head, int k) {
        if(head == null) {
            return head;
        }
        while(k > 1 && head != null) {
            head = head.getNext();
            k--;
        }
        return k == 1 ? head : null;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = SingleLinkedListUtil.createList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        head = swapKNodes(head, 3);
        SingleLinkedListUtil.printList(head);

        head = SingleLinkedListUtil.createList(1, 2, 3, 4, 5, 6, 7, 8);
        head = swapKNodes(head, 3);
        SingleLinkedListUtil.printList(head);
    }
}
