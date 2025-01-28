package com.explorer.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

import com.explorer.datastructure.tree.model.TreeNode;

/**
 * Binary Tree Paths
 * Leet Code: https://leetcode.com/problems/binary-tree-paths/description/
 */
public class BTPaths {
    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        dfs(root, "", resultList);
        return resultList;
    }

    private void dfs(TreeNode node, String path, List<String> list) {
        if (node.left == null && node.right == null) {
            list.add(path + node.val);
        }
        if (node.left != null) {
            dfs(node.left, path + node.val + "->", list);
        }
        if (node.right != null) {
            dfs(node.right, path + node.val + "->", list);
        }
    }

    /*
    Question:
    My solution was same like yours,
    but I was using StringBuilder instead of simple string,
    but why it was failing when using StringBuilder?

    Answer:
    That's a good question! In general,
    a StringBuilder is more efficient than concatenating strings using the + operator,
    because StringBuilder allows you to append characters or strings to the existing string buffer without creating a new string object.
    However, in this particular case, using a StringBuilder may cause issues because it is mutable and the depth-first search algorithm is recursive.

    When the dfs method is called recursively, the same StringBuilder object is passed down to each subsequent call.
    This means that when the recursion unwinds and the method returns to a previous level of the tree,
    the StringBuilder will still contain the values that were appended by the subsequent calls.
    This can cause incorrect paths to be added to the list of paths.

    In contrast, using a regular string as the path parameter ensures that each recursive call has its own copy of the path,
    which prevents the issue of appending incorrect values.
    Therefore, using a regular string is a safer choice for this problem.
     */
}
