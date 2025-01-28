package com.explorer.datastructure.tree.basic;

import java.util.LinkedList;
import java.util.Queue;

import com.explorer.datastructure.tree.model.TreeNode;

public class SumOfNodes {

  public static void main(String[] args) {
    // Example Usage
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(8);
    SumOfNodes sumOfNodes = new SumOfNodes();
    System.out.println("sumOfNodes = " + sumOfNodes.sumOfNodes(root));
    System.out.println("maxLevelSum = " + sumOfNodes.maxLevelSum(root));
  }

  private int sumOfNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftSum = sumOfNodes(root.left);
    int rightSum = sumOfNodes(root.right);
    return leftSum + rightSum + root.val;
  }

  /**
   * Maximum Level Sum of a Binary Tree
   *
   * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
   * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
   *
   * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
   *
   * Solved by level order or BFS
   *
   * @param root
   * @return
   */
  private int maxLevelSum(TreeNode root) {
    if(root == null){
      return 1;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    queue.add(null);

    int maxSum = Integer.MIN_VALUE;
    int lSum = 0;
    int maxLevel = 1;
    int curLevel = 1;

    while(!queue.isEmpty()){
      TreeNode curNode = queue.remove();
      if(curNode == null){
        if(lSum > maxSum){
          maxSum = lSum;
          maxLevel = curLevel;
        }
        lSum = 0;
        curLevel++;
        if(queue.isEmpty()){
          break;
        }else{
          queue.add(null);
        }
      }else {
        lSum = lSum + curNode.val;
        if(curNode.left != null){
          queue.add(curNode.left);
        }
        if(curNode.right != null){
          queue.add(curNode.right);
        }
      }
    }
    return maxLevel;
  }

  /**
   * Sum Root to Leaf Numbers
   * You are given the root of a binary tree containing digits from 0 to 9 only.
   *
   * Each root-to-leaf path in the tree represents a number.
   *
   * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
   * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
   *
   * A leaf node is a node with no children.
   *
   * https://leetcode.com/problems/sum-root-to-leaf-numbers/
   *
   * Solved by DFS
   * @param root
   * @return
   */
  private int sumNumbers(TreeNode root) {
    if(root == null){
      return 0;
    }
    return sumNumbers(root, 0);
  }

  private int sumNumbers(TreeNode root, int sum) {
    if(root == null){
      return 0;
    }
    sum = (sum * 10) + root.val;
    if(root.left == null && root.right == null){
      return sum;
    }
    int leftSum = sumNumbers(root.left, sum);
    int rightSum = sumNumbers(root.right, sum);
    return leftSum + rightSum;
  }
}
