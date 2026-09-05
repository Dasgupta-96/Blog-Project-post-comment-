package com.Project.post_comment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

  public static void main(String[] args) {

    //TODO: Group anagrams
    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    List<List<String>> lists = groupAnagrams(strs);

    System.out.println(lists);
  }
  public static List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {

      char[] arr = str.toCharArray();
      Arrays.sort(arr);

      String key = new String(arr);

      if (!map.containsKey(key)) {
        // if key doesn't exist in the map then create a List and put into map with key
        map.put(key, new ArrayList<>());
      }
      // then add current string
      List<String> addStringsToMap = map.get(key);
      addStringsToMap.add(str);

    }
    return new ArrayList<>(map.values());
  }
}
