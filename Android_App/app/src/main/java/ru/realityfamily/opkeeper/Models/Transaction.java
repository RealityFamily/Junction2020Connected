package ru.realityfamily.opkeeper.Models;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Transaction {

    private UUID id = null;
    private String timeStamp = null;
    private Double amount = null;
    private Double balance = null;
    private String counterCompanyName = null;

    public Transaction() {
    }

    public Transaction(UUID id, String timeStamp, Double amount, Double balance, String counterCompanyName) {
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

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
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
