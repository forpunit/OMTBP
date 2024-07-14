package com.OMTBP.OMTBP.repository;

import com.OMTBP.OMTBP.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
