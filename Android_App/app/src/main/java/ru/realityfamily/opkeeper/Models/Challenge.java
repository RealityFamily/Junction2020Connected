package ru.realityfamily.opkeeper.Models;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Challenge {
    private UUID id = null;

    public enum ChallengeTypeEnum {
        SURVIVEORDIE("SurviveOrDie"),

        WAYTOGOAL("WayToGoal");

        private String value;

        ChallengeTypeEnum(String value) {
            this.value = value;
        }
    }
    private ChallengeTypeEnum challengeType = null;

    private String name = null;
    private OffsetDateTime periodStart = null;
    private OffsetDateTime periodEnd = null;
    private Goal goal = null;


    public Challenge(UUID id, ChallengeTypeEnum challengeType, String name, OffsetDateTime periodStart, OffsetDateTime periodEnd, Goal goal) {
        this.id = id;
        this.challengeType = challengeType;
        this.name = name;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.goal = goal;
    }

    public Challenge() {
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

    public OffsetDateTime getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(OffsetDateTime periodStart) {
        this.periodStart = periodStart;
    }

    public OffsetDateTime getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(OffsetDateTime periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
