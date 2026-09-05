package com.Project.post_comment;


import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    private List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver observer) {
      observers.add(observer);
    }

    public void completePayment() {
      System.out.println("Payment completed");
      notifyObservers("Payment Successful"); // here processPayment doesn't know who are those observers, how many are they, purpose
    }

    private void notifyObservers(String message) {
      for (NotificationObserver observer : observers) {
        observer.update(message);
      }
    }
  }
