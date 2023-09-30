package com.explorer.datastructure.tree.basic;

import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * <p>
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Design an algorithm that runs in less than O(n) time complexity.
 * <p>
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 */

public class CountOfNodes {

  public static void main(String[] args) {
    // Example Usage
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    CountOfNodes countOfNodes = new CountOfNodes();
    System.out.println("countNodes = " + countOfNodes.countNodes(root));
    System.out.println("countNodesOptimized = " + countOfNodes.countNodesOptimized(root));
  }

  int count = 0;

  /**
   * To find number of nodes
   * Complexity = O(n)
   * @param root
   * @return
   */
  public int countNodes(TreeNode root) {
    if (root == null) {
      return count;
    }
    int leftCount = countNodes(root.left);
    int rightCount = countNodes(root.right);
    return leftCount + rightCount + 1;
  }

  /**
   * To find number of nodes
   * Complexity = O(log^2(n))
   * @param root
   * @return
   */
  public int countNodesOptimized(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftDepth = getLeftDepth(root);
    int rightDepth = getRightDepth(root);

    if (leftDepth == rightDepth) {
      return (1 << leftDepth) - 1; // Formula for nodes in a complete binary tree
    } else {
      return 1 + countNodes(root.left) + countNodes(root.right);
    }
  }

  private int getLeftDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      depth++;
      node = node.left;
    }
    return depth;
  }

  private int getRightDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      depth++;
      node = node.right;
    }
    return depth;
  }
}
