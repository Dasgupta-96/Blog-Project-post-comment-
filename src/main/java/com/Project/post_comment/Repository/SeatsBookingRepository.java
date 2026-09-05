package com.Project.post_comment.Repository;

import com.Project.post_comment.Entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsBookingRepository extends JpaRepository<Seats, Long> {
}
