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
public class ZigZagTraversal {

    public static <T> void print(TreeNode<T> root) {
        if(root == null) {
            return;
        }
        Deque<TreeNode<T>> stack1 = new LinkedList<>();
        Deque<TreeNode<T>> stack2 = new LinkedList<>();
        boolean isLeftToRight = false;
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {

            Deque<TreeNode<T>> readStack = stack1.isEmpty() ? stack2 : stack1;
            Deque<TreeNode<T>> writeStack = stack1.isEmpty() ? stack1 : stack2;

            while(!readStack.isEmpty()) {
                TreeNode<T> node = readStack.pop();
                System.out.print(node.getData() + "\t");
                if(isLeftToRight) {
                    if(node.getLeft() != null) {
                        writeStack.push(node.getLeft());
                    }
                    if(node.getRight() != null) {
                        writeStack.push(node.getRight());
                    }
                } else {
                    if(node.getRight() != null) {
                        writeStack.push(node.getRight());
                    }
                    if(node.getLeft() != null) {
                        writeStack.push(node.getLeft());
                    }
                }
            }
            System.out.println();
            isLeftToRight = !isLeftToRight;
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
