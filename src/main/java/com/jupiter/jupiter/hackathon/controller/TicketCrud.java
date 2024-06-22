package com.jupiter.jupiter.hackathon.controller;

import com.jupiter.jupiter.hackathon.entity.Ticket;
import com.jupiter.jupiter.hackathon.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketCrud {

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Ticket ticket){
        ticketRepository.save(ticket);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getTicket/{id}")
    public Ticket getTicket(@PathVariable String id){
        return ticketRepository.findById(id).get();
    }

    @DeleteMapping("/deleteTicket/{id}")
    public String deleteTicket(@PathVariable String id){
        ticketRepository.deleteById(id);
        return "Ticket deleted "+id;
    }


}

