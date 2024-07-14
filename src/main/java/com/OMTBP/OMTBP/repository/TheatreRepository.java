package com.OMTBP.OMTBP.repository;

import com.OMTBP.OMTBP.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    @Query("Select t from Theatre t where t.city = ?1")
    public List<Theatre> findByCity(String city);
}
