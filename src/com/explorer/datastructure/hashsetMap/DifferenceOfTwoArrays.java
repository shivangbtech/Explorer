package com.explorer.datastructure.hashsetMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 2215. Find the Difference of Two Arrays
 *
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 *
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3], nums2 = [2,4,6]
 * Output: [[1,3],[4,6]]
 * Explanation:
 * For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
 * For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
 * Example 2:
 *
 * Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 * Output: [[3],[]]
 * Explanation:
 * For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
 * Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * -1000 <= nums1[i], nums2[i] <= 1000
 *
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class DifferenceOfTwoArrays {

  public static void main(String[] args) {
    DifferenceOfTwoArrays differenceOfTwoArrays = new DifferenceOfTwoArrays();
    int[] nums1 = {};
    int[] nums2 = {};

    System.out.println(differenceOfTwoArrays.findDifference(nums1, nums2));
  }

  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

    HashSet<Integer> hs1 = new HashSet<>();
    HashSet<Integer> hs2 = new HashSet<>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    result.add(list1);
    result.add(list2);

    int i = 0;
    int j = 0;

    while (i < nums1.length || j < nums2.length) {
      if (i < nums1.length) {
        hs1.add(nums1[i]);
        i++;
      }

      if (j < nums2.length) {
        hs2.add(nums2[j]);
        j++;
      }
    }

    Iterator<Integer> hsIterator1 = hs1.iterator();
    while (hsIterator1.hasNext()) {
      Integer next = hsIterator1.next();
      if (!hs2.contains(next)) {
        list1.add(next);
      }
    }

    Iterator<Integer> hsIterator2 = hs2.iterator();
    while (hsIterator2.hasNext()) {
      Integer next = hsIterator2.next();
      if (!hs1.contains(next)) {
        list2.add(next);
      }
    }

    return result;
  }

  public List<List<Integer>> findDifference1(int[] nums1, int[] nums2) {

    HashSet<Integer> hs1 = new HashSet<>();
    HashSet<Integer> hs2 = new HashSet<>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    result.add(list1);
    result.add(list2);

    int i = 0;
    int j = 0;

    while (i < nums1.length || j < nums2.length) {
      if (i < nums1.length) {
        hs1.add(nums1[i]);
        i++;
      }

      if (j < nums2.length) {
        hs2.add(nums2[j]);
        j++;
      }
    }

    for (int num : hs1) {
      if (!hs2.contains(num)) {
        list1.add(num);
      }
    }

    // Find elements in set2 not in set1
    for (int num : hs2) {
      if (!hs1.contains(num)) {
        list2.add(num);
      }
    }

    return result;
  }
}
