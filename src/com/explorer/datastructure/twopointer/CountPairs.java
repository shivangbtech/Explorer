package com.explorer.datastructure.twopointer;

/**
 * Pair with given sum in a sorted array
 *
 * You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
 * Note: pairs should have elements of distinct indexes.
 *
 * Examples :
 *
 * Input: arr[] = [-1, 1, 5, 5, 7], target = 6
 * Output: 3
 * Explanation: There are 3 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.
 * Input: arr[] = [1, 1, 1, 1], target = 2
 * Output: 6
 * Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.
 * Input: arr[] = [-1, 10, 10, 12, 15], target = 125
 * Output: 0
 * Explanation: There is no such pair which sums up to 125.
 * Constraints:
 * -105 <= target <=105
 *  2 <= arr.size() <= 105
 * -105 <= arr[i] <= 105
 *
 * https://www.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
 */
public class CountPairs {
  public static void main(String[] args) {
    CountPairs instance = new CountPairs();
    int result = instance.countPairs(new int[] {-1, 1, 5, 5, 7}, 6);
    System.out.println("Result: " + result);
  }

  /**
   * The code is not working for the test case: Input: arr[] = [1, 1, 1, 1], target = 2
   */
  int countPairs(int arr[], int target) {
    int s = 0;
    int e = arr.length-1;
    int pair = 0;

    while(s < e){
      int sum = arr[s] + arr[e];
      if(sum == target){
        pair++;
        int temp = s;
        while(s < e && arr[s] == arr[s+1]){
          pair++;
          s++;
        }

        while(e > s  && arr[e] == arr[e-1]){
          pair++;
          e--;
        }
        s++;
        e--;
      }else if(sum < target){
        s++;
      }else {
        e--;
      }
    }
    return pair;
  }
}
