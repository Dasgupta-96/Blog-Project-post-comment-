package com.Project.post_comment.ThreadsPractice.ThreadLockOperations;

import java.util.concurrent.locks.ReentrantLock;

public class Count {

  private int count = 0;

  //TODO: More advanced alternative to synchronized.
  ReentrantLock reentrantLock = new ReentrantLock();

  public void increment() throws InterruptedException {

    System.out.println("Entering into lock: " + Thread.currentThread().getName());

    reentrantLock.lock();

    System.out.println(Thread.currentThread().getName() + " Acquired a lock");
    try {

      Thread.sleep(5000);
      count++;
    }
    finally { //if we don't use finally if exception occurs unlock() never called other thread wait forever
      System.out.println(
        Thread.currentThread().getName()
          + " releasing lock"
      );
      reentrantLock.unlock();
    }


  }

  public static void main(String[] args) throws InterruptedException {

    Count count = new Count();

    Thread t1 = new Thread(() -> {
      try {
        for (int i = 0; i < 10; i++) {
          count.increment();
        }

      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    }, "Thread-1");

    Thread t2 = new Thread(() -> {
      try {
        for (int i = 0; i < 10; i++) {
          count.increment();
        }

      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    }, "Thread-2");

    t1.start();
    t2.start();

    t1.join();
    t2.join();
  }
}
