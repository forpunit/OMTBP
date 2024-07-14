package com.OMTBP.OMTBP.service;

import com.OMTBP.OMTBP.entity.*;

import java.util.List;

public interface Platform {

    public Long onBoardTheatre(String name, String city);

    public List<Theatre> theatresByCity(String city);
    public List<Audi> onBoardAudis(List<Audi> Audis);

    public List<Show> onBoardShows(List<Show> shows);

    public List<Movie> onBoardMovies(List<Movie> movies);

    public List<Long> onBoardTickets(List<Ticket> tickets);

    public Show updateShow(Show show);

    public void deleteShow(Long showId);

    public List<Show> listAllShowsByMovieIdAndCity(Long movieId, String city);


}
