package com.explorer.datastructure.hashsetMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. Unique Number of Occurrences
 *
 * https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class UniqueNumberOfOccurrences {

  public static void main(String[] args) {
    UniqueNumberOfOccurrences instance = new UniqueNumberOfOccurrences();
    boolean result = instance.uniqueOccurrences(new int[]{1,2,2,1,1,3});
    System.out.println("Result: " + result);
  }

  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
    int i = 0;
    while(i< arr.length){
      if(hm.containsKey(arr[i])){
        hm.put(arr[i], hm.get(arr[i]) + 1);
      }else {
        hm.put(arr[i], 1);
      }
      i++;
    }

    Set<Integer> hs = new HashSet<Integer>(hm.values());
    return hm.keySet().size() <= hs.size();
  }
}
