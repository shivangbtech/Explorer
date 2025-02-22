package com.explorer.datastructure.linkedkist;

import com.explorer.datastructure.linkedkist.basic.CreateLinkedList;
import com.explorer.datastructure.linkedkist.basic.Node;

/**
 * Middle of the Linked List
 *
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * https://www.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
 *
 */
public class MiddleNode {

  public static void main(String[] args) {
    MiddleNode instance = new MiddleNode();
    Node node = instance.middleNode(new CreateLinkedList().createLinkedList());
    System.out.println("Result: " + node.data);
  }

  public Node middleNode(Node head) {
    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next!=null){
      slow = slow.next;
      fast =fast.next.next;
    }
    return slow;
  }
}
