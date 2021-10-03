package com.ahg.stack;

import com.ahg.stack.common.SingleListStack;
import com.ahg.stack.common.Stack;
import com.ahg.stack.common.StackEmptyException;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Finding of Spans: Given an array A the span S[i] of A[i]
 * is the maximum number of consecutive elements A[j]
 * immediately preceding A[i] and such that A[j] ≤ A[j + 1]?
 * Another way of asking: Given an array A of integers,
 * find the maximum of j – i subjected to the constraint
 * of A[i] < A[j].
 */
public class SpanArray {

    public static <T extends Comparable> int[] span(T[] array) {
        if(array == null || array.length == 0) {
            return new int[0];
        }
        int[] span = new int[array.length];
        Deque<T> stack = new LinkedList<>();

        int i = 0;
        for(T a: array) {
            if(!stack.isEmpty() && stack.peek().compareTo(a) > 0) {
                stack.clear();
            }
            stack.push(a);
            span[i++] = stack.size();
        }
        return span;
    }

    public static void main(String[] args) {
        int[] span = span(new Integer[]{6, 3, 4, 5, 2});
        System.out.println(Arrays.toString(span));
    }
}
