package com.explorer.datastructure.sliddingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 2461. Maximum Sum of Distinct Subarrays With Length K
 * <p>
 * You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
 * <p>
 * The length of the subarray is k, and
 * All the elements of the subarray are distinct.
 * Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,5,4,2,9,9,9], k = 3
 * Output: 15
 * Explanation: The subarrays of nums with length 3 are:
 * - [1,5,4] which meets the requirements and has a sum of 10.
 * - [5,4,2] which meets the requirements and has a sum of 11.
 * - [4,2,9] which meets the requirements and has a sum of 15.
 * - [2,9,9] which does not meet the requirements because the element 9 is repeated.
 * - [9,9,9] which does not meet the requirements because the element 9 is repeated.
 * We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
 * Example 2:
 * <p>
 * Input: nums = [4,4,4], k = 3
 * Output: 0
 * Explanation: The subarrays of nums with length 3 are:
 * - [4,4,4] which does not meet the requirements because the element 4 is repeated.
 * We return 0 because no subarrays meet the conditions.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
 */
public class MaximumSubarraySum {
  public static void main(String[] args) {
    MaximumSubarraySum instance = new MaximumSubarraySum();
    //    long result = instance.maximumSubarraySum(new int[] {1,5,4,2,9,9,9}, 3); // Result = 15
    //    long result = instance.maximumSubarraySum(new int[] {1,1,1,7,8,9}, 3); // Result = 24
    long result = instance.maximumSubarraySum(new int[] {11, 11, 7, 2, 9, 4, 17, 1}, 1);// Result = 17
    System.out.println("Result: " + result);
  }

  public long maximumSubarraySum(int[] nums, int k) {
    int l = 0;
    int r = 0;
    long sum = 0;
    long max_sum = 0;
    Set<Integer> hs = new HashSet<Integer>();

    while (r < nums.length) {
      while (hs.contains(nums[r])) {
        hs.remove(nums[l]);
        sum -= nums[l];
        l++;
      }

      sum = sum + nums[r];
      hs.add(nums[r]);

      // Hit the condition
      if (r - l == k - 1) {
        max_sum = Math.max(max_sum, sum);
        if (sum > 0) {
          sum -= nums[l];
        }
        hs.remove(nums[l]);
        l++;
      }
      r++;
    }
    return max_sum;
  }
}
