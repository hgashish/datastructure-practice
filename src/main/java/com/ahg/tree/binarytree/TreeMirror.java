package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

public class TreeMirror {

    public static <T> TreeNode<T> mirrorCloneRecursively(TreeNode<T> root) {
        if(root == null) {
            return null;
        }

        TreeNode<T> newNode = new TreeNode<>(root.getData(), null, null);
        newNode.setRight(mirrorCloneRecursively(root.getLeft()));
        newNode.setLeft(mirrorCloneRecursively(root.getRight()));
        return newNode;
    }

    public static <T> void mirrorTree(TreeNode<T> root) {
        if(root == null) {
            return;
        }
        TreeNode<T> temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        mirrorTree(root.getLeft());
        mirrorTree(root.getRight());
    }

    public static void main(String[] args) {
        TreeNode<Integer> l5 = new TreeNode<>(5, null, null);
        TreeNode<Integer> l1 = new TreeNode<>(1, null, null);
        TreeNode<Integer> l7 = new TreeNode<>(7, null, null);
        TreeNode<Integer> l0 = new TreeNode<>(0, null, null);
        TreeNode<Integer> l2 = new TreeNode<>(2, l5, l1);
        TreeNode<Integer> l3 = new TreeNode<>(3, l7, l0);
        TreeNode<Integer> root = new TreeNode<>(4, l2, l3);

        System.out.println(root);
        System.out.println(mirrorCloneRecursively(root));

        mirrorTree(root);
        System.out.println(root);
    }
}
