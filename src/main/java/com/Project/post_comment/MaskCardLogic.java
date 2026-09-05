package com.Project.post_comment;

public class MaskCardLogic {
  public static void main(String[] args) {
    String cardNumber = "6257389204738984";
    String ans = maskedCardNo(cardNumber);
    System.out.println(ans);
  }
  public static String maskedCardNo(String cardNumber){

    String maskedCardNumber = "";

    if (cardNumber !=null && cardNumber.length() >= 10){
      String last4Digits = cardNumber.substring(cardNumber.length()-4);
      int maskedCards = cardNumber.length()-4; //12
      StringBuilder sb = new StringBuilder();

      for (int i =0; i<maskedCards; i++){
        sb.append("*");
      }
      maskedCardNumber = sb.toString() + last4Digits;

    }
    else {
      maskedCardNumber = cardNumber;
    }
    return maskedCardNumber;

  }

}
