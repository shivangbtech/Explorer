package com.explorer.datastructure.sliddingwindow;

/**
 * 1004. Max Consecutive Ones III
 *
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 *
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaxConsecutiveOnes {

  public static void main(String[] args) {
    MaxConsecutiveOnes instance = new MaxConsecutiveOnes();
    int result = instance.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
    System.out.println("Result:" + result);

    int result1 = instance.longestOnes1(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
    System.out.println("Result1:" + result1);
  }

  // Approach-1
  public int longestOnes(int[] nums, int k) {
    int l = 0;
    int r = 0;
    int fCount = 0;
    int maxLength = 0;

    if (k == nums.length) {
      return k;
    }

    while (r < nums.length) {
      if (nums[r] == 0) {
        fCount++;
      }

      if (fCount > k) {
        maxLength = Math.max(r-l, maxLength);
        while (fCount > k) {
          if (nums[l] == 0) {
            fCount--;
          }
          l++;
        }
      }
      r++;
    }

    return Math.max(r-l, maxLength);
  }

  // Approach-2
  public int longestOnes1(int[] nums, int k) {
    int start = 0;
    int end = 0;
    int maxCount = 0;
    int countZero = 0;

    while (end < nums.length) {
      //Expanding Window
      if(nums[end] == 0){
        countZero++;
      }
      end++;

      // Hit the Window

      if(countZero == k ){
        maxCount = Math.max(end-start, maxCount);
      }

      // Compress Window
      while (countZero > k && start <= end) {
        if(nums[start] == 0){
          countZero--;
        }
        start++;
      }
    }
    return Math.max(end-start, maxCount);
  }
}
