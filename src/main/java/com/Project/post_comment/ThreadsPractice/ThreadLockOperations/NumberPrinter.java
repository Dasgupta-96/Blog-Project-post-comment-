package com.Project.post_comment.ThreadsPractice.ThreadLockOperations;

class NumberPrinter {

  private int number = 1;
  private final int MAX = 10;

  public synchronized void printOdd() throws InterruptedException {

    while (number <= MAX) {

      while (number % 2 == 0) {
        wait();
      }

      if (number <= MAX) {
        System.out.println(
          Thread.currentThread().getName()
            + " : " + number);

        number++;
        notifyAll();
      }
    }
  }

  public synchronized void printEven() throws InterruptedException {

    while (number <= MAX) {

      while (number % 2 != 0) {
        wait();
      }

      if (number <= MAX) {
        System.out.println(
          Thread.currentThread().getName()
            + " : " + number);

        number++;
        notifyAll();
      }
    }
  }

  public static void main(String[] args) {

    NumberPrinter printer = new NumberPrinter();

    Thread odd = new Thread(() -> {
      try {
        printer.printOdd();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    });

    Thread even = new Thread(() -> {
      try {
        printer.printEven();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    });

    odd.start();
    even.start();
  }
}