package com.explorer.datastructure.twopointer;

/**
 * Move All Zeroes to End
 *
 * You are given an array arr[] of non-negative integers. Your task is to move all the zeros in the array to the right end while maintaining the relative order of the non-zero elements. The operation must be performed in place, meaning you should not use extra space for another array.
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
 * Output: [1, 2, 4, 3, 5, 0, 0, 0]
 * Explanation: There are three 0s that are moved to the end.
 * Input: arr[] = [10, 20, 30]
 * Output: [10, 20, 30]
 * Explanation: No change in array as there are no 0s.
 * Input: arr[] = [0, 0]
 * Output: [0, 0]
 * Explanation: No change in array as there are all 0s.
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 0 ≤ arr[i] ≤ 105
 *
 * https://www.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1
 */

public class MoveZeroesToEnd {

  public static void main(String[] args) {
    MoveZeroesToEnd instance = new MoveZeroesToEnd();
    int [] arr = new int[] {1, 2, 0, 4, 3, 0, 5, 0};
    instance.pushZerosToEnd(arr);
    System.out.print("{");
    for(int i = 0; i< arr.length; i++){
      System.out.print(arr[i]);
    }
    System.out.print("}");
  }

  void pushZerosToEnd(int[] arr) {
    int i = 0;
    int p = 0;
    while (i < arr.length && p < arr.length) {
      if (arr[i] == 0) {
        while (p < arr.length - 1 && arr[p] == 0) {
          p++;
        }
        swap(arr, i, p);
      }
      i++;
      p++;
    }
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }
}
