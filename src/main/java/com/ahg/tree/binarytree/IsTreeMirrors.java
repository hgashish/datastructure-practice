package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

public class IsTreeMirrors {

    public static <T> boolean isMirror(TreeNode<T> root1, TreeNode<T> root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }

        return isMirror(root1.getLeft(), root2.getLeft()) && isMirror(root1.getRight(), root2.getRight());
    }

    public static void main(String[] args) {
        TreeNode<Integer> l5 = new TreeNode<>(5, null, null);
        TreeNode<Integer> l1 = new TreeNode<>(1, null, null);
        TreeNode<Integer> l7 = new TreeNode<>(7, null, null);
        TreeNode<Integer> l0 = new TreeNode<>(0, null, null);
        TreeNode<Integer> l2 = new TreeNode<>(2, l5, l1);
        TreeNode<Integer> l3 = new TreeNode<>(3, l7, l0);
        TreeNode<Integer> root = new TreeNode<>(4, l2, l3);

        TreeNode<Integer> mirrorRoot = TreeMirror.mirrorCloneRecursively(root);
        System.out.println(isMirror(root, mirrorRoot));
    }
}
