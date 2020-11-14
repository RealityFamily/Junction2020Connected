package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.*;
import com.sun.istack.internal.Nullable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Goal;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Challenge
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-07T19:30:51.910Z[GMT]")

@Entity
@Table(name = "Challenges")
public class Challenge {


  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  @JsonProperty("id")
  private UUID id = null;

  @Column(name = "name", nullable = false)
  @JsonProperty("name")
  private String name = null;

  @Column(name = "periodStart", nullable = false)
  @JsonProperty("periodStart")
  private String periodStart = null;

  @Column(name = "periodEnd", nullable = false)
  @JsonProperty("periodEnd")
  @DateTimeFormat
  private String periodEnd = null;

  @Type(type="org.hibernate.type.PostgresUUIDType")
  @OneToOne(mappedBy = "challenge", cascade = CascadeType.ALL)
  @JsonProperty("goal")
  @JsonIgnoreProperties("challenge")
  private Goal goal = null;

  public Challenge id(UUID id) {
    this.id = id;
    return this;
  }

  public Challenge() {
  }

  public Challenge(String name, String periodStart, String periodEnd, Goal goal) {
    this.name = name;
    this.periodStart = periodStart;
    this.periodEnd = periodEnd;
    this.goal = goal;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Challenge periodStart(String periodStart) {
    this.periodStart = periodStart;
    return this;
  }

  /**
   * Get periodStart
   * @return periodStart
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public String getPeriodStart() {
    return periodStart;
  }

  public void setPeriodStart(String periodStart) {
    this.periodStart = periodStart;
  }

  public Challenge periodEnd(String periodEnd) {
    this.periodEnd = periodEnd;
    return this;
  }

  /**
   * Get periodEnd
   * @return periodEnd
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public String getPeriodEnd() {
    return periodEnd;
  }

  public void setPeriodEnd(String periodEnd) {
    this.periodEnd = periodEnd;
  }

  public Challenge goal(Goal goal) {
    this.goal = goal;
    return this;
  }

  /**
   * Get goal
   * @return goal
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public Goal getGoal() {
    return goal;
  }

  public void setGoal(Goal goal) {
    this.goal = goal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Challenge challenge = (Challenge) o;
    return Objects.equals(this.id, challenge.id) &&
        Objects.equals(this.name, challenge.name) &&
        Objects.equals(this.periodStart, challenge.periodStart) &&
        Objects.equals(this.periodEnd, challenge.periodEnd) &&
        Objects.equals(this.goal, challenge.goal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, periodStart, periodEnd, goal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Challenge {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    periodStart: ").append(toIndentedString(periodStart)).append("\n");
    sb.append("    periodEnd: ").append(toIndentedString(periodEnd)).append("\n");
    sb.append("    goal: ").append(toIndentedString(goal)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
