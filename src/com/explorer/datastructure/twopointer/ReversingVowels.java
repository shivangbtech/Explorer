package com.explorer.datastructure.twopointer;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Reversing the vowels
 *
 * Given a string consisting of lowercase English alphabets, reverse only the vowels present in it and print the resulting string.
 *
 * Examples:
 *
 * Input: s = "geeksforgeeks"
 * Output: "geeksforgeeks"
 * Explanation: The vowels are: e, e, o, e, e. Reverse of these is also e, e, o, e, e.
 * Input: s = "practice"
 * Output: "prectica"
 * Explanation: The vowels are a, i, e. Reverse of these is e, i, a.
 * Input: s = "bcdfg"
 * Output: "bcdfg"
 * Explanation: There are no vowels in s.
 * Constraints:
 * 1<=|s|<=105
 *
 * https://www.geeksforgeeks.org/problems/reversing-the-vowels5304/1
 */
public class ReversingVowels {

  public static void main(String[] args) {
    ReversingVowels instance = new ReversingVowels();
    String result = instance.modify("practice");
    System.out.println("Result: " + result);
  }

  String modify (String s) {
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    char[] arr = s.toCharArray();
    int l = 0;
    int r = arr.length-1;

    while(l<r){
      if(!vowels.contains(arr[l])){
        l++;
      }else if(!vowels.contains(arr[r])){
        r--;
      }else {
        swap(arr, l, r);
        l++;
        r--;
      }
    }
    return String.valueOf(arr);
  }

  public void swap(char[] arr, int i, int j) {
    char temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }
}
