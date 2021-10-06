package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaxLevelSum {

    public static int maxLevelSumIterative(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode<Integer>> queue1 = new LinkedList<>();
        Deque<TreeNode<Integer>> queue2 = new LinkedList<>();
        queue1.offer(root);

        int maxLevelSum = 0;
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            Deque<TreeNode<Integer>> readQueue = queue1.isEmpty() ? queue2 : queue1;
            Deque<TreeNode<Integer>> writeQueue = queue1.isEmpty() ? queue1 : queue2;

            int levelSum = 0;
            while(!readQueue.isEmpty()) {
                TreeNode<Integer> node = readQueue.remove();
                levelSum = levelSum + node.getData();
                if(node.getLeft() != null) {
                    writeQueue.offer(node.getLeft());
                }
                if(node.getRight() != null) {
                    writeQueue.offer(node.getRight());
                }
            }
            maxLevelSum = Math.max(maxLevelSum, levelSum);
        }
        return maxLevelSum;
    }

    public static int maxLevelSumRecursive(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        Map<Integer, Integer> sumMap = new HashMap<>();
        calculateLevelSum(root, sumMap, 1);
        return sumMap.entrySet().stream().max((x, y) -> x.getValue() - y.getValue())
                .get().getValue();
    }

    private static void calculateLevelSum(TreeNode<Integer> root, Map<Integer, Integer> sumMap, int level) {
        if(root == null) {
            return;
        }
        int levelSum = sumMap.getOrDefault(level, 0);
        sumMap.put(level, levelSum + root.getData());
        calculateLevelSum(root.getLeft(), sumMap, level + 1);
        calculateLevelSum(root.getRight(), sumMap, level + 1);
    }

    public static void main(String[] args) {
        TreeNode<Integer> l5 = new TreeNode<>(5, null, null);
        TreeNode<Integer> l1 = new TreeNode<>(1, null, null);
        TreeNode<Integer> l7 = new TreeNode<>(7, null, null);
        TreeNode<Integer> l0 = new TreeNode<>(0, null, null);
        TreeNode<Integer> l2 = new TreeNode<>(2, l5, l1);
        TreeNode<Integer> l3 = new TreeNode<>(3, l7, l0);
        TreeNode<Integer> root = new TreeNode<>(4, l2, l3);

        System.out.println(maxLevelSumRecursive(root));
        System.out.println(maxLevelSumIterative(root));
    }
}
