package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

public class DiameterOfTree {

    public static <T> int diameter(TreeNode<T> root) {
        if(root == null) {
            return 0;
        }
        return diameter(root.getLeft()) + diameter(root.getRight()) + 1;
    }
}
