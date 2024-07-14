package com.OMTBP.OMTBP.controller;

import com.OMTBP.OMTBP.entity.Audi;
import com.OMTBP.OMTBP.entity.Movie;
import com.OMTBP.OMTBP.entity.Show;
import com.OMTBP.OMTBP.entity.Theatre;
import com.OMTBP.OMTBP.model.Hall;
import com.OMTBP.OMTBP.service.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/platform")
public class PlatformController {
    @Autowired
    Platform platform;
    @PostMapping("/addTheatre")
    public ResponseEntity<Long> onBoardTheatre(@RequestBody Theatre theatre){
        Long id = platform.onBoardTheatre(theatre.getName(), theatre.getCity());
        ResponseEntity<Long> response = new ResponseEntity<>(id, HttpStatusCode.valueOf(200));
        return response;
    }

    @GetMapping("/findTheatre")
    public ResponseEntity<List<Theatre>> findTheatresByCityName(@RequestParam String city) {
        List<Theatre> theatreList = platform.theatresByCity(city);
        ResponseEntity<List<Theatre>> response = new ResponseEntity<>(theatreList, HttpStatusCode.valueOf(200));
        return response;
    }

    @PostMapping("/addMovies")
    public ResponseEntity<List<Movie>> onBoardMovies(@RequestBody List<com.OMTBP.OMTBP.model.Movie> movies){
        List<Movie> movieList = movies.stream()
                .map(movie -> {
                    Movie movie1 = new Movie();
                    movie1.setGenre(movie.getGenre());
                    movie1.setName(movie.getName());
                    movie1.setLanguage(movie.getLanguage());
                    return movie1;
                }).collect(Collectors.toList());

        ResponseEntity<List<Movie>> response = new ResponseEntity<>(platform.onBoardMovies(movieList), HttpStatusCode.valueOf(200));
        return response;
    }

    @PostMapping("/addHalls")
    public ResponseEntity<List<Audi>> onBoardHalls(@RequestBody List<Hall> halls){
        List<Audi> audiList = halls.stream()
                .map(hall -> {
                    Audi audi = new Audi();
                    audi.setName(hall.getName());
                    audi.setType(hall.getType());
                    audi.setLayout(hall.getLayout());
                    audi.setTheatreId(hall.getTheatreId());
                    audi.setNumberOfSeats(hall.getNumberOfSeats());
                    return audi;
                }).collect(Collectors.toList());

        ResponseEntity<List<Audi>> response = new ResponseEntity<>(platform.onBoardAudis(audiList), HttpStatusCode.valueOf(200));
        return response;
    }

    @PostMapping("/addShows")
    public ResponseEntity<List<Show>> addShows(@RequestBody List<com.OMTBP.OMTBP.model.Show> shows) {
        List<Show> showList = shows.stream().
                map(show -> {
                    Show show1 = new Show();
                    show1.setDate(show.getDate());
                    show1.setTheatreId(show.getTheatreId());
                    show1.setHallId(show.getHallId());
                    show1.setMovieId(show.getMovieId());
                    show1.setStartTime(show.getStartTime());
                    show1.setCity(show.getCity());
                    return show1;
                }).collect(Collectors.toList());

        List<Show> showList1 = platform.onBoardShows(showList);
        return new ResponseEntity<>(showList1, HttpStatusCode.valueOf(200));
    }
    @PutMapping("/updateShow/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Long id,@RequestBody Show show) {
        Show show1 = new Show();
        show1.setId(id);
        show1.setHallId(show.getHallId());
        show1.setDate(show.getDate());
        show1.setCity(show.getCity());
        show1.setTheatreId(show.getTheatreId());
        show1.setMovieId(show.getMovieId());
        show1.setStartTime(show.getStartTime());
        return new ResponseEntity<>(platform.updateShow(show1), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/showList")
    public ResponseEntity<List<Show>> getShowsByMovieAndCity(@RequestParam Long movieId, @RequestParam String city) {

        return new ResponseEntity<>(platform.listAllShowsByMovieIdAndCity(movieId, city), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/show/{id}")
    public void deleteShowById(@PathVariable Long id) {
        platform.deleteShow(id);
    }




}
