package com.jupiter.jupiter.hackathon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    private String transactionId;
    private String receiverId;
    private String senderId;
    private Double transactionAmount;
    private String transactionStatus;
    private Timestamp timestamp;
}
