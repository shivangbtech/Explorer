package com.explorer.datastructure.sliddingwindow;

/**
 * 1493. Longest Subarray of 1's After Deleting One Element
 *
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 * Example 2:
 *
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * Example 3:
 *
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 *
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class LongestSubarrayOfOnesAfterDelete {
  public static void main(String[] args) {
    LongestSubarrayOfOnesAfterDelete instance = new LongestSubarrayOfOnesAfterDelete();
    int result = instance.longestSubarray(new int[] {0,1,1,1,0,1,1,0,1});
    System.out.println("Result: " + result);
  }

  public int longestSubarray(int[] nums) {
    int l = 0;
    int r = 0;
    int maxLength = 0;
    int fCount = 0;
    int length = 0;

    while(r < nums.length){
      if(nums[r] == 0){
        fCount++;
      }
      length++;

      if(fCount > 1){
        maxLength = Math.max(length -fCount, maxLength);
        while(fCount > 1){
          if(nums[l] == 0){
            fCount--;
          }
          length--;
          l++;
        }
      }
      r++;
    }
    return Math.max(length -1, maxLength);
  }
}
