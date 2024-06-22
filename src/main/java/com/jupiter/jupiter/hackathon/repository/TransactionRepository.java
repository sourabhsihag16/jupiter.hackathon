package com.jupiter.jupiter.hackathon.repository;

import com.jupiter.jupiter.hackathon.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
