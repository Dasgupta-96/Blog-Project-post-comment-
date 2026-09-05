package com.Project.post_comment.ThreadsPractice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableThreads implements Callable<String> {

  //TODO: Callable mostly works with the Executor framework
  private String name;

  public CallableThreads(String name) {
    this.name = name;
  }
  public static void main(String[] args) throws ExecutionException, InterruptedException {

    //TODO: Create Executors service with fixed thread pool(create, manage threads on my behalf)
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CallableThreads callableThreads1 = new CallableThreads("Thread-1");
    CallableThreads callableThreads2= new CallableThreads("Thread-2");

    //TODO: Submit the callable tasks to executor to get future object
    Future<String> future1 = executorService.submit(callableThreads1);
    Future<String> future2 = executorService.submit(callableThreads2);

    //TODO: Get the result from the future object

    System.out.println("Result from the first task: ");
    System.out.println(future1.get()); //it blocks the calling thread
    System.out.println("Result from the second task: ");
    System.out.println(future2.get());

  }
  @Override
  public String call() throws Exception {

    StringBuilder result = new StringBuilder();

    for (int i =0; i<5; i++) {

      result.append("Callable: ").append(name)
        .append(" is running ").append(i).append("\n");

      Thread.sleep(500);
    }
    return result.toString();
  }
}
