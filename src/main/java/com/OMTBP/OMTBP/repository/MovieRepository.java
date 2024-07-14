package com.OMTBP.OMTBP.repository;

import com.OMTBP.OMTBP.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
