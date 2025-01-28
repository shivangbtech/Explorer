package com.explorer.datastructure.tree.basic;

import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Validate Binary Search Tree
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Leet Code: https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/
 */
public class ValidateBST {

    public static void main(String[] args) {
        ValidateBST sInstance = new ValidateBST();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        System.out.println("isValidBST = " + sInstance.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long lBound, long rBound){
        if(root == null){
            return true;
        }
        if(root.val <= lBound || root.val >= rBound ){
            return false;
        }
        boolean isLeftValid = isValid(root.left, lBound, root.val);
        boolean isRightValid = isValid(root.right, root.val, rBound);
        return (isLeftValid && isRightValid);
    }
}
