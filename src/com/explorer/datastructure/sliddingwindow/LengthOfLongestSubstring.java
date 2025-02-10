package com.explorer.datastructure.sliddingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LengthOfLongestSubstring {

  public static void main(String[] args) {
    LengthOfLongestSubstring instance = new LengthOfLongestSubstring();
    int result = instance.lengthOfLongestSubstring("abcabcbb");
  }

  public int lengthOfLongestSubstring(String s) {
    int l = 0;
    int r = 0;
    int length = 0;
    Set<Character> window = new HashSet();

    while (r < s.length()) {
      char c = s.charAt(r);

      while (window.contains(c)) {
        window.remove(s.charAt(l));
        l++;
      }

      window.add(c);
      r++;
      length = Math.max(length, window.size());
    }
    return length;
  }
}
