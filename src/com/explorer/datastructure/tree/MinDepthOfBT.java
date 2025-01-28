package com.explorer.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Minimum Depth of Binary Tree
 * Leet Code: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */
public class MinDepthOfBT {
    public static void main(String[] args) {
        // Example Usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(10);
        MinDepthOfBT minDepthOfBT = new MinDepthOfBT();
        System.out.println("MinDepthOfBT = " + minDepthOfBT.minDepthUsingDFS(root));
        System.out.println("MinDepthOfBT = " + minDepthOfBT.minDepthUsingBFS(root));
    }

    public int minDepthUsingDFS(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null){
            return 1+ minDepthUsingDFS(root.right);
        }
        if(root.right == null){
            return 1 + minDepthUsingDFS(root.left);
        }
        return Math.min(minDepthUsingDFS(root.right), minDepthUsingDFS(root.left)) + 1;
    }

    public int minDepthUsingBFS(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()){
            TreeNode cNode = queue.poll();
            if(cNode != null){
                if(cNode.left == null && cNode.right == null){
                    return depth;
                }
                if(cNode.left != null){
                    queue.offer(cNode.left);
                }
                if(cNode.right != null){
                    queue.offer(cNode.right);
                }
            }else {
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
                depth++;
            }
        }
        return depth;
    }
}
