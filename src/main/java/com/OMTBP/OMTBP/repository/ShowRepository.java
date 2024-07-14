package com.OMTBP.OMTBP.repository;

import com.OMTBP.OMTBP.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query("Select s from Show s where s.movieId = ?1 and s.city = ?2")
    public List<Show> findByMovieIdAndCity(Long movieId, String City);

    /*@Query("Select s from Show s where s.theatreId = ?1")
    public List<Show> findByTheatreId(Long theatreId);*/
}
