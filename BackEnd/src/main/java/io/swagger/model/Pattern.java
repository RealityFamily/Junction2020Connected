package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Goal;
import io.swagger.model.Transaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Pattern
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-07T19:30:51.910Z[GMT]")

@Entity
@Table(name = "Patterns")
public class Pattern   {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  @JsonProperty("id")
  private UUID id = null;

  @Column(name = "patternName", nullable = false)
  @JsonProperty("patternName")
  private String patternName = null;

  @Column(name = "detectedStart", nullable = false)
  @JsonProperty("detectedStart")
  private String detectedStart = null;

  @Column(name = "detectedEnd", nullable = false)
  @JsonProperty("detectedEnd")
  private String detectedEnd = null;

  @Column(name = "frequency", nullable = false)
  @JsonProperty("frequency")
  private Long frequency = null;

  @Column(name = "allAmount", nullable = false)
  @JsonProperty("allAmount")
  private BigDecimal allAmount = null;

  @Column(name = "averageTransAmount", nullable = false)
  @JsonProperty("averageTransAmount")
  private BigDecimal averageTransAmount = null;

  /**
   * Gets or Sets patternType
   */
  public enum PatternTypeEnum {
    OBLIGATORY("Obligatory"),
    
    LEISURE("Leisure");

    private String value;

    PatternTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PatternTypeEnum fromValue(String text) {
      for (PatternTypeEnum b : PatternTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @Column(name = "patternType", nullable = false)
  @JsonProperty("patternType")
  private PatternTypeEnum patternType = null;

  @Type(type="org.hibernate.type.PostgresUUIDType")
  @ManyToMany(mappedBy = "patterns",cascade = CascadeType.ALL)
  @JsonProperty("goals")
  private List<Goal> goals = null;

  @Column(name = "detectedStart", nullable = false)
  @ElementCollection
  @OneToMany(mappedBy = "pattern")
  @JsonProperty("transactions")
  @Valid
  private List<Transaction> transactions = null;

  public Pattern id(UUID id) {
    this.id = id;
    return this;
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

  public Pattern detectedStart(String detectedStart) {
    this.detectedStart = detectedStart;
    return this;
  }

  /**
   * Get patternName
   * @return patternName
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
  public String getPatternName() {
    return patternName;
  }

  public void setPatternName(String patternName) {
    this.patternName = patternName;
  }

  public Pattern patternName(String patternName) {
    this.patternName = patternName;
    return this;
  }

  /**
   * Get detectedStart
   * @return detectedStart
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public String getDetectedStart() {
    return detectedStart;
  }

  public void setDetectedStart(String detectedStart) {
    this.detectedStart = detectedStart;
  }

  public Pattern detectedEnd(String detectedEnd) {
    this.detectedEnd = detectedEnd;
    return this;
  }

  /**
   * Get detectedEnd
   * @return detectedEnd
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public String getDetectedEnd() {
    return detectedEnd;
  }

  public void setDetectedEnd(String detectedEnd) {
    this.detectedEnd = detectedEnd;
  }

  public Pattern frequency(Long frequency) {
    this.frequency = frequency;
    return this;
  }

  /**
   * Get frequency
   * @return frequency
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Long getFrequency() {
    return frequency;
  }

  public void setFrequency(Long frequency) {
    this.frequency = frequency;
  }

  public Pattern allAmount(BigDecimal allAmount) {
    this.allAmount = allAmount;
    return this;
  }

  /**
   * Get allAmount
   * @return allAmount
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public BigDecimal getAllAmount() {
    return allAmount;
  }

  public void setAllAmount(BigDecimal allAmount) {
    this.allAmount = allAmount;
  }

  public Pattern averageTransAmount(BigDecimal averageTransAmount) {
    this.averageTransAmount = averageTransAmount;
    return this;
  }

  /**
   * Get averageTransAmount
   * @return averageTransAmount
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public BigDecimal getAverageTransAmount() {
    return averageTransAmount;
  }

  public void setAverageTransAmount(BigDecimal averageTransAmount) {
    this.averageTransAmount = averageTransAmount;
  }

  public Pattern patternType(PatternTypeEnum patternType) {
    this.patternType = patternType;
    return this;
  }

  /**
   * Get patternType
   * @return patternType
  **/
  @ApiModelProperty(value = "")
  
    public PatternTypeEnum getPatternType() {
    return patternType;
  }

  public void setPatternType(PatternTypeEnum patternType) {
    this.patternType = patternType;
  }

  public Pattern goal(List<Goal> goals) {
    this.goals = goals;
    return this;
  }

  /**
   * Get goal
   * @return goal
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public List<Goal> getGoal() {
    return goals;
  }

  public void setGoal(List<Goal> goals) {
    this.goals = goals;
  }

  public Pattern transactions(List<Transaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  public Pattern addTransactionsItem(Transaction transactionsItem) {
    if (this.transactions == null) {
      this.transactions = new ArrayList<Transaction>();
    }
    this.transactions.add(transactionsItem);
    return this;
  }

  /**
   * Get transactions
   * @return transactions
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pattern pattern = (Pattern) o;
    return Objects.equals(this.id, pattern.id) &&
        Objects.equals(this.detectedStart, pattern.detectedStart) &&
        Objects.equals(this.detectedEnd, pattern.detectedEnd) &&
        Objects.equals(this.frequency, pattern.frequency) &&
        Objects.equals(this.allAmount, pattern.allAmount) &&
        Objects.equals(this.averageTransAmount, pattern.averageTransAmount) &&
        Objects.equals(this.patternType, pattern.patternType) &&
        Objects.equals(this.goals, pattern.goals) &&
        Objects.equals(this.transactions, pattern.transactions) &&
            Objects.equals(this.patternName, pattern.patternName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, detectedStart, detectedEnd, frequency, allAmount, averageTransAmount, patternType, goals, transactions, patternName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pattern {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    detectedStart: ").append(toIndentedString(detectedStart)).append("\n");
    sb.append("    detectedEnd: ").append(toIndentedString(detectedEnd)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    allAmount: ").append(toIndentedString(allAmount)).append("\n");
    sb.append("    averageTransAmount: ").append(toIndentedString(averageTransAmount)).append("\n");
    sb.append("    patternType: ").append(toIndentedString(patternType)).append("\n");
    sb.append("    goal: ").append(toIndentedString(goals)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
    sb.append("    patternName: ").append(toIndentedString(patternName)).append("\n");
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

  public Pattern() {
  }

  public Pattern(String detectedStart, String detectedEnd, Long frequency, BigDecimal allAmount,
                 BigDecimal averageTransAmount, PatternTypeEnum patternType, List<Goal> goals,
                 List<Transaction> transactions, String patternName) {
    this.detectedStart = detectedStart;
    this.detectedEnd = detectedEnd;
    this.frequency = frequency;
    this.allAmount = allAmount;
    this.averageTransAmount = averageTransAmount;
    this.patternType = patternType;
    this.goals = goals;
    this.transactions = transactions;
    this.patternName = patternName;
  }
}
