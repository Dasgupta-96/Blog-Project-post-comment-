package com.Project.post_comment.Controller;

import com.Project.post_comment.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class TicketBookingController {

  private final BookingService bookingService;
  @GetMapping("/seats/{seatId}")
  public ResponseEntity<?> bookSeats(@PathVariable Long seatId) throws InterruptedException {

    bookingService.bookSeatsForTickets(seatId);

    return ResponseEntity.ok("Seats booked!!");

  }

}
