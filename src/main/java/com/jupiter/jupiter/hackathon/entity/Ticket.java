package com.jupiter.jupiter.hackathon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    private String ticketId;
    private String query;
    private String ticketStatus;
    private String assignedPerson;
    private String assignedPersonContact;
}
