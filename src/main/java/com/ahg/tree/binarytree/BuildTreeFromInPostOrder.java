package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

public class BuildTreeFromInPostOrder {

    public static TreeNode<Character> build(char[] inorder, char[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return buildTreeRecursively(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private static TreeNode<Character> buildTreeRecursively(char[] inorder, int iStart, int iEnd,
                                                            char[] postorder, int pStart, int pEnd) {
        if(iStart > iEnd || pStart > pEnd) {
            return null;
        }

        char rootData = postorder[pEnd];
        int inOrderRootIndex = indexOf(inorder, rootData);
        TreeNode<Character> newNode = new TreeNode<>(rootData, null, null);
        newNode.setLeft(buildTreeRecursively(inorder, iStart, inOrderRootIndex - 1,
                postorder, pStart, pStart + inOrderRootIndex - iStart - 1));

        newNode.setRight(buildTreeRecursively(inorder, inOrderRootIndex + 1, iEnd,
                postorder, pStart + inOrderRootIndex - iStart, pEnd - 1));
        return newNode;
    }

    private static int indexOf(char[] array, char val) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(build("DBEAFC".toCharArray(), "DEBFCA".toCharArray()));
    }
}
