package com.Project.post_comment;

public class ReverseWordsInString {

  public static void main(String[] args) {

    String str = "welcome to jungle";

    char[] arr = str.toCharArray();

    int left = 0;

    for (int right = 0; right < arr.length; right++) {

      if (arr[right] == ' ') {

        reverse(arr, left, right - 1);

        left = right + 1;
      }
    }

    // Reverse last word
    reverse(arr, left, arr.length - 1);

    System.out.println(new String(arr));
  }


  private static void reverse(char[] arr, int left, int right) {

    while (left < right) {

      char temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;

      left++;
      right--;
    }
  }
}
