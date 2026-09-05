package com.Project.post_comment.ThreadsPractice.ThreadLockOperations;

public class Counter {

  private int count = 0;

  public void increment() {

    System.out.println(Thread.currentThread().getName() + " Trying to acquire a lock");

    synchronized (this) {
      System.out.println(
        Thread.currentThread().getName()
          + " acquired lock"
      );

      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      count++;

      System.out.println(
        Thread.currentThread().getName()
          + " releasing lock"
      );
    }
  }

    public int getCount () {
      return count;
    }

    public static void main (String[]args) throws InterruptedException {

      Counter counter = new Counter();
      Thread t1 = new Thread(() -> {

        for (int i = 0; i < 1000; i++) {
          counter.increment();
        }

      }, "Thread-1");

      Thread t2 = new Thread(() -> {

        for (int i = 0; i < 1000; i++) {
          counter.increment();
        }

      }, "Thread-2");

      t1.start();
      t2.start();

      t1.join();
      t2.join();

      System.out.println(counter.getCount());

    }

  }
