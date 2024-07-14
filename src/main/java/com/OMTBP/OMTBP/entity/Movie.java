package com.OMTBP.OMTBP.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Movies")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String language;
    private String genre;
}
