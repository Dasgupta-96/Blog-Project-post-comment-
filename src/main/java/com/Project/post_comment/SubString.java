package com.Project.post_comment;

public class SubString {
  public static void main(String[] args) {
    String s = "1234567899876543";
    String cardNo = findMaskedCardNo(s);
    System.out.println(cardNo);
  }
  public static String findMaskedCardNo(String s){

    String maskedCardNo = "";
    String last4digits = s.substring(s.length()-4);

    StringBuilder maskedCards = new StringBuilder();

    for (int i =0; i<s.length()-4; i++){ // 0->11

      maskedCards.append("*");
    }
    maskedCardNo = maskedCards.toString() + last4digits;
    return maskedCardNo;
  }

}
