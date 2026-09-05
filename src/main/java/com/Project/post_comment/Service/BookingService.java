package com.Project.post_comment.Service;

import com.Project.post_comment.Entity.Seats;
import com.Project.post_comment.Repository.SeatsBookingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

  private final SeatsBookingRepository seatsBookingRepository;


  public void bookSeatsForTickets(Long seatId) throws InterruptedException {

    Thread t1 = new Thread(
      () -> {
        try {
          System.out.println(Thread.currentThread().getName() + " is attempting the book the seat");
          Seats seats = optimisticSeatBookingSystem(seatId);
          System.out.println(Thread.currentThread().getName() + " is successfully booked the seat with version:"+ seats.getVersion());
        } catch (Exception e) {
          System.out.println("failed to book the seats" + Thread.currentThread().getName());
        }
      }
    );

    Thread t2 = new Thread(
      () -> {
        try {
          System.out.println(Thread.currentThread().getName() + " is attempting the book the seat");
          Seats seats = optimisticSeatBookingSystem(seatId);
          System.out.println(Thread.currentThread().getName() + " is successfully booked the seat with version:"+ seats.getVersion());
        } catch (Exception e) {
          System.out.println("failed to book the seats" + Thread.currentThread().getName());
        }

      }
    );
    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }

  @Transactional
  private Seats optimisticSeatBookingSystem(Long seatId) {
    Seats seats = seatsBookingRepository.findById(seatId)
      .orElseThrow(() -> new RuntimeException("seats not present with this id: " + seatId));

    System.out.println(Thread.currentThread().getName() + "Fetched seat with version: " + seats.getVersion());

    // here both the threads start both read availableSeats = 1
    if (seats.isSeatBooked() && seats.getQuantity() <= 0) {
      throw new RuntimeException("Seat is already booked!!");
    }
    seats.setSeatBooked(true);
    seats.setQuantity(seats.getQuantity() -1);
    // here checks the version. version check happens every time we call the save method
    return seatsBookingRepository.save(seats); // here t2 will check the version mismatch gives Optimistic lock exception
  }
}