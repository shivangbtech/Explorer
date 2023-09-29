package com.explorer.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.explorer.datastructure.tree.model.Node;
import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Binary Tree Level Order Traversal
 * Leet Code: https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/
 */
public class BTLevelOrderTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        List<Integer> list = new ArrayList();

        while(!queue.isEmpty()){
            TreeNode currentNode = queue.remove();

            if(currentNode != null){
                list.add(currentNode.val);
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }else {
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                resultList.add(list);
                list = new ArrayList();
            }

        }
        return resultList;
    }

    private void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node currNode = queue.remove();
            if (currNode == null) {
                System.out.println();
                if (queue.isEmpty()) {
                    break;
                }else {
                    queue.add(null);
                }
            } else {
                System.out.print(currNode.val + "");
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
    }
}
