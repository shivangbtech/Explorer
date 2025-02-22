package com.explorer.datastructure.linkedkist.basic;

public class CreateLinkedList {

  /**
   * Method to create a linked list
   * @return Head Node
   */
  public Node createLinkedList(){
    int[] numArray = {1,3,4,5,6,7,0};
    return createLinkedList(numArray);
  }

  /**
   * Method to create a linked list
   * @param numArray
   * @return Head Node
   */
  protected Node createLinkedList(int [] numArray){
    LinkedListInsert insertNodes = new LinkedListInsert();
    Node head = insertNodes.insertLastNode(null, numArray[0]);
    Node temp = head;
    for(int i = 1; i< numArray.length; i++){
      temp = insertNodes.insertLastNode(temp, numArray[i]);
    }
    return head;
  }

  /**
   * Method to create a loop in the linked list}
   * @param head
   * @param loopPosition
   */
  protected void createLoopInList(Node head, int loopPosition) throws Exception {
    if(head == null) return;
    Node nodeAtLoopPosition = null;
    for(int i = 0; i< loopPosition; i++){
      head = head.next;
      if(head == null) throw new Exception("Please enter a valid position!");
    }
    nodeAtLoopPosition = head;
    while(head.next != null){
      head = head.next;
    }
    head.next = nodeAtLoopPosition;
  }

  public static void main(String[] args) {
    CreateLinkedList createLinkedList = new CreateLinkedList();
    createLinkedList.createLinkedList();
  }
}
