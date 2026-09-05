package com.Project.post_comment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorUnderstanding {

  public static void main(String[] args) {

    List<String> fruits = new ArrayList<>();

    fruits.add("banana");
    fruits.add("lichi");
    fruits.add("pineapple");

    fruits.sort(new MyFruitsComparator());

    System.out.println(fruits);

    List<Integer> no = new ArrayList<>();
    no.add(3);
    no.add(5);
    no.add(2);

    no.sort(new MyNumberComparator());

    System.out.println(no);
  }
}

class MyFruitsComparator implements Comparator<String> {

  @Override
  public int compare(String o1, String o2) {
    return o2.length() - o1.length();
  }
}

class MyNumberComparator implements Comparator<Integer> {

  @Override
  public int compare(Integer o1, Integer o2) {
    return o2 - o1;
  }
}