package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

public class HeightOfTree {

    public static <T> int height(TreeNode<T> root) {
        if(root == null)
            return 0;

        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }

    public static void main(String[] args) {
        TreeNode<Integer> l5 = new TreeNode<>(5, null, null);
        TreeNode<Integer> l1 = new TreeNode<>(1, null, null);
        TreeNode<Integer> l7 = new TreeNode<>(7, null, null);
        TreeNode<Integer> l0 = new TreeNode<>(0, null, null);
        TreeNode<Integer> l2 = new TreeNode<>(2, l5, l1);
        TreeNode<Integer> l3 = new TreeNode<>(3, l7, l0);
        TreeNode<Integer> root = new TreeNode<>(4, l2, l3);

        System.out.println(height(root));
    }
}
