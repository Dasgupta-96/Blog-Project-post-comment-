package com.Project.post_comment.ThreadsPractice;

public class T1T2T3OneAfterAnother {

  public static void main(String[] args) {

    final Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {

        System.out.println("Starting 1");
        System.out.println("Ending 1");
      }
    });

    final Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Starting 2");
        try {
          t1.join();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        System.out.println("Ending 2");
      }
    });

    final Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Starting 3");
        try {
          t2.join();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        System.out.println("Ending 3");
      }
    });

    t1.start();
    t2.start();
    t3.start();
  }
}
