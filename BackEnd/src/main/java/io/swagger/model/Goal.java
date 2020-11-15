package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Goal
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-07T19:30:51.910Z[GMT]")

@Entity
@Table(name = "Goals")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Goal.class)
public class Goal   {

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

  @Column(name = "description", nullable = false)
  @JsonProperty("description")
  private String description = null;

  @Column(name = "balance", nullable = false)
  @JsonProperty("balance")
  private Double balance = null;

  @Column(name = "progress", nullable = false)
  @JsonProperty("progress")
  private Double progress = null;

  @Column(name = "weightInDepositoryPipe20", nullable = false)
  @JsonProperty("weightInDepositoryPipe20")
  private Double weightInDepositoryPipe20 = null;

  //@ElementCollection
  @ManyToMany(mappedBy = "goals",cascade = CascadeType.ALL)
  @JsonProperty("patterns")
 // @JsonManagedReference
  private List<Pattern> patterns = null;

  @Type(type="org.hibernate.type.PostgresUUIDType")
  @ManyToOne
  @JoinColumn(name = "Clients_id")
  //@JsonIgnore
  private Client client = null;

  @Type(type="org.hibernate.type.PostgresUUIDType")
  @OneToOne
  @JoinColumn(name = "Challenges_id")
  @JsonProperty("challenge")
  @JsonIgnoreProperties("goal")
  @NotFound(action = NotFoundAction.IGNORE)
  private Challenge challenge = null;

  public Goal id(UUID id) {
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

  public Goal name(String name) {
    this.name = name;
    return this;
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

  public Goal description(String description) {
    this.description = description;
    return this;
  }

  public Goal(UUID id, String name, String description, Double balance, Double progress, Double weightInDepositoryPipe20, List<Pattern> patterns, Client client) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.balance = balance;
    this.progress = progress;
    this.weightInDepositoryPipe20 = weightInDepositoryPipe20;
    this.patterns = patterns;
    this.client = client;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Goal balance(Double balance) {
    this.balance = balance;
    return this;
  }

  /**
   * Get balance
   * @return balance
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public Goal progress(Double progress) {
    this.progress = progress;
    return this;
  }

  /**
   * Get progress
   * @return progress
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Double getProgress() {
    return progress;
  }

  public void setProgress(Double progress) {
    this.progress = progress;
  }

  public Goal weightInDepositoryPipe20(Double weightInDepositoryPipe20) {
    this.weightInDepositoryPipe20 = weightInDepositoryPipe20;
    return this;
  }

  /**
   * Get weightInDepositoryPipe20
   * @return weightInDepositoryPipe20
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Double getWeightInDepositoryPipe20() {
    return weightInDepositoryPipe20;
  }

  public void setWeightInDepositoryPipe20(Double weightInDepositoryPipe20) {
    this.weightInDepositoryPipe20 = weightInDepositoryPipe20;
  }

  public Goal patterns(List<Pattern> patterns) {
    this.patterns = patterns;
    return this;
  }

  public Goal addPatternsItem(Pattern patternsItem) {
    if (this.patterns == null) {
      this.patterns = new ArrayList<Pattern>();
    }
    this.patterns.add(patternsItem);
    return this;
  }

  /**
   * Get patterns
   * @return patterns
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Pattern> getPatterns() {
    return patterns;
  }

  public void setPatterns(List<Pattern> patterns) {
    this.patterns = patterns;
  }

  public Goal user(Client client) {
    this.client = client;
    return this;
  }

  /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  /**
   * Get challenge
   * @return challenge
   **/
  @ApiModelProperty(value = "")

  @Valid
  public Challenge getChallenge() {
    return challenge;
  }

  public void setChallenge(Challenge challenge) {
    this.challenge = challenge;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Goal goal = (Goal) o;
    return Objects.equals(this.id, goal.id) &&
        Objects.equals(this.name, goal.name) &&
        Objects.equals(this.description, goal.description) &&
        Objects.equals(this.balance, goal.balance) &&
        Objects.equals(this.progress, goal.progress) &&
        Objects.equals(this.weightInDepositoryPipe20, goal.weightInDepositoryPipe20) &&
        Objects.equals(this.patterns, goal.patterns) &&
        Objects.equals(this.client, goal.client) &&
            Objects.equals(this.challenge, goal.challenge);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, balance, progress, weightInDepositoryPipe20, patterns, client, challenge);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Goal {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    weightInDepositoryPipe20: ").append(toIndentedString(weightInDepositoryPipe20)).append("\n");
    sb.append("    patterns: ").append(toIndentedString(patterns)).append("\n");
    sb.append("    user: ").append(toIndentedString(client)).append("\n");
    sb.append("    challenge: ").append(toIndentedString(challenge)).append("\n");
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

  public Goal(String name, String description, Double balance, Double progress, Double weightInDepositoryPipe20, List<Pattern> patterns, Client client, Challenge challenge) {
    this.name = name;
    this.description = description;
    this.balance = balance;
    this.progress = progress;
    this.weightInDepositoryPipe20 = weightInDepositoryPipe20;
    this.patterns = patterns;
    this.client = client;
    this.challenge = challenge;
  }

  public Goal() {
    this.name = "";
    this.description = "";
    this.balance = 0.0;
    this.progress = 0.0;
    this.weightInDepositoryPipe20 = 0.0;
    this.patterns = new ArrayList<>();
    this.client = null;
    this.challenge = null;
  }
}
