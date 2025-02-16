package com.explorer.datastructure.sliddingwindow;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 * Maximum Average Subarray I
 *
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 *
 * Input: nums = [5], k = 1
 * Output: 5.00000
 */
public class MaxAverageSubArray {

  public static void main(String[] args) {
    MaxAverageSubArray maxAverageSubArray = new MaxAverageSubArray();
    int[] nums =
        {8860, -853, 6534, 4477, -4589, 8646, -6155, -5577, -1656, -5779, -2619, -8604, -1358, -8009, 4983, 7063, 3104, -1560, 4080, 2763, 5616, -2375, 2848, 1394, -7173, -5225, -8244, -809, 8025,
            -4072, -4391, -9579, 1407, 6700, 2421, -6685, 5481, -1732, -8892, -6645, 3077, 3287, -4149, 8701, -4393, -9070, -1777, 2237, -3253, -506, -4931, -7366, -8132, 5406, -6300, -275, -1908, 67,
            3569, 1433, -7262, -437, 8303, 4498, -379, 3054, -6285, 4203, 6908, 4433, 3077, 2288, 9733, -8067, 3007, 9725, 9669, 1362, -2561, -4225, 5442, -9006, -429, 160, -9234, -4444, 3586, -5711,
            -9506, -79, -4418, -4348, -5891};
    int k = 4;
    double result = maxAverageSubArray.findMaxAverage2(nums, k);
    System.out.println("result ->" + result);
  }

  public double findMaxAverage1(int[] nums, int k) {
    if (nums.length == 1) {
      return (double) nums[0];
    }

    int l = 0;
    int r = 0;

    double sum = 0;
    double maxAvg = Double.NEGATIVE_INFINITY;

    while (r < nums.length) {
      // Expanding the window
      sum = sum + nums[r];
      r++;

      // Compress the window
      if ((r - l) > k) {
        sum = sum - nums[l];
        l++;
      }

      // Hit the window
      if ((r - l) == k) {
        double avg = sum / k;
        if (avg > maxAvg) {
          maxAvg = avg;
        }
      }

    }
    return maxAvg;
  }

  public double findMaxAverage2(int[] nums, int k) {
    if (nums.length == 1) {
      return (double) nums[0];
    }

    int l = 0;
    int r = 0;

    double sum = 0;
    double maxAvg = Double.NEGATIVE_INFINITY;  // Initialize to the smallest possible value

    // Calculate the sum of the first k elements
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }

    // Initialize maxAvg to the average of the first k elements
    maxAvg = sum / k;

    // Slide the window over the array
    for (int i = k; i < nums.length; i++) {
      sum += nums[i] - nums[i - k];  // Adjust the window sum
      double avg = sum / k;  // Calculate the new average
      if (avg > maxAvg) {
        maxAvg = avg;  // Update maxAvg if the new average is higher
      }
    }

    return maxAvg;
  }
}
