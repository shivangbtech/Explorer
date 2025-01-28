package com.explorer.datastructure.binarysearch;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Guess Number Higher or Lower
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns three possible results:
 *
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 */
public class GuessGame {

  public static void main(String[] args) {
    GuessGame guessGame = new GuessGame();
    int result = guessGame.guessNumber(2);
    System.out.println("Result -> " + result);
  }

  public int guessNumber(int n) {
    int start = 1;
    int end = n;

    if (n == 1) {
      return 1;
    }

    while (start <= end) {
      int mid = start + (end - start) / 2;
      int guess = guess(mid);
      if (guess == 0) {
        return mid;
      } else if (guess == 1) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  int pick = 2;

  int guess(int num) {
    if (num == pick) {
      return 0;
    } else if (num < pick) {
      return 1;
    }
    return -1;
  }
}
