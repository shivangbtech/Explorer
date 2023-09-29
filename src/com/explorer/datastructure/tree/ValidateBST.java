package com.explorer.datastructure.tree;

import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Validate Binary Search Tree
 * Leet Code: https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/
 */
public class ValidateBST {

    public static void main(String[] args) {
        ValidateBST sInstance = new ValidateBST();

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
