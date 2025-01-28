package com.explorer.datastructure.tree;

import java.util.*;

import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Binary Tree Level Order Traversal II - Reverse
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BTLevelOrderTraversalReverse {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList();
        if(root == null){
            return resultList;
        }

        Stack<List<Integer>> stack = new Stack();
        List<Integer> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()){
            TreeNode cNode = queue.poll();
            if(cNode != null){
                list.add(cNode.val);
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
                stack.push(list);
                list = new ArrayList();
            }

        }

        while(!stack.isEmpty()){
            resultList.add(stack.pop());
        }
        return resultList;
    }
}
