package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Give an algorithm for printing the level order data in reverse order.
 * For example, the output for the below tree should be: 4 5 6 7 2 3 1
 *
 *                  6
 *
 *            3
 *                  7
 *    1
 *                  4
 *            2
 *                  5
 *
 * 1 is the root, 2 is left child and 3 is right child. (tree rotated by 90)
 */
public class TreePrintReverseLevelWise {

    public static <T> void print(TreeNode<T> root) {
        if(root == null) {
            return;
        }
        Deque<TreeNode<T>> queue1 = new LinkedList<>();
        Deque<TreeNode<T>> queue2 = new LinkedList<>();
        queue1.offer(root);
        Deque<List<T>> output = new LinkedList<>();
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            List<T> tempLevel = new ArrayList<>();
            output.push(tempLevel);

            Deque<TreeNode<T>> readQueue = queue1.isEmpty() ? queue2 : queue1;
            Deque<TreeNode<T>> writeQueue = queue1.isEmpty() ? queue1 : queue2;

            while(!readQueue.isEmpty()) {
                TreeNode<T> node = readQueue.remove();
                tempLevel.add(node.getData());
                if(node.getLeft() != null) {
                    writeQueue.offer(node.getLeft());
                }
                if(node.getRight() != null) {
                    writeQueue.offer(node.getRight());
                }
            }
        }
        while(!output.isEmpty()) {
            System.out.println(output.pop());
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> l5 = new TreeNode<>(5, null, null);
        TreeNode<Integer> l1 = new TreeNode<>(1, null, null);
        TreeNode<Integer> l7 = new TreeNode<>(7, null, null);
        TreeNode<Integer> l0 = new TreeNode<>(0, null, null);
        TreeNode<Integer> l2 = new TreeNode<>(2, l5, l1);
        TreeNode<Integer> l3 = new TreeNode<>(3, l7, l0);
        TreeNode<Integer> root = new TreeNode<>(4, l2, l3);

        print(root);
    }
}
