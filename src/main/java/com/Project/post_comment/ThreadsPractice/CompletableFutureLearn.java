package com.Project.post_comment.ThreadsPractice;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CompletableFutureLearn {

  //TODO: its a mon blocking asynchronous api introduced in java 8
  public static void main(String[] args) {

    long startTime =
      System.currentTimeMillis();

//    callGetNameAndAddress();
    callTheGetNameMethod();


    long endTime =
      System.currentTimeMillis();

    System.out.println(
      "Total Time Taken : "
        + (endTime - startTime) / 1000
        + " seconds"
    );
    System.out.println(
      "Main thread completed: "
        + Thread.currentThread().getName()
    );
  }

  static void callGetNameAndAddress() throws ExecutionException, InterruptedException {
//TODO: here both the calls run in parallel improve latency max time taken max(5,3) = 5
    CompletableFuture<String> nameFuture = CompletableFuture.supplyAsync(() -> getName());
    CompletableFuture<String> addressFuture = CompletableFuture.supplyAsync(() -> getAddress());

    CompletableFuture.allOf(nameFuture, addressFuture).join();

    log.info("Get the name {}, and address here {}", nameFuture.get(), addressFuture.get());
  }

  static void callTheGetNameMethod() {


    ExecutorService executor =
      Executors.newFixedThreadPool(2);

    CompletableFuture<String> completableFuture =
      CompletableFuture.supplyAsync(
        () -> getName(),
        executor
      ).thenApply(String::toUpperCase); // thenApply() -> transform the element
//          .thenApply(uc -> uc.length())
//            .thenApply(length -> {
//              log.info("length the future");
//
//              return length;
//            });


    completableFuture.thenAccept(name -> { //thenAccept() consume the elements

      System.out.println(
        "Received name: "
          + name
          + " Thread: "
          + Thread.currentThread().getName()
      );


      executor.shutdown();

    });

  }

  static String getAddress() {
    try {
      System.out.println("Inside the address future: " + Thread.currentThread().getState());
      Thread.sleep(5000);

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return "Asansol";
  }

  static String getName() {
    try {
      System.out.println("Inside the name future: " + Thread.currentThread().getName());
      Thread.sleep(3000);

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return "Arkadeb";
  }
}
