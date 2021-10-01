package com.ahg.list.singlelinkedlist;

import com.ahg.list.singlelinkedlist.common.ListNode;
import com.ahg.list.singlelinkedlist.common.SingleLinkedListUtil;

public class SLLFloydCycle {

    private static <T> ListNode<T> findAnyCycleNode(ListNode<T> head) {
        if(head == null || head.getNext() == null) {
            return null;
        }
        ListNode<T> slowRunner = head, fastRunner = head.getNext();
        while(slowRunner != fastRunner && fastRunner != null && fastRunner.getNext() != null) {
            slowRunner = slowRunner.getNext();
            fastRunner = fastRunner.getNext().getNext();
        }

        return slowRunner == fastRunner ? slowRunner : null;
    }

    public static <T> ListNode<T> cycleStartNode(ListNode<T> head) {
        ListNode<T> cycleNode = findAnyCycleNode(head);

        if(cycleNode == null) {
            return null;
        }
        ListNode<T> nextNode = cycleNode.getNext();
        int count = 1;
        while(nextNode != cycleNode) {
            count++;
            nextNode = nextNode.getNext();
        }
        ListNode<T> currentNode = head;
        while(count > 0) {
            currentNode = currentNode.getNext();
            count--;
        }
        while(head.getNext() != currentNode.getNext()) {
            head = head.getNext();
            currentNode = currentNode.getNext();
        }
        return head.getNext();
    }

    public static <T> boolean hasCycle(ListNode<T> head) {
        return findAnyCycleNode(head) != null;
    }

    public static void main(String[] args) {
        ListNode<Integer> cycleHead = SingleLinkedListUtil.createList(4, 5, 6, 7, 8);
        ListNode<Integer> tail = SLLFindTailNode.findTail(cycleHead);
        tail.setNext(cycleHead);

        ListNode<Integer> head = SingleLinkedListUtil.createList(1, 2, 3);
        tail = SLLFindTailNode.findTail(head);
        tail.setNext(cycleHead);

        System.out.println(hasCycle(head));

        ListNode<Integer> cycleStart = cycleStartNode(head);
        System.out.println(cycleStart);
    }
}
