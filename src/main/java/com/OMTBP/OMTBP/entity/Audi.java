package com.OMTBP.OMTBP.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "audis")
@Data
public class Audi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer theatreId;
    private String name;
    private String layout;
    private String type;
    private Integer numberOfSeats;
}
