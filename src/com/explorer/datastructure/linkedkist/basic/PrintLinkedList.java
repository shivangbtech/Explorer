package com.explorer.datastructure.linkedkist.basic;

public class PrintLinkedList {

  public static void main(String[] args) {
    PrintLinkedList instance = new PrintLinkedList();
    instance.printLinkedList(new CreateLinkedList().createLinkedList());
  }

  public void printLinkedList(Node node){
    while(node != null){
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

}
