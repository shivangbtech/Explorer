package com.explorer.datastructure.tree.basic;

import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Symmetric Tree
 * Leet Code: https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/
 */
public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree sInstance = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        System.out.println("isSymmetric = " + sInstance.isSymmetric(root));
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
