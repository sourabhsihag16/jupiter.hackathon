package com.jupiter.jupiter.hackathon.controller;

import com.jupiter.jupiter.hackathon.entity.Transaction;
import com.jupiter.jupiter.hackathon.repository.TransactionRepository;
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
@RequestMapping("/transaction")
public class TransactionCrud {

    @Autowired private TransactionRepository transactionRepository;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Transaction transaction){
        transactionRepository.save(transaction);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getTransaction/{id}")
    public Transaction getTransaction(@PathVariable String id){
        return transactionRepository.findById(id).get();
    }

    @DeleteMapping("/deleteTransaction/{id}")
    public String deleteTransaction(@PathVariable String id){
        transactionRepository.deleteById(id);
        return "Transaction deleted "+id;
    }


}
