package com.explorer.datastructure.linkedkist;

import com.explorer.datastructure.linkedkist.basic.CreateLinkedList;
import com.explorer.datastructure.linkedkist.basic.Node;
import com.explorer.datastructure.linkedkist.basic.PrintLinkedList;

/**
 * Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class ReverseList {

  public static void main(String[] args) {
    ReverseList instance = new ReverseList();
    Node node = instance.reverseList(new CreateLinkedList().createLinkedList());
    new PrintLinkedList().printLinkedList(node);
    //    while(node != null){
    //      System.out.print(node.data + " ");
    //      node = node.next;
    //    }
  }

  public Node reverseList(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node N1 = head;
    Node N2 = N1.next;
    Node N3 = N2.next;

    N1.next = null;
    N2.next = N1;

    while (N3 != null) {
      N1 = N2;
      N2 = N3;
      N3 = N3.next;
      N2.next = N1;
    }
    return N2;
  }
}
