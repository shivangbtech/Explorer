package com.explorer.datastructure.tree.basic;

import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Subtree of Another Tree
 *
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 *
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 */
public class IsSubtree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(8);
    IsSubtree isSubtree = new IsSubtree();
    System.out.println("isSubtree = " + isSubtree.isSubtree(root, root));
  }
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if(subRoot == null){
      return true;
    }
    if(root == null){
      return false;
    }

    if(root.val == subRoot.val){
      if(isIdentical(root, subRoot)){
        return true;
      }
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public boolean isIdentical(TreeNode root, TreeNode subRoot){
    if(root == null && subRoot == null){
      return true;
    }
    if(root == null || subRoot == null){
      return false;
    }
    if(root.val == subRoot.val){
      return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }
    return false;
  }
}
