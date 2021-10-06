package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

import java.util.LinkedList;

public class AllPathFromRootToLeaf {

    public static <T> void printRecursively(TreeNode<T> root, LinkedList<T> pathList) {
        if(root == null && pathList.isEmpty()) {
            System.out.println("Empty tree");
            return;
        }
        if(root == null) {
            return;
        }
        pathList.addLast(root.getData());
        printRecursively(root.getLeft(), pathList);
        printRecursively(root.getRight(), pathList);

        if(root.getLeft() == null && root.getRight() == null) {
            System.out.println(pathList);
        }
        pathList.removeLast();
    }

    public static void main(String[] args) {
        TreeNode<Integer> l5 = new TreeNode<>(5, null, null);
        TreeNode<Integer> l1 = new TreeNode<>(1, null, null);
        TreeNode<Integer> l7 = new TreeNode<>(7, null, null);
        TreeNode<Integer> l0 = new TreeNode<>(0, null, null);
        TreeNode<Integer> l2 = new TreeNode<>(2, l5, l1);
        TreeNode<Integer> l3 = new TreeNode<>(3, l7, l0);
        TreeNode<Integer> root = new TreeNode<>(4, l2, l3);

        printRecursively(root, new LinkedList<>());
    }
}
