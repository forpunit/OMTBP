package com.OMTBP.OMTBP.service;

import com.OMTBP.OMTBP.entity.*;
import com.OMTBP.OMTBP.repository.AudiRepository;
import com.OMTBP.OMTBP.repository.MovieRepository;
import com.OMTBP.OMTBP.repository.ShowRepository;
import com.OMTBP.OMTBP.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlatformImpl implements Platform{
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    AudiRepository audiRepository;
    @Autowired
    ShowRepository showRepository;
    @Override
    public Long onBoardTheatre(String name, String city) {
        Theatre theatre = new Theatre();
        theatre.setCity(city);
        theatre.setName(name);
        Theatre savedTheatre = theatreRepository.save(theatre);
        return savedTheatre.getId();
    }

    @Override
    public List<Theatre> theatresByCity(String city) {
        return theatreRepository.findByCity(city);
    }


    @Override
    public List<Audi> onBoardAudis(List<Audi> audis) {
        return audiRepository.saveAll(audis);
    }

    @Override
    public List<Show> onBoardShows(List<Show> shows) {
        //TODO add/onboard all tickets for the show
        return showRepository.saveAll(shows);
    }

    @Override
    public List<Movie> onBoardMovies(List<Movie> movies) {
        return movieRepository.saveAll(movies);
    }

    @Override
    public List<Long> onBoardTickets(List<Ticket> tickets) {
        //TODO adding tickets based on show added
        return null;
    }

    @Override
    public Show updateShow(Show show) {
        return showRepository.save(show);
    }

    @Override
    public void deleteShow(Long showId) {
        showRepository.deleteById(showId);
    }


    @Override
    public List<Show> listAllShowsByMovieIdAndCity(Long movieId, String city) {
        return showRepository.findByMovieIdAndCity(movieId, city);
    }


}
