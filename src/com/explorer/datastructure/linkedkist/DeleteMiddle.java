package com.explorer.datastructure.linkedkist;

import com.explorer.datastructure.linkedkist.basic.CreateLinkedList;
import com.explorer.datastructure.linkedkist.basic.Node;
import com.explorer.datastructure.linkedkist.basic.PrintLinkedList;

/**
 * Delete the Middle Node of a Linked List
 *
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class DeleteMiddle {
  public static void main(String[] args) {
    DeleteMiddle instance = new DeleteMiddle();
    Node node = instance.deleteMiddle(new CreateLinkedList().createLinkedList());
    new PrintLinkedList().printLinkedList(node);
  }

  public Node deleteMiddle(Node head) {
    Node temp = head;
    Node slow = head;
    Node fast = head;

    if (head.next == null) {
      return null;
    }

    while (fast != null && fast.next != null) {
      temp = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    temp.next = slow.next;
    return head;
  }
}
