package com.OMTBP.OMTBP.model;

import lombok.Data;

@Data
public class Hall {
    private Integer theatreId;
    private String name;
    private String layout;
    private String type;
    private Integer numberOfSeats;
}
