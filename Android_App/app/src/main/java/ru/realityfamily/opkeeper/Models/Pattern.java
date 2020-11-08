package ru.realityfamily.opkeeper.Models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class Pattern {
    private UUID id = null;
    private String patternName = null;
    private OffsetDateTime detectedStart = null;
    private OffsetDateTime detectedEnd = null;
    private Long frequency = null;
    private BigDecimal allAmount = null;
    private BigDecimal averageTransAmount = null;


    public Pattern(UUID id, String patternName, OffsetDateTime detectedStart, OffsetDateTime detectedEnd, Long frequency, BigDecimal allAmount, BigDecimal averageTransAmount) {
        this.id = id;
        this.patternName = patternName;
        this.detectedStart = detectedStart;
        this.detectedEnd = detectedEnd;
        this.frequency = frequency;
        this.allAmount = allAmount;
        this.averageTransAmount = averageTransAmount;
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

    public OffsetDateTime getDetectedStart() {
        return detectedStart;
    }

    public void setDetectedStart(OffsetDateTime detectedStart) {
        this.detectedStart = detectedStart;
    }

    public OffsetDateTime getDetectedEnd() {
        return detectedEnd;
    }

    public void setDetectedEnd(OffsetDateTime detectedEnd) {
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
}
