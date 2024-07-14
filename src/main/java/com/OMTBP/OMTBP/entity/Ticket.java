package com.OMTBP.OMTBP.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tickets")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer showId;
    private Integer seatNum;
    private String type;
    private String status;
}
