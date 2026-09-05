package com.Project.post_comment;

public class StringOperations {
  public static void main(String[] args) {

    long startTime, endTime;

    StringBuffer stringBuffer = new StringBuffer();
    startTime = System.nanoTime();
    for (int i = 0; i < 100000; i++) {
      stringBuffer.append("a");
    }
    endTime = System.nanoTime();
    System.out.println("StringBuffer: " + (endTime - startTime) + " ns");

    // StringBuilder
    StringBuilder stringBuilder = new StringBuilder();
    startTime = System.nanoTime();
    for (int i = 0; i < 100000; i++) {
      stringBuilder.append("a");
    }
    endTime = System.nanoTime();
    System.out.println("StringBuilder: " + (endTime - startTime) + " ns");
  }
}
