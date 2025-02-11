package com.explorer.datastructure.array;

/**
 * 1910. Remove All Occurrences of a Substring
 *
 * Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
 *
 * Find the leftmost occurrence of the substring part and remove it from s.
 * Return s after removing all occurrences of part.
 *
 * A substring is a contiguous sequence of characters in a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "daabcbaabcbc", part = "abc"
 * Output: "dab"
 * Explanation: The following operations are done:
 * - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
 * - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
 * - s = "dababc", remove "abc" starting at index 3, so s = "dab".
 * Now s has no occurrences of "abc".
 * Example 2:
 *
 * Input: s = "axxxxyyyyb", part = "xy"
 * Output: "ab"
 * Explanation: The following operations are done:
 * - s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
 * - s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
 * - s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
 * - s = "axyb", remove "xy" starting at index 1 so s = "ab".
 * Now s has no occurrences of "xy".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * 1 <= part.length <= 1000
 * s​​​​​​ and part consists of lowercase English letters.
 *
 * https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/?envType=daily-question&envId=2025-02-11
 */
public class RemoveOccurrencesOfSubstring {

  public static void main(String[] args) {
    RemoveOccurrencesOfSubstring instance = new RemoveOccurrencesOfSubstring();

  }

  public String removeOccurrences1(String s, String part) {
    char[] stack = new char[s.length()];
    int index = 0;
    int partLength = part.length();

    for (char c : s.toCharArray()) {
      stack[index++] = c;
      if (index >= partLength && new String(stack, index - partLength, partLength).equals(part)) {
        index -= partLength;
      }
    }
    return new String(stack, 0, index);
  }

  public String removeOccurrences2(String s, String part) {
    StringBuilder sb = new StringBuilder();
    int partLength = part.length();

    for (char c : s.toCharArray()) {
      sb.append(c);
      if (sb.length() >= partLength && sb.substring(sb.length() - partLength).equals(part)) {
        sb.setLength(sb.length() - partLength);
      }
    }
    return sb.toString();
  }

  public String removeOccurrences3(String s, String part) {
    StringBuilder sb = new StringBuilder(s);
    int index;
    while ((index = sb.indexOf(part)) != -1) {
      sb.delete(index, index + part.length());
    }
    return sb.toString();
  }

  public String removeOccurrences4(String s, String part) {
    while (s.contains(part)) {
      s = s.replaceFirst(part, "");
    }
    return s;
  }
}
