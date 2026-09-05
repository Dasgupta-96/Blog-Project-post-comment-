package com.Project.post_comment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {

  public static void main(String[] args) {

    String [] array = {"apple", "kiwi", "lichi"};
    List<String> list = Arrays.asList(array);

    System.out.println(list);
    List<String> list1 = new ArrayList<>(list);

    list1.add("guava");
    System.out.println(list1);
//
//   list1.remove("kiwi");
//
//    System.out.println(list1);


  }
}
