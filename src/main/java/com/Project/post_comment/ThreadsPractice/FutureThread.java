package com.Project.post_comment.ThreadsPractice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureThread {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    //TODO: Future represents a result of an asynchronous computation that will be available in the future.
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    Future<String> future = executorService.submit(() -> {
      try {
        System.out.println("Inside the future thread: "+ Thread.currentThread().getName());
        Thread.sleep(3000);
        return "payment completed";

      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    });
    System.out.println("Doing other work..........." + Thread.currentThread().getName());

    String result = future.get(); // it blocks the main thread

    System.out.println(result);

    System.out.println("After future thread: "+ Thread.currentThread().getName());
    executorService.shutdown();
    //TODO: purpose of shutdown: Don't accept any new tasks complete the already submitted tasks
    // and terminate those worker threads cz they keep the jvm alive so keeps the app running

  }
}
