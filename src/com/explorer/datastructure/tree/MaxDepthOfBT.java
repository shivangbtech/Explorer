package com.explorer.datastructure.tree;

/**
 * Maximum Depth of Binary Tree
 * Leet Code: https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
 */
public class MaxDepthOfBT {

    public static void main(String[] args) {
        MaxDepthOfBT sInstance = new MaxDepthOfBT();
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
