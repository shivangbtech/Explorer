package com.explorer.datastructure.tree;

import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Convert Sorted Array to Binary Search Tree
 * Leet Code: https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        SortedArrayToBST sInstance = new SortedArrayToBST();
        int [] nums = {-10,-3,0,5,9};
        sInstance.sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return constructBST(nums, 0, nums.length-1);
    }

    private TreeNode constructBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums, left, mid-1);
        root.right = constructBST(nums, mid+1, right);
        return root;
    }
}
