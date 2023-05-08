package com.explorer.datastructure.tree;

/**
 * Merge Two Binary Trees
 * Leet Code: https://leetcode.com/problems/merge-two-binary-trees/description/?envType=study-plan&id=algorithm-i
 */
public class MergeTwoBT {
    public static void main(String[] args) {
        MergeTwoBT sInstance = new MergeTwoBT();
//        int [] root1 = {1,3,2,5};
//        int [] root2 = {2,1,3,null,4,null,7};
//        sInstance.mergeTrees();
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
