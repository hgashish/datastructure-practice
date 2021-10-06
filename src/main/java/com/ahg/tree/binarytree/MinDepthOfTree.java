package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MinDepthOfTree {

    public static <T> int minDepth(TreeNode<T> root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode<T>> queue1 = new LinkedList<>();
        Deque<TreeNode<T>> queue2 = new LinkedList<>();
        queue1.offer(root);

        int count = 1;
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            Deque<TreeNode<T>> readQueue = queue1.isEmpty() ? queue2 : queue1;
            Deque<TreeNode<T>> writeQueue = queue1.isEmpty() ? queue1 : queue2;

            while(!readQueue.isEmpty()) {
                TreeNode<T> node = readQueue.remove();
                if(node.getLeft() == null && node.getRight() == null) {
                    return count;
                }
                if(node.getLeft() != null) {
                    writeQueue.offer(node.getLeft());
                }
                if(node.getRight() != null) {
                    writeQueue.offer(node.getRight());
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode<Integer> l5 = new TreeNode<>(5, null, null);
        TreeNode<Integer> l1 = new TreeNode<>(1, null, null);
        TreeNode<Integer> l7 = new TreeNode<>(7, null, null);
        TreeNode<Integer> l0 = new TreeNode<>(0, null, null);
        TreeNode<Integer> l2 = new TreeNode<>(2, l5, l1);
        TreeNode<Integer> l3 = new TreeNode<>(3, l7, l0);
        TreeNode<Integer> root = new TreeNode<>(4, l2, l3);

        System.out.println(minDepth(root));
    }
}
