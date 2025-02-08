package com.explorer.datastructure.sliddingwindow;

/**
 * Smallest subarray with sum greater than x
 *
 * Given a number x and an array of integers arr, find the smallest subarray with sum greater than the given value. If such a subarray do not exist return 0 in that case.
 *
 * Examples:
 *
 * Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
 * Output: 3
 * Explanation: Minimum length subarray is [4, 45, 6]
 * Input: x = 100, arr[] = [1, 10, 5, 2, 7]
 * Output: 0
 * Explanation: No subarray exist
 * Constraints:
 * 1 ≤ arr.size, x ≤ 105
 * 0 ≤ arr[] ≤ 104
 *
 * https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1
 */
public class SmallestSubWithSum {

  public static void main(String[] args) {
  SmallestSubWithSum instance = new SmallestSubWithSum();
  int result = instance.smallestSubWithSum(new int[] {1, 4, 45, 6, 0, 19}, 51);
//  int result = instance.smallestSubWithSum(new int[] {1, 10, 5, 2, 7}, 100);
  System.out.println("Result : " + result);
  }

  public int smallestSubWithSum(int[] arr, int x) {
    int l = 0;
    int r = 0;
    int sum = 0;
    int length = Integer.MAX_VALUE;

    while(r < arr.length){
      // Expend the window
      sum = sum + arr[r];
      r++;

      // Compress the window
      while(sum > x){
        length = Math.min(length, r-l);
        sum = sum - arr[l];
        l++;
      }
    }

    if(length == Integer.MAX_VALUE){
      return 0;
    }

    return length;
  }
}
