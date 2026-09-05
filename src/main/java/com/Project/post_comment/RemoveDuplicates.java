package com.Project.post_comment;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {
  // remove duplicates from the sorted array
  public static void main(String[] args) {

    int [] a = {1,1,2,2,2,3,3};

    int i =0;

    for (int j =1; j<a.length; j++) {

      if (a[i] != a[j]) {
        a[i+1] = a[j];
        i++;
      }
    }
    for (int k = 0; k <= i; k++) {
      System.out.print(a[k] + " ");
    }


    //TODO: Remove duplicate from String

    String str = "programming";

    //TODO: Traditional approach
    Set<Character> set = new LinkedHashSet<>();

    StringBuilder stringBuilder = new StringBuilder();

    for (char ch : str.toCharArray()) {

     if (set.add(ch)) {
       stringBuilder.append(ch);
     }
    }

    System.out.println(stringBuilder.toString());

    //TODO: Stream api

    String result = str.chars().mapToObj(ch -> (char) ch)
      .collect(Collectors.toCollection(LinkedHashSet::new))
      .stream().map(String::valueOf)
      .collect(Collectors.joining());

    System.out.println(result);
  }
}
