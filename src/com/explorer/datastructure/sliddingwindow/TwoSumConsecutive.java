package com.explorer.datastructure.sliddingwindow;

public class TwoSumConsecutive {

  public static void main(String[] args) {
    TwoSumConsecutive sInstance = new TwoSumConsecutive();
    //        int[] result =  sInstance.twoSum(new int[]{2,7,11,15}, 9);
    int[] result =  sInstance.twoSum(new int[]{3,2,4}, 6);

    for(int i=0; i<result.length; i++){
      System.out.println(result[i] + ",");
    }
  }
  public int[] twoSum(int[] nums, int target) {
    int l = 0;
    int r = 0;
    int sum = 0;
    int[] result = new int[0];

    while(r < nums.length){
      // Expending the window
      sum = sum + nums[r];
      r++;

      // Compress the window
      while(sum > target){
        sum = sum - nums[l];
        l++;
      }

      // Hit the condition
      if(sum == target){
        result = new int[r-l];
        int temp = l;
        for(int i=0; i<r-l; i++){
          result[i] = temp;
          temp++;
        }
      }
    }
    return result;
  }
}
