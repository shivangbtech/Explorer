package com.explorer.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

import com.explorer.datastructure.tree.model.TreeNode;

public class BTOrders {

  List<Integer> result = new ArrayList<Integer>();

  public static void main(String[] args) {
    // Example Usage
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(7);
    BTOrders btOrders = new BTOrders();
    System.out.println("inorderTraversal = " + btOrders.inorderTraversal(root));
    System.out.println("postorderTraversal = " + btOrders.postorderTraversal(root));
    System.out.println("preorderTraversal = " + btOrders.preorderTraversal(root));
  }

  /**
   * Given the root of a binary tree, return the inorder traversal of its nodes' values.
   * https://leetcode.com/problems/binary-tree-inorder-traversal/
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    if(root == null){
      return result;
    }
    inorderTraversal(root.left);
    result.add(root.val);
    inorderTraversal(root.right);
    return result;
  }

  /**
   * Given the root of a binary tree, return the postorder traversal of its nodes' values.
   * https://leetcode.com/problems/binary-tree-postorder-traversal/
   * @param root
   * @return
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    if(root == null){
      return result;
    }
    postorderTraversal(root.left);
    postorderTraversal(root.right);
    result.add(root.val);
    return result;
  }

  /**
   * Given the root of a binary tree, return the preorder traversal of its nodes' values.
   * https://leetcode.com/problems/binary-tree-preorder-traversal/
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    if(root == null){
      return result;
    }
    result.add(root.val);
    preorderTraversal(root.left);
    preorderTraversal(root.right);
    return result;
  }
}
