package com.Project.post_comment;

public class MinimumWindowSubString {

  public static void main(String[] args) {

    String s = "ADOBECODEBANC";

    String target = "ABC";

    System.out.println(findMinWindowSubString(s, target));

  }

  public static String findMinWindowSubString(
    String s,
    String target) {

    int[] mapS = new int[256];
    int[] mapT = new int[256];

    //TODO: ch is a character, but Java automatically treats char as an integer when used as an array index
    // Frequency of target characters
    for (char ch : target.toCharArray()) {
      mapT[ch]++;
    }

    int left = 0;
    int right = 0;

    int minLen = Integer.MAX_VALUE;
    int minStart = 0;

    for (; right < s.length(); right++) {

      // Add current character to window
      mapS[s.charAt(right)]++;

      // Try shrinking while window is valid
      while (contains(mapS, mapT)) {

        int currentLen = right - left + 1;

        // Update only if current window is smaller
        if (currentLen < minLen) {
          minLen = currentLen;
          minStart = left;
        }

        // Remove left character
        mapS[s.charAt(left)]--;

        // Move left pointer
        left++;
      }
    }

    return minLen == Integer.MAX_VALUE
      ? ""
      : s.substring(
      minStart,
      minStart + minLen
    );
  }
  private static boolean contains(int [] mapS, int [] mapT) {

    for (int i =0; i< 256; i++) {

      if (mapT[i] > mapS[i]) return false;
    }
    return true;
  }
}
