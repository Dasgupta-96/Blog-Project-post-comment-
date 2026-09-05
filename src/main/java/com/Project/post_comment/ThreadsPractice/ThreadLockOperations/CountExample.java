package com.Project.post_comment.ThreadsPractice.ThreadLockOperations;

public class CountExample {

  int count =0;

  public void increment() throws InterruptedException {

    System.out.println("Trying to acquire a lock" + Thread.currentThread().getName());

    synchronized (this) {
      System.out.println(
        Thread.currentThread().getName()
          + " acquired lock"
      );

      Thread.sleep(5000);

      count++;

      System.out.println("Release the lock: " +Thread.currentThread().getName());
    }
  }

  public int calculateCount() {
    return count;
  }

  public static void main(String[] args) throws InterruptedException {

    CountExample countExample = new CountExample();

    Thread t1 = new Thread(()-> {

      for (int i=0; i<10; i++) {
        try {
          countExample.increment();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }, "T1");

    Thread t2 = new Thread(()-> {

      for (int i=0; i<10; i++) {
        try {
          countExample.increment();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }, "T2");

    t1.start();
    t2.start();

    t1.join(); // it blocks the main thread,it makes the main thread wait until worker threads finishes its job
    t2.join();

    System.out.println("count is: " + countExample.calculateCount());
  }
}
