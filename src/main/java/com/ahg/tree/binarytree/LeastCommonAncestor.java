package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

public class LeastCommonAncestor {

    public static <T> T lca(TreeNode<T> root, T a, T b) {
        if(root == null) {
            return null;
        }
        if(root.getData().equals(a) || root.getData().equals(b)) {
            return root.getData();
        }
        T leftLca = lca(root.getLeft(), a, b);
        T rightLca = lca(root.getRight(), a, b);
        if(leftLca != null && rightLca != null) {
            return root.getData();
        }
        return leftLca != null ? leftLca : rightLca;
    }

    private static <T> boolean find(TreeNode<T> root, T a) {
        if(root == null) {
            return false;
        }
        return root.getData().equals(a) || find(root.getLeft(), a) || find(root.getRight(), a);
    }

    public static <T> T findLca(TreeNode<T> root, T a, T b) {
        if(root == null) {
            return null;
        }
        if(!find(root, a) || !find(root, b)) {
            return null;
        }
        return lca(root, a, b);
    }

    public static void main(String[] args) {
        TreeNode<Integer> l5 = new TreeNode<>(5, null, null);
        TreeNode<Integer> l1 = new TreeNode<>(1, null, null);
        TreeNode<Integer> l7 = new TreeNode<>(7, null, null);
        TreeNode<Integer> l0 = new TreeNode<>(0, null, null);
        TreeNode<Integer> l2 = new TreeNode<>(2, l5, l1);
        TreeNode<Integer> l3 = new TreeNode<>(3, l7, l0);
        TreeNode<Integer> root = new TreeNode<>(4, l2, l3);

        System.out.println(findLca(root, 5, 7));
        System.out.println(findLca(root, 5, 1));
        System.out.println(findLca(root, 7, 2));
        System.out.println(findLca(root, 4, 0));
        System.out.println(findLca(root, 5, 9));
        System.out.println(findLca(root, 4, 4));
    }
}
