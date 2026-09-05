package com.Project.post_comment;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU<K, V> extends LinkedHashMap<K, V> {

  private int capacity;

  public LRU(int capacity) {
    super(capacity, 05f, true);
    this.capacity = capacity;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() > capacity;
  }

  public static void main(String[] args) {

    LRU<String, Integer> lru = new LRU<>(3);

    lru.put("amit", 70);
    lru.put("dev", 46);
    lru.put("gupta", 90);
    lru.put("roy", 86);


    // it will remove the LRU entry from the map as we have implemented  removeEldestEntry
    System.out.println(lru);

    LinkedHashMap<String, Integer> map = new
      LinkedHashMap<>(16, 0.75f, true);



//    ------------------------------------------------------------------------------------



      map.put("Apple", 10);
      map.put("orange", 20);
      map.put("banana", 36);

      //TODO: Performing Least Recently Used algorithm
      map.get("Apple");
      map.get("banana");

    System.out.println(map);

    HashMap<String, Integer> hashMap = new HashMap<>();
    // TODO: we can put hashmap into LinkedHashpMap also like this
    LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(hashMap);
  }
}
