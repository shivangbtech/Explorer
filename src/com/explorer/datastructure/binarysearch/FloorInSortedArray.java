package com.explorer.datastructure.binarysearch;

/**
 * Floor in a Sorted Array
 *
 * Given a sorted array arr[] (with unique elements) and an integer k, find the index (0-based) of the largest element in arr[] that is less than or equal to k. This element is called the "floor" of k. If such an element does not exist, return -1.
 *
 * Examples
 *
 * Input: arr[] = [1, 2, 8, 10, 11, 12, 19], k = 0
 * Output: -1
 * Explanation: No element less than 0 is found. So output is -1.
 * Input: arr[] = [1, 2, 8, 10, 11, 12, 19], k = 5
 * Output: 1
 * Explanation: Largest Number less than 5 is 2 , whose index is 1.
 * Input: arr[] = [1, 2, 8], k = 1
 * Output: 0
 * Explanation: Largest Number less than or equal to  1 is 1 , whose index is 0.
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * 1 ≤ arr[i] ≤ 106
 * 0 ≤ k ≤ arr[n-1]
 *
 * https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
 */
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
