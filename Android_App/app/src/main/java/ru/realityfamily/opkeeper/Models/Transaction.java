package ru.realityfamily.opkeeper.Models;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Transaction {

    private UUID id = null;
    private OffsetDateTime timeStamp = null;
    private Double amount = null;
    private Double balance = null;
    private String counterCompanyName = null;

    public Transaction() {
    }

    public Transaction(UUID id, OffsetDateTime timeStamp, Double amount, Double balance, String counterCompanyName) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.amount = amount;
        this.balance = balance;
        this.counterCompanyName = counterCompanyName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OffsetDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(OffsetDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCounterCompanyName() {
        return counterCompanyName;
    }

    public void setCounterCompanyName(String counterCompanyName) {
        this.counterCompanyName = counterCompanyName;
    }
}
