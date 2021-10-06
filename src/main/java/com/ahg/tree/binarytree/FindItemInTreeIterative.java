package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class FindItemInTreeIterative {

    public static <T extends Comparable> boolean searchIterative(TreeNode<T> root, T value) {
        if(root == null || value == null) {
             return false;
        }
        Deque<TreeNode<T>> queue = new LinkedList<>();
        queue.offerLast(root);

        while(!queue.isEmpty()) {
            TreeNode<T> node = queue.removeFirst();
            if(node.getData().compareTo(value) == 0) {
                return true;
            }
            if(node.getLeft() != null) {
                queue.offerLast(node.getLeft());
            }
            if(node.getRight() != null) {
                queue.offerLast(node.getRight());
            }
        }

        return false;
    }

    public static <T extends Comparable> boolean searchRecursive(TreeNode<T> root, T value) {
        if(root == null || value == null) {
            return false;
        }
        return root.getData().equals(value) || searchRecursive(root.getLeft(), value)
                || searchRecursive(root.getRight(), value);
    }

    public static void main(String[] args) {
        TreeNode<Integer> l5 = new TreeNode<>(5, null, null);
        TreeNode<Integer> l1 = new TreeNode<>(1, null, null);
        TreeNode<Integer> l7 = new TreeNode<>(7, null, null);
        TreeNode<Integer> l0 = new TreeNode<>(0, null, null);
        TreeNode<Integer> l2 = new TreeNode<>(2, l5, l1);
        TreeNode<Integer> l3 = new TreeNode<>(3, l7, l0);
        TreeNode<Integer> root = new TreeNode<>(4, l2, l3);

        System.out.println("exists=" + searchIterative(root, 3));
        System.out.println("exists=" + searchIterative(root, 11));

        System.out.println("exists=" + searchRecursive(root, 3));
        System.out.println("exists=" + searchRecursive(root, 11));
    }
}
