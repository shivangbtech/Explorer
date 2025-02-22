package com.explorer.datastructure.linkedkist.basic;

public class LinkedListInsert {

  protected void linkedListInsert() {
    Node node = new Node();
    node.data = 3;
    node.next = null;

    Node node1 = new Node();
    node1.data = 5;
    node1.next = null;

    node.next = node1;

    Node node2 = new Node();
    node2.data = 4;
    node2.next = null;

    node1.next = node2;
    InsertNth(node, 2, 3);
  }

  /**
   * Inserting the Node at Nth position
   *
   * @param head
   * @param data
   * @param position
   * @return
   */
  protected Node InsertNth(Node head, int data, int position) {
    // This is a "method-only" submission.
    // You only need to complete this method.

    if (head == null || position == 0) {
      Node node = new Node();
      node.data = data;
      node.next = null;
      return node;
    } else if (position == 1) {
      Node node = new Node();
      node.data = data;
      node.next = null;
      head.next = node;
      return head;
    } else {
      Node copy = head;
      for (int i = 0; i < position - 1; i++) {
        copy = copy.next;
      }

      Node node = new Node();
      node.data = data;

      node.next = copy.next;
      copy.next = node;

      return head;
    }
  }

  /**
   * Insert Node at last
   * @param node
   * @param data
   * @return It will return the last node i.e. added right away
   */
  protected Node insertLastNode(Node node, int data) {
    if (node == null) {
      Node nodeToInsert = new Node();
      nodeToInsert.data = data;
      nodeToInsert.next = null;
      return nodeToInsert;
    }

    while(node.next != null){
      node = node.next;
    }
    Node nodeToInsert = new Node();
    nodeToInsert.data = data;
    nodeToInsert.next = null;
    node.next = nodeToInsert;
    return nodeToInsert;
  }
}
