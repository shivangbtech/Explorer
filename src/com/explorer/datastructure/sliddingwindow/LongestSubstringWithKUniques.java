package com.explorer.datastructure.sliddingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with K Uniques
 *
 * Given a string s, you need to print the size of the longest possible substring with exactly k unique characters. If no possible substring exists, print -1.
 *
 * Examples:
 *
 * Input: s = "aabacbebebe", k = 3
 * Output: 7
 * Explanation: "cbebebe" is the longest substring with 3 distinct characters.
 * Input: s = "aaaa", k = 2
 * Output: -1
 * Explanation: There's no substring with 2 distinct characters.
 * Input: s = "aabaaab", k = 2
 * Output: 7
 * Explanation: "aabaaab" is the longest substring with 2 distinct characters.
 * Constraints:
 * 1 ≤ s.size() ≤ 105
 * 1 ≤ k ≤ 26
 * All characters are lowercase letters
 *
 * https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 */
public class LongestSubstringWithKUniques {

  public static void main(String[] args) {
    LongestSubstringWithKUniques instance = new LongestSubstringWithKUniques();
    int result = instance.longestkSubstr("aabacbebebe", 3);
    System.out.println("Result: " + result);
  }

  public int longestkSubstr(String s, int k) {
    int l = 0;
    int r = 0;
    Map<Character, Integer> map = new HashMap();
    int max_length = 0;

    while (r < s.length()) {
      map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
      r++;

      if (map.keySet().size() == k) {
        max_length = Math.max(r - l, max_length);
      }

      while (map.keySet().size() > k) {
        if (map.get(s.charAt(l)) > 1) {
          map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
        } else {
          map.remove(s.charAt(l));
        }
        l++;
      }
    }
    if (map.keySet().size() != k) {
      return -1;
    }
    return max_length;
  }
}
