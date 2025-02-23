package com.explorer.datastructure.linkedkist;

import com.explorer.datastructure.linkedkist.basic.CreateLinkedList;
import com.explorer.datastructure.linkedkist.basic.Node;

public class KthElementFromLast {

  public static void main(String[] args) {
    KthElementFromLast instance = new KthElementFromLast();
    int result = instance.getKthFromLast(new CreateLinkedList().createLinkedList(), 2);
    System.out.println("Result: " + result);
  }

  // Function to find the data of kth node from
  // the end of a linked list.
  int getKthFromLast(Node head, int k) {
    Node slow = head;
    Node fast = head;

    int result = -1;
    int i = 0;
    while(i<k && fast != null){
      fast = fast.next;
      i++;
    }

    if(i<k){
      return -1;
    }

    while(fast!= null){
      slow = slow.next;
      fast = fast.next;
    }
    return slow.data;
  }
}
