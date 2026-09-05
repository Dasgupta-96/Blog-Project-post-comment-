package com.Project.post_comment;

public class CountVowels {

  public static void main(String[] args) {

    String name = "arkadeb";

    //TODO: indexOf() searches for a character and returns its index.
    long count = name.chars()
      .filter(character -> "aeiou".indexOf(character) != -1).count();

    System.out.println(count);
  }
}
