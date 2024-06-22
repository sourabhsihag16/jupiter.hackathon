package com.jupiter.jupiter.hackathon.repository;

import com.jupiter.jupiter.hackathon.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TicketRepository extends JpaRepository<Ticket, String> {

}
