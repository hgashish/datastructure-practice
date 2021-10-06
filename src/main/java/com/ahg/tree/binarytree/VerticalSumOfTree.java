package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class VerticalSumOfTree {
    public static void print(TreeNode<Integer> root) {
        if(root == null) {
            System.out.println("Empty tree");
            return;
        }
        Map<Integer, Integer> sumMap = new HashMap<>();
        getVerticalSum(root, 0, sumMap);
        System.out.println(sumMap);
    }

    private static void getVerticalSum(TreeNode<Integer> root, int column, Map<Integer, Integer> sumMap) {
        if(root == null) {
            return;
        }
        sumMap.put(column, root.getData() + sumMap.getOrDefault(column, 0));
        getVerticalSum(root.getLeft(), column - 1, sumMap);
        getVerticalSum(root.getRight(), column + 1, sumMap);
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
