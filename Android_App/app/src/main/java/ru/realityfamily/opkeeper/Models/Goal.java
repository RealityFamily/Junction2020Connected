package ru.realityfamily.opkeeper.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Goal {
    private UUID id = null;
    private String name = null;
    private String description = null;
    private Double balance = null;
    private Double progress = null;
    private Double weightInDepositoryPipe20 = null;
    private List<Pattern> patterns = null;


    public Goal(UUID id, String name, String description, Double balance, Double progress, Double weightInDepositoryPipe20, List<Pattern> patterns) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.balance = balance;
        this.progress = progress;
        this.weightInDepositoryPipe20 = weightInDepositoryPipe20;
        this.patterns = patterns;
    }

    public Goal() {
        this.id = UUID.randomUUID();
        this.name = "";
        this.description = "";
        this.balance = 0.0;
        this.progress = 0.0;
        this.weightInDepositoryPipe20 = 0.0;
        this.patterns = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public Double getWeightInDepositoryPipe20() {
        return weightInDepositoryPipe20;
    }

    public void setWeightInDepositoryPipe20(Double weightInDepositoryPipe20) {
        this.weightInDepositoryPipe20 = weightInDepositoryPipe20;
    }

    public List<Pattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<Pattern> patterns) {
        this.patterns = patterns;
    }
}
