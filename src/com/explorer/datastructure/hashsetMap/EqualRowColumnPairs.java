package com.explorer.datastructure.hashsetMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2352. Equal Row and Column Pairs
 *
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 *
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
 * Output: 1
 * Explanation: There is 1 equal row and column pair:
 * - (Row 2, Column 1): [2,7,7]
 * Example 2:
 *
 *
 * Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * Output: 3
 * Explanation: There are 3 equal row and column pairs:
 * - (Row 0, Column 0): [3,1,2,2]
 * - (Row 2, Column 2): [2,4,2,2]
 * - (Row 3, Column 2): [2,4,2,2]
 *
 *
 * Constraints:
 *
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 105
 *
 * https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class EqualRowColumnPairs {
  public static void main(String[] args) {
  EqualRowColumnPairs instance = new EqualRowColumnPairs();
    int[][] grid1 = {{3,2,1},{1,7,6},{2,7,7}};
    System.out.println("Output: " + instance.equalPairs(grid1)); // Output: 1

    int[][] grid2 = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
    System.out.println("Output: " + instance.equalPairs(grid2)); // Output: 3
  }

  public int equalPairs(int[][] grid) {
    int n = grid.length;
    int count = 0;
    Map<String, Integer> map = new HashMap<String, Integer>();

    for (int[] row : grid) {
      String key = Arrays.toString(row);
      map.put(key, map.getOrDefault(key, 0) + 1);
    }

    for (int c = 0; c < n; c++) {
      int[] column = new int[n];
      for (int r = 0; r < n; r++) {
        column[r] = grid[r][c];
      }
      String key = Arrays.toString(column);
      count = count + map.getOrDefault(key, 0);
    }
    return count;
  }
}
