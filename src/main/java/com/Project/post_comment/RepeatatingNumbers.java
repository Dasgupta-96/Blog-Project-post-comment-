package com.Project.post_comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatatingNumbers {

  public static void main(String[] args) {

    String name = "arkadebk";
    Map<Character, List<Integer>> map = new HashMap<>();
   
    for (int i =0; i<name.length(); i++) {

      char ch = name.charAt(i);

      map.computeIfAbsent(ch, key -> new ArrayList<>()).add(i);

    }
    for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {

      if (entry.getValue().size() > 1) {

        System.out.println(entry.getKey() + " : " + entry.getValue());
      }
    }


  }
}
