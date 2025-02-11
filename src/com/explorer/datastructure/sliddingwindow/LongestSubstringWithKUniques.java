package com.explorer.datastructure.sliddingwindow;

import java.util.HashMap;
import java.util.Map;

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
