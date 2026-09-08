package com.Project.post_comment.ThreadsPractice;

public class TableOf5UsingTraditional {

  public static void main(String[] args) throws InterruptedException {

    Thread t1 = new Thread(()-> {

      for (int i =1; i<=3; i++) {

        System.out.println(Thread.currentThread().getName() +" : " + 5*i);
      }

    }, "Thread-1");

    Thread t2 = new Thread(()-> {

      for (int i =4; i<=6; i++) {

        System.out.println(Thread.currentThread().getName() + " : " + 5*i);
      }

    }, "Thread-2");

    Thread t3 = new Thread(()-> {

      for (int i =7; i<=10; i++) {

        System.out.println(Thread.currentThread().getName() +" : " + 5*i);
      }

    }, "Thread-3");

    t1.start();
    t1.join(); // it makes the main thread wait until t1 finishes before starting t2, maintain ordering concurrancy is lost here
    t2.start();
    t2.join();
    t3.start();
    t3.join();
  }
}
