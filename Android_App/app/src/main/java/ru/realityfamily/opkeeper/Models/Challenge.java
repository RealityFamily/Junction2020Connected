package ru.realityfamily.opkeeper.Models;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Challenge {
    private UUID id = null;
    private ChallengeTypeEnum challengeType = null;
    private String name = null;
    private String periodStart = null;
    private String periodEnd = null;
    private Goal goal = null;


    public Challenge(UUID id, ChallengeTypeEnum challengeType, String name, String periodStart, String periodEnd, Goal goal) {
        this.id = id;
        this.challengeType = challengeType;
        this.name = name;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.goal = goal;
    }

    public Challenge() {
        this.id = UUID.randomUUID();
        this.challengeType = ChallengeTypeEnum.SurviveOrDie;
        this.name = "";
        this.periodStart = "";
        this.periodEnd = "";
        this.goal = new Goal();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ChallengeTypeEnum getChallengeType() {
        return challengeType;
    }

    public void setChallengeType(ChallengeTypeEnum challengeType) {
        this.challengeType = challengeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(String periodStart) {
        this.periodStart = periodStart;
    }

    public String getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }


    public enum ChallengeTypeEnum {
        SurviveOrDie,
        WayToGoal
    }
}
