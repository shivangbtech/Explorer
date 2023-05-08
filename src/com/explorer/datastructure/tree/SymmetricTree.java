package com.explorer.datastructure.tree;

/**
 * Symmetric Tree
 * Leet Code: https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/
 */
public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree sInstance = new SymmetricTree();

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }

        return isSymmetricHelper(left.right, right.left) && isSymmetricHelper(left.left, right.right);
    }
}
