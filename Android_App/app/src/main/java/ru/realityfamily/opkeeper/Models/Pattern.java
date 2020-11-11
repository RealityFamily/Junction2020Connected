package ru.realityfamily.opkeeper.Models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public class Pattern {
    private UUID id = null;
    private String patternName = null;
    private String detectedStart = null;
    private String detectedEnd = null;
    private Long frequency = null;
    private BigDecimal allAmount = null;
    private BigDecimal averageTransAmount = null;
    private PatternTypeEnum patternType = null;
    private List<Goal> goal = null;
    private List<Transaction> transactions = null;


    public Pattern(UUID id, String patternName, String detectedStart, String detectedEnd,
                   Long frequency, BigDecimal allAmount, BigDecimal averageTransAmount,
                   PatternTypeEnum patternType, List<Goal> goal, List<Transaction> transactions) {
        this.id = id;
        this.patternName = patternName;
        this.detectedStart = detectedStart;
        this.detectedEnd = detectedEnd;
        this.frequency = frequency;
        this.allAmount = allAmount;
        this.averageTransAmount = averageTransAmount;
        this.patternType = patternType;
        this.goal = goal;
        this.transactions = transactions;
    }

    public Pattern() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }

    public String getDetectedStart() {
        return detectedStart;
    }

    public void setDetectedStart(String detectedStart) {
        this.detectedStart = detectedStart;
    }

    public String getDetectedEnd() {
        return detectedEnd;
    }

    public void setDetectedEnd(String detectedEnd) {
        this.detectedEnd = detectedEnd;
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public BigDecimal getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(BigDecimal allAmount) {
        this.allAmount = allAmount;
    }

    public BigDecimal getAverageTransAmount() {
        return averageTransAmount;
    }

    public void setAverageTransAmount(BigDecimal averageTransAmount) {
        this.averageTransAmount = averageTransAmount;
    }

    public PatternTypeEnum getPatternType() {
        return patternType;
    }

    public void setPatternType(PatternTypeEnum patternType) {
        this.patternType = patternType;
    }

    public List<Goal> getGoal() {
        return goal;
    }

    public void setGoal(List<Goal> goal) {
        this.goal = goal;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public enum PatternTypeEnum {
        Obligatory,
        Leisure
    }
}
