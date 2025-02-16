package com.explorer.datastructure.twopointer;

/**
 * Sort Colors
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 *
 * https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors012 {

  public static void main(String[] args) {
    SortColors012 instance = new SortColors012();
    int [] arr = new int[] {2,0,2,1,1,0};
    instance.sortColors(arr);
    System.out.print("{");
    for(int i = 0; i< arr.length; i++){
      System.out.print(arr[i]);
    }
    System.out.print("}");
  }

  public void sortColors(int[] nums) {
    int zi = 0;
    int ti = nums.length - 1;
    int i = 0;

    while (i <= ti) {
      if (nums[i] == 0) {
        swap(nums, i, zi);
        zi++;
        i++;
      } else if (nums[i] == 2) {
        swap(nums, i, ti);
        ti--;
        // i++;  // Don't increment i here as it's not sorted yet
      } else {
        i++;
      }
    }
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }
}
