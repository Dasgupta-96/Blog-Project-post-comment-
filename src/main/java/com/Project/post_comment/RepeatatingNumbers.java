package com.Project.post_comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatatingNumbers {

  public static void main(String[] args) {

    String name = "arkadebk";
    Map<Character, List<Integer>> map = new HashMap<>();

    for (int i = 0; i < name.length(); i++) {

      char ch = name.charAt(i);

      map.computeIfAbsent(ch, key -> new ArrayList<>()).add(i);

    }
    for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {

      if (entry.getValue().size() > 1) {

        System.out.println(entry.getKey() + " : " + entry.getValue());
      }
    }

    String s = "leetcode";
   //TODO: using streams
    Character c1 = s.chars().mapToObj(c -> (char) c)
      .filter(ch -> s.indexOf(ch) == s.lastIndexOf(ch))
      .findFirst().get();

    System.out.println(c1);

    //TODO: traditional hashmap approach
    Map<Character, Integer> map1 = new HashMap<>();
    for (char c : s.toCharArray()) {

      map1.put(c, map1.getOrDefault(c, 0) +1);

    }
    for (int i =0; i<s.length(); i++) {

      if (map1.get(s.charAt(i)) == 1) {
        System.out.println(s.charAt(i));
        System.out.println(i);
        break;
      }

    }

  }
}
