package com.explorer.datastructure.tree.basic;

import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Height or Depth
 *
 * The height of a Binary Tree is defined as the maximum depth of any leaf node from the root node.
 */
public class MaxHeight {

  public static void main(String[] args) {
    // Example Usage
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(9);
    MaxHeight maxHeight = new MaxHeight();
    System.out.println("treeHeight = " + maxHeight.treeHeight(root));
  }

  /**
   * Maximum Depth of Binary Tree
   *
   * Given the root of a binary tree, return its maximum depth.
   *
   * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
   *
   * https://leetcode.com/problems/maximum-depth-of-binary-tree/
   * @param root
   * @return
   */
  private int treeHeight(TreeNode root){
    if(root == null){
      return 0;
    }
    int leftHeight = treeHeight(root.left);
    int rightHeight = treeHeight(root.right);
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
