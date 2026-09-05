package com.Project.post_comment.ThreadsPractice;

public class AllAboutThreads implements Runnable {
  public static void main(String[] args) {

    AllAboutThreads runnable = new AllAboutThreads();

    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);

    t1.start();
    t2.start();

  }

  @Override
  public void run() {

    for (int i =0; i<5; i++) {
      System.out.println("Thread " +Thread.currentThread().getName()+ " is running " +i);

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

  }
}
