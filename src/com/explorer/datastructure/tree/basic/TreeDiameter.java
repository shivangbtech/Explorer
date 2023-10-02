package com.explorer.datastructure.tree.basic;

import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Diameter of Binary Tree
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class TreeDiameter {

  public static void main(String[] args) {
    // Example Usage
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(10);
    TreeDiameter treeDiameter = new TreeDiameter();
    System.out.println("diameterOfBinaryTree = " + treeDiameter.diameterOfBinaryTree(root));
  }

  int maxDiameter = 0;
  private int diameterOfBinaryTree(TreeNode root) {
    if(root == null){
      return 0;
    }
    calculateDiameter(root);
    return maxDiameter;
  }

  private int calculateDiameter(TreeNode root){
    if(root == null){
      return 0;
    }
    int leftDiameter = calculateDiameter(root.left);
    int rightDiameter = calculateDiameter(root.right);
    // Calculate the diameter passing through the current node
    int currentDiameter = leftDiameter + rightDiameter;
    // Update maxDiameter if the current diameter is greater
    maxDiameter = Math.max(maxDiameter, currentDiameter);
    // Return the depth of the current node's subtree
    return Math.max(leftDiameter, rightDiameter) + 1;
  }
}
