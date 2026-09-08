package com.Project.post_comment.ThreadsPractice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TableOf5ExecutorService {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ExecutorService executor = Executors.newFixedThreadPool(3);

    for (int i = 1; i <= 10; i++) {

      int number = i;

      Future<?> future = executor.submit(() ->
          System.out.println(
            Thread.currentThread().getName()
//            + " : 5 x " + number
              + " = " + (5 * number)
          )
      );
      //TODO: if ordering is more important than concurrency
      future.get();
    }

    executor.shutdown();
  }
}
