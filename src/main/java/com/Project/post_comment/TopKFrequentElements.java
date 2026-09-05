package com.Project.post_comment;

import org.springframework.boot.actuate.endpoint.web.Link;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

  public static void main(String[] args) {

    int [] num = {1,1,1,2,2,3};
    int k =2;
    int[] no = topKFrequent(num, k);

    for (int n : no) {
      System.out.println(n);
    }



  }

  public static int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> freqMap = new HashMap<>();

    for (int num : nums) {
      freqMap.put(num,
        freqMap.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Integer> pq =
      new PriorityQueue<>(
        (a, b) ->
          freqMap.get(a) - freqMap.get(b));

    for (int num : freqMap.keySet()) {

      pq.offer(num);

      if (pq.size() > k) {
        pq.poll();
      }
    }

    int[] result = new int[k];

    for (int i = k - 1; i >= 0; i--) {
      result[i] = pq.poll();
    }

    return result;
  }
}
