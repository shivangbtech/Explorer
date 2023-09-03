package com.explorer.datastructure.stack;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * https://leetcode.com/problems/valid-parentheses/
 */

public class ValidParentheses {

  public static void main(String[] args) {
    ValidParentheses instance = new ValidParentheses();
    //        String expression = "[19-5*(9+4)";
    //        String expression = "(1+5}";
    //        String expression = "[5+4*(9-2)]";
    //        String expression = "{3+2-[9%2)]";
    //        String expression = "[2+(4*2)-{6%4}]";
    //        String expression = "{3+2-[}9%2)]";
    //    String expression = "{3+2-([}9%2)]";
    boolean result = instance.isValid("()[]}{");
    System.out.println(result);
  }

  /**
   * Method called to validate parentheses
   * @param s
   * @return
   */
  public boolean isValid(String s) {
    char[] arr = s.toCharArray();
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
        stack.push(arr[i]);
      } else if (!stack.empty()) {
        if (arr[i] == ')') {
          if (stack.pop() != '(') {
            return false;
          }
        } else if (arr[i] == '}') {
          if (stack.pop() != '{') {
            return false;
          }
        } else if (arr[i] == ']') {
          if (stack.pop() != '[') {
            return false;
          }
        }
      }else {
        return false;
      }
    }
    return stack.empty();
  }

  /**
   * Method call to validate an expression containing nested parentheses
   */
  public boolean validateNestedParentheses(String expression) {
    Stack<Character> stack = new Stack<>();
    char[] arr = expression.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
        stack.push(arr[i]);
      }
      if (arr[i] == ')' || arr[i] == '}' || arr[i] == ']') {
        if (stack.empty()) {
          return false;
        } else {
          char temp = stack.pop();
          if (arr[i] == ')' && (temp == '{' || temp == '[')) {
            return false;
          }
          if (arr[i] == '}' && (temp == '(' || temp == '[')) {
            return false;
          }
          if (arr[i] == ']' && (temp == '(' || temp == '{')) {
            return false;
          }
        }
      }
    }
    if (!stack.empty()) {
      return false;
    }
    return true;
  }
}
