package com.OMTBP.OMTBP.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Show {
    private Long movieId;

    private LocalTime startTime;

    private LocalDate date;

    private Long theatreId;

    private Long hallId;

    private String City;
}
