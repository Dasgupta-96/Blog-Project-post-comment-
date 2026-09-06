package com.Project.post_comment.Entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
  public class Seats {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String movieName;

  private boolean isSeatBooked;

  private int quantity;

  @Version
  private int version;
}
