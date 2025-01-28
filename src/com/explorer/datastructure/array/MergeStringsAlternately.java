package com.explorer.datastructure.array;

/***
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MergeStringsAlternately {

  public static void main(String[] args) {
    MergeStringsAlternately mergeStringsAlternately = new MergeStringsAlternately();
    String result = mergeStringsAlternately.mergeAlternately5("abcdefgh", "pqrs");
    System.out.printf("Result-> " + result);
  }

  public String mergeAlternately1(String word1, String word2) {

    char[] w1 = word1.toCharArray();
    char[] w2 = word2.toCharArray();
    char[] result = new char[w1.length + w2.length];

    int i = 0;
    int j = 0;
    int k = 0;
    while (i < w1.length && j < w2.length) {
      result[k] = w1[i];
      k++;
      result[k] = w2[j];
      k++;
      i++;
      j++;
    }

    while (i < w1.length) {
      result[k] = w1[i];
      k++;
      i++;
    }

    while (j < w2.length) {
      result[k] = w2[j];
      k++;
      j++;
    }
    return String.valueOf(result);
  }

  public String mergeAlternately2(String word1, String word2) {

    StringBuilder mergedString = new StringBuilder();
    int i = 0, j = 0;
    while (i < word1.length() || j < word2.length()) {
      if (i < word1.length()) {
        mergedString.append(word1.charAt(i++));
      }
      if (j < word2.length()) {
        mergedString.append(word2.charAt(j++));
      }
    }
    return mergedString.toString();
  }

  public String mergeAlternately3(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    char[] mergedArray = new char[len1 + len2];
    int index = 0, i = 0, j = 0;

    while (i < len1 || j < len2) {
      if (i < len1) {
        mergedArray[index++] = word1.charAt(i++);
      }
      if (j < len2) {
        mergedArray[index++] = word2.charAt(j++);
      }
    }

    return new String(mergedArray);
  }

  public String mergeAlternately4(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    char[] result = new char[len1 + len2];

    int i = 0, j = 0, k = 0;
    while (i < len1 && j < len2) {
      result[k++] = word1.charAt(i++);
      result[k++] = word2.charAt(j++);
    }

    while (i < len1) {
      result[k++] = word1.charAt(i++);
    }

    while (j < len2) {
      result[k++] = word2.charAt(j++);
    }

    return new String(result);
  }

  public String mergeAlternately5(String word1, String word2) {
    char[] w1 = word1.toCharArray();
    char[] w2 = word2.toCharArray();
    char[] result = new char[w1.length + w2.length];

    int i = 0;
    int j = 0;
    int k = 0;
    while (i < w1.length || j < w2.length) {
      if (i < w1.length) {
        result[k++] = w1[i++];
      }
      if (j < w2.length) {
        result[k++] = w2[j++];
      }
    }
    return String.valueOf(result);
  }
}
