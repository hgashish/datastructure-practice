package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPossibleBTrees {

    public static List<TreeNode<Integer>> generate(int n) {
        if(n == 0) {
            return Collections.emptyList();
        }

        List<TreeNode<Integer>> btreeRoots = new ArrayList<>();


        return btreeRoots;
    }

    private static void generateRecursively(int n, List<TreeNode<Integer>> roots) {
        
    }
}
