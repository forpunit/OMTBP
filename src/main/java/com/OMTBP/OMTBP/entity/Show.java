package com.OMTBP.OMTBP.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shows")
@Data
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long movieId;

    private LocalTime startTime;

    private LocalDate date;

    private Long theatreId;

    private Long hallId;

    private String city;

}
