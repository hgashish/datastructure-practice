package com.ahg.tree.binarytree.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TreeNode<T> {

    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;
}
