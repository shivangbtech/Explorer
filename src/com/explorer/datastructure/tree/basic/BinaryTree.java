package com.explorer.datastructure.tree.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.explorer.datastructure.tree.model.TreeNode;


public class BinaryTree {

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree sInstance = new BinaryTree();
//        sInstance.buildTreeUsingRec(nodes);
        TreeNode node = sInstance.buildTreeUsingStack(nodes);
        sInstance.levelOrderPrint(node);
    }

    /**
     * Create Tree - From Pre-Order Sequence
     * Time Complexity = O(n)
     */
    static int idx = -1;

    protected TreeNode buildTreeUsingRec(int[] preorder) {
        idx++;
        if (preorder[idx] == -1) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[idx]);
        newNode.left = buildTreeUsingRec(preorder);
        newNode.right = buildTreeUsingRec(preorder);
        return newNode;
    }

    protected TreeNode buildTreeUsingStack(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            if(preorder[i] == -1){
                continue;
            }
            TreeNode treeNode = new TreeNode(preorder[i]);
            if (treeNode.val < stack.peek().val) {
                stack.peek().left = treeNode;
            } else {
                TreeNode parent = null;
                while (!stack.isEmpty() && treeNode.val > stack.peek().val) {
                    parent = stack.pop();
                }
                if (parent != null)
                    parent.right = treeNode;
            }
            stack.push(treeNode);
        }
        return root;
    }

    /**
     * Print Level Order - BFS
     *
     * @param root Time Complexity = O(n)
     */
    protected void levelOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.remove();
            if (currNode == null) {
                System.out.println();
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                System.out.print(currNode.val + " ");
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
