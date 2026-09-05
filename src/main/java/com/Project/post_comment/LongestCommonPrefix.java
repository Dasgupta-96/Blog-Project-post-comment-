package com.Project.post_comment;

import java.util.Arrays;

public class LongestCommonPrefix {
  public static void main(String[] args) {

    String[] strings = {"club", "clap", "clove"};
    System.out.println(findLargestCommonPrefix(strings));
  }

  private static String findLargestCommonPrefix(String[] strings) {

    StringBuilder stringBuilder = new StringBuilder();

    Arrays.sort(strings);
    char[] first = strings[0].toCharArray();
    char[] last = strings[strings.length - 1].toCharArray();

    for (int i = 0; i < first.length; i++) {

      if (first[i] == last[i]) {
        stringBuilder.append(first[i]);
      } else {
        break;
      }
    }
    return stringBuilder.toString();
  }
}
