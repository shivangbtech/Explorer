package com.explorer.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Find Largest Value in Each Tree Row
 * Leet Code: https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 */
public class LargestValueInRow {

    public static void main(String[] args) {
        LargestValueInRow sInstance = new LargestValueInRow();
    }

    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }

        int max = Integer.MIN_VALUE;
        List<Integer> resultList = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            TreeNode cNode = queue.remove();
            if(cNode != null){
                max = Math.max(max, cNode.val);
                if(cNode.left != null){
                    queue.add(cNode.left);
                }
                if(cNode.right != null){
                    queue.add(cNode.right);
                }
            }else{
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                resultList.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return resultList;
    }
}
