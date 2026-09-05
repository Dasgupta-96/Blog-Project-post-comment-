package com.Project.post_comment.ThreadsPractice;

public class ThreadWIthSleepAndNotify {

  synchronized void waitExample() {
    System.out.println(Thread.currentThread().getName()+ " is waiting......");

    try {
      wait(); // releases the lock and wait
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(Thread.currentThread().getName() + "resumed after notify..........");

  }
  synchronized void notifyTheWaitingThread() {
    System.out.println(Thread.currentThread().getName()+ " is Notifying the waiting thread.....");
    notify(); //wakes up the waiting thread
  }

  //TODO: Sleep and wait diff:
  // sleep() it causes the current thread to pause for a specified time period like 500ms
  // wait() it causes the current thread to wait until another thread invokes notify() or notifyAll()
  public static void main(String[] args) {

    ThreadWIthSleepAndNotify threadSlp = new ThreadWIthSleepAndNotify();

    Thread t1 = new Thread(()->
      threadSlp.waitExample(), "Thread-1"
    );

    Thread t2 = new Thread(() -> {

      try {
        Thread.sleep(2000);
        threadSlp.notifyTheWaitingThread();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, "Thread-2");

    t1.start();
    t2.start();
  }

}
