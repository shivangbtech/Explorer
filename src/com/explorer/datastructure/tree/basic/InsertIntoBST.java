package com.explorer.datastructure.tree.basic;

import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Insert into a Binary Search Tree
 *
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 *
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 */
public class InsertIntoBST {

  public static void main(String[] args) {
    // Example Usage
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(9);
    InsertIntoBST insertIntoBST = new InsertIntoBST();
    System.out.println("insertIntoBST = " + insertIntoBST.insertIntoBST(root, 6).val);
  }

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if(root == null){
      return new TreeNode(val);
    }

    if(root.val > val ){
      root.left = insertIntoBST(root.left, val);
    }

    if(root.val < val ){
      root.right = insertIntoBST(root.right, val);
    }
    return root;
  }
}
