package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLYListIntersectingNode {

    public static <T> ListNode<T> findIntersectingNode(ListNode<T> head1, ListNode<T> head2) {
        if(head1 == null || head2 == null) {
            return null;
        }
        int l1 = SingleLinkedListUtil.size(head1);
        int l2 = SingleLinkedListUtil.size(head2);
        int diff = Math.abs(l1 - l2);

        ListNode<T> shortList = l1 < l2 ? head1 : head2;
        ListNode<T> longList = l1 < l2 ? head2 : head1;

        while(diff-- > 0) {
            longList = longList.getNext();
        }

        while(shortList != null && longList != null && shortList != longList) {
            shortList = shortList.getNext();
            longList = longList.getNext();
        }

        return shortList == longList ? shortList : null;
    }

    public static void main(String[] args) {
        ListNode<Integer> interHead = SingleLinkedListUtil.createList(7, 8, 9, 10);
        ListNode<Integer> head1 = SingleLinkedListUtil.createList(1, 2, 3, 4, 5, 6);
        ListNode<Integer> head2 = SingleLinkedListUtil.createList(4, 5, 6);

        ListNode<Integer> tail1 = SLLFindTailNode.findTail(head1);
        ListNode<Integer> tail2 = SLLFindTailNode.findTail(head2);

        tail1.setNext(interHead);
        tail2.setNext(interHead);

        ListNode<Integer> intersectNode = findIntersectingNode(head1, head2);
        System.out.println(intersectNode);
    }
}
