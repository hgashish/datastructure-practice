package com.ahg.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class StackSort {

    public static <T extends Comparable> void sort(Deque<T> stack) {
        if(stack == null || stack.isEmpty()) {
            return;
        }

        Deque<T> tempStack = new LinkedList<>();
        while(!stack.isEmpty()) {
            T ti = stack.pop();
            while(!tempStack.isEmpty() && ti.compareTo(tempStack.peek()) < 0) {
                stack.push(tempStack.pop());
            }
            tempStack.push(ti);
        }

        while(!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>(List.of(4, 5, 3, 1, 7, 2, 9));
        sort(stack);
        System.out.println(stack);
    }
}
