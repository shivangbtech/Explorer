package com.explorer.datastructure.binarysearch;

public class FloorInSortedArray {

  public static void main(String[] args) {
    FloorInSortedArray instance = new FloorInSortedArray();
    int result = instance.findFloor(new int[] {1, 2, 8, 10, 11, 12, 19}, 5);
    System.out.println("Result: " + result);
  }

  int findFloor(int[] arr, int k) {
    if(arr[0] > k){
      return -1;
    }
    int start = 0;
    int end = arr.length-1;
    int result = -1;

    while(start <= end){
      int mid = start + (end - start)/2;
      if(arr[mid] == k){
        result = mid;
        return mid;
      }else if(arr[mid] < k){
        result = mid;
        start = mid + 1;
      }else if(arr[mid] > k){
        end = mid -1;
      }
    }
    return result;
  }
}
