package com.explorer.datastructure.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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
