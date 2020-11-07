package io.swagger.realityfamily.Repositories;

import io.swagger.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionsRepository extends JpaRepository<Transaction, UUID> {
}
