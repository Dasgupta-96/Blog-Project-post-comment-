package com.Project.post_comment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrequencyNumbers {
  public static void main(String[] args) {

    int[] arr = {1, 1, 2, 3, 3, 4, 4, 4};
    Map<Integer, Integer> freq = new HashMap();

    for (int i = 0; i < arr.length; i++) {
      freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
    }
    Set<Map.Entry<Integer, Integer>> entries = freq.entrySet();

    for (Map.Entry<Integer, Integer> e : entries) {

      if (e.getValue() == 1) {
        System.out.println("The frequency i am getting as: "+ e.getKey());
        break;
      }
    }
  }
}
