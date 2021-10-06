package com.ahg.tree.binarytree;

import com.ahg.tree.binarytree.common.TreeNode;

import java.util.Arrays;

public class BuildTreeFromInPreOrder {

    public static TreeNode<Character> build(char[] inorder, char[] preorder) {
        if(inorder == null || preorder == null || inorder.length != preorder.length) {
            return null;
        }
        return buildTreeRecursively(inorder, 0, inorder.length - 1,
                preorder, 0, preorder.length - 1);
    }

    private static TreeNode<Character> buildTreeRecursively(char[] inorder, int iStart, int iEnd,
                                                            char[] preorder, int pStart, int pEnd) {
        if(iStart > iEnd || pStart > pEnd) {
            return null;
        }

        char rootData = preorder[pStart];
        int inOrderRootIndex = indexOf(inorder, rootData);
        TreeNode<Character> newNode = new TreeNode<>(rootData, null, null);
        newNode.setLeft(buildTreeRecursively(inorder, iStart, inOrderRootIndex - 1,
                preorder, pStart + 1, pStart + inOrderRootIndex - iStart));

        newNode.setRight(buildTreeRecursively(inorder, inOrderRootIndex + 1, iEnd,
                preorder, pStart + inOrderRootIndex - iStart + 1, pEnd));
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
        System.out.println(build("DBEAFC".toCharArray(), "ABDECF".toCharArray()));
    }
}
