package com.explorer.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populating Next Right Pointers in Each Node
 * Leet Code: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/?envType=study-plan&id=algorithm-i
 */
public class NextRightPointer {

    public static void main(String[] args) {

    }

    // BFS
    public Node connectOptimized(Node root) {
        if(root == null){
            return null;
        }

        Node cNode = root;
        Node nxtNode = null;
        if(cNode.left != null){
            nxtNode = cNode.left;
        }

        while(cNode != null && nxtNode != null){
            cNode.left.next = cNode.right;
            if(cNode.next != null){
                cNode.right.next = cNode.next.left;
            }
            cNode = cNode.next;
            if(cNode == null){
                cNode = nxtNode;
                nxtNode = cNode.left;
            }
        }
        return root;
    }

    /**
     * Unoptimized Solution
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Node tempNode = null;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()){
            Node cNode = queue.poll();
            if(cNode != null){
                if(tempNode == null){
                    tempNode = cNode;
                }else {
                    tempNode.next = cNode;
                    tempNode = cNode;
                }
                if(cNode.left != null){
                    queue.offer(cNode.left);
                }
                if(cNode.right != null){
                    queue.offer(cNode.right);
                }
            }else {
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
                tempNode = null;
            }
        }
        return root;
    }
}
