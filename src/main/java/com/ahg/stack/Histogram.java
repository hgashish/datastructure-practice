package com.ahg.stack;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Histogram {

    public static int maxArea1(int... array) {
        if(array == null || array.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Deque<Node> stack = new LinkedList<>();
        int i = 0;
        while(i < array.length) {
            int ai = array[i++];
            while(!stack.isEmpty() && stack.peek().item > ai) {
                Node node = stack.pop();
                int newArea = node.item * (i - node.index);

                maxArea = Math.max(maxArea, newArea);
            }
            stack.push(new Node(i, ai));
        }
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            int newArea = node.item * (i - node.index);
            maxArea = Math.max(maxArea, newArea);
        }

        return maxArea;
    }

    public static int maxArea2(int... heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        while(i < heights.length) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 6, 1, 4, 4};
        int maxArea = maxArea2(array);
        System.out.println(Arrays.toString(array));
        System.out.println("maxArea=" + maxArea);
    }
}

@AllArgsConstructor
class Node {
    int index;
    int item;
}
