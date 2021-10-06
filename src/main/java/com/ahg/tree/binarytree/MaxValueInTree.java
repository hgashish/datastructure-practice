package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxValueInTree {

    public static <T extends Comparable> T maxItemRecursive(TreeNode<T> root) {
        if(root == null) {
            return null;
        }
        T maxLeftItem = maxItemRecursive(root.getLeft());
        T maxRightItem = maxItemRecursive(root.getRight());
        return getMaxOf(root.getData(), maxLeftItem, maxRightItem);
    }

    private static <T extends Comparable> T getMaxOf(T ...arr) {
        if(arr == null) {
            return null;
        }

        T max = null;
        for(T a: arr) {
            if(max == null || (a != null && max.compareTo(a) < 0)) {
                max = a;
            }
        }
        return max;
    }

    public static <T extends Comparable> T maxItemIterative(TreeNode<T> root) {
        if(root == null) {
            return null;
        }
        Deque<TreeNode<T>> queue = new LinkedList<>();
        queue.offerLast(root);

        T maxItem = null;

        while(!queue.isEmpty()) {
            TreeNode<T> node = queue.removeFirst();
            if(maxItem == null || node.getData().compareTo(maxItem) > 0) {
                maxItem = node.getData();
            }
            if(node.getLeft() != null) {
                queue.offerLast(node.getLeft());
            }
            if(node.getRight() != null) {
                queue.offerLast(node.getRight());
            }
        }

        return maxItem;
    }

    public static void main(String[] args) {
        TreeNode<Integer> l5 = new TreeNode<>(5, null, null);
        TreeNode<Integer> l1 = new TreeNode<>(1, null, null);
        TreeNode<Integer> l7 = new TreeNode<>(7, null, null);
        TreeNode<Integer> l0 = new TreeNode<>(0, null, null);
        TreeNode<Integer> l2 = new TreeNode<>(2, l5, l1);
        TreeNode<Integer> l3 = new TreeNode<>(3, l7, l0);
        TreeNode<Integer> root = new TreeNode<>(4, l2, l3);
        System.out.println("maxItem=" + maxItemRecursive(root));
        System.out.println("maxItem=" + maxItemIterative(root));
    }
}
