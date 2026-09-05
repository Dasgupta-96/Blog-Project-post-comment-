package com.Project.post_comment;

public class Palindrome {

  public static void main(String[] args) {

    String name = "madam";

    System.out.println(findIfStringIsPalindrome(name));
  }

  private static boolean findIfStringIsPalindrome(String str) {

    StringBuilder reverse = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {

      reverse.append(str.charAt(i));
    }
    if (str.equals(reverse.toString())) {
      return true;
    }
    else {
      return false;
    }
//
//    public static boolean isPalindrome(String str) {
//
//      int left = 0;
//      int right = str.length() - 1;
//
//      while (left < right) {
//
//        if (str.charAt(left) != str.charAt(right)) {
//          return false;
//        }
//
//        left++;
//        right--;
//      }
//
//      return true;
//    }
  }
}
