package com.Project.post_comment;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {
  public static void main(String[] args) throws NoSuchAlgorithmException {

    List<Integer> list =
      Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13);

    List<Integer> prime = new ArrayList<>();

    for (Integer l : list) {
      if (isPrime(l)) {
        prime.add(l);
      }
    }
    System.out.println(prime);
  }

  private static boolean isPrime(Integer no) {

    if (no < 2) {
      return false;
    }
    for (int i = 2; i * i <= no; i++) {
      if (no % i == 0) {
        return false;
      }
    }
    return true;
  }

//  public static boolean isPrime(int number) {
//
//    if (number <= 1) {
//      return false;
//    }
//
//    for (int i = 2; i * i <= number; i++) {
//
//      if (number % i == 0) {
//        return false;
//      }
//    }
//
//    return true;
//  }
}
