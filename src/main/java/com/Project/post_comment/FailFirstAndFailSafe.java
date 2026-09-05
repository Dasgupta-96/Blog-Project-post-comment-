package com.Project.post_comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFirstAndFailSafe {

  public static void main(String[] args) {

//    List<Integer> numbers = new ArrayList<>();
//
//    numbers.add(10);
//    numbers.add(20);
//    numbers.add(30);
//
//    Iterator<Integer> iterator = numbers.iterator();
//
//    while (iterator.hasNext()) {
//      Integer num = iterator.next();
//
//      if (num.equals(20)) {
//        numbers.add(40);
//      }
//    }
//    System.out.println(numbers);
    //TODO: gives Concurrent Modification Exception it occurs when collection is
    // structurally modified while being iterated over so every fail first collection maintains a
    // variable called modCount and it increments when the collection is structurally modified
    // ex of modification : add(), remove()

//    // if(modCount != expectedModCount) {
//    throw new ConcurrentModificationException();
//  }

    // How to avoid it
    List<Integer> list = new ArrayList<>(List.of(10, 20, 30));
    ListIterator<Integer> itr = list.listIterator();
// we are not adding to so it doesn't increment the mod count
    while (itr.hasNext()) {
      Integer next = itr.next();

      if (Objects.equals(next, 20)) {
//TODO: When you call iterator.remove() add(), it updates both the collection and the iterator's expected modification count, so they remain in sync.
        itr.add(40); //so iterator updates expectedModCount
      }
    }
    System.out.println(list);

    Map<Integer, String> map = new HashMap<>();
    map.put(1, "arkadeb");
    map.put(2, "ankit");
    map.put(3, "huzefa");

    Iterator<Integer> iterator = map.keySet().iterator();

    while (iterator.hasNext()) {
      Integer next = iterator.next();

      if (next == 2) {
        iterator.remove();
      }
    }
    System.out.println(map);
// TODO: Fail safe

    CopyOnWriteArrayList<Integer> cp = new CopyOnWriteArrayList<>();
    cp.add(10);
    cp.add(20);
    cp.add(40);
    cp.add(50);

    for (Integer c : cp) {
      System.out.println(c);

      if (c == 20) {
        cp.add(30);
      }
    }
    System.out.println(cp);


  }

}
