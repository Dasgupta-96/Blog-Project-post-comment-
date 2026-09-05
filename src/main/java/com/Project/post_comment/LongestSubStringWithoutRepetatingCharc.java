package com.Project.post_comment;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepetatingCharc {
  public static void main(String[] args) {

    String s = "p w w k e w x p w";

    int i = longestSubStringWithoutCharacters(s);
    System.out.println(i);

    int i1 = longestSubStringWithoutCharcRepeat(s); //TODO: better simple way
    System.out.println(i1);
  }

  private static int longestSubStringWithoutCharacters(String s) {

    Set<Character> characterSet = new HashSet<>();

    int left = 0;
    int max = 0;

    for (int right = 0; right < s.length(); right++) {

      while (characterSet.contains(s.charAt(right))) {

        characterSet.remove(s.charAt(left));
        left++;
      }

      characterSet.add(s.charAt(right));

      max = Math.max(max, right - left + 1);
    }

    return max;

  }

  private static int longestSubStringWithoutCharcRepeat(String s) {

    int right =0, left = 0, max =0 ;

    Set<Character> hashSet = new HashSet<>();

    while (right < s.length()) {
      if (!hashSet.contains(s.charAt(right))) {
        hashSet.add(s.charAt(right));
        right++;

        max = Math.max(hashSet.size(), max);

      } else {
        hashSet.remove(s.charAt(left));
        left++;
      }
    }
    return max;
  }
}
