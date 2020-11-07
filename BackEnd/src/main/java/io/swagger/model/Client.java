package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-07T19:30:51.910Z[GMT]")

@Entity
@Table(name = "Clients")
public class Client {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  @JsonProperty("id")
  private UUID id = null;

  @Column(name = "accountIBAN", nullable = false)
  @JsonProperty("accountIBAN")
  private String accountIBAN = null;

  @Column(name = "accountName", nullable = false)
  @JsonProperty("accountName")
  private String accountName = null;

  @Column(name = "accountAuth", nullable = false)
  @JsonProperty("accountAuth")
  private String accountAuth = null;

  @Column(name = "balance", nullable = false)
  @JsonProperty("balance")
  private Double balance = null;

  @Column(name = "instagram", nullable = false)
  @JsonProperty("instagram")
  private String instagram = null;

  @Column(name = "goals", nullable = false)
  @ElementCollection
  @OneToMany(mappedBy = "client")
  @JsonProperty("goals")
  @Valid
  private List<Goal> goals = null;

  public Client id(UUID id) {
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

  public Client accountIBAN(String accountIBAN) {
    this.accountIBAN = accountIBAN;
    return this;
  }

  /**
   * Get accountIBAN
   * @return accountIBAN
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public String getAccountIBAN() {
    return accountIBAN;
  }

  public void setAccountIBAN(String accountIBAN) {
    this.accountIBAN = accountIBAN;
  }

  public Client accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

  /**
   * Get accountName
   * @return accountName
  **/
  @ApiModelProperty(value = "")
  
    public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public Client accountAuth(String accountAuth) {
    this.accountAuth = accountAuth;
    return this;
  }

  /**
   * Get accountAuth
   * @return accountAuth
  **/
  @ApiModelProperty(value = "")
  
    public String getAccountAuth() {
    return accountAuth;
  }

  public void setAccountAuth(String accountAuth) {
    this.accountAuth = accountAuth;
  }

  public Client balance(Double balance) {
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

  public Client instagram(String instagram) {
    this.instagram = instagram;
    return this;
  }

  /**
   * Get instagram
   * @return instagram
  **/
  @ApiModelProperty(example = "https://www.instagram.com/worldverwe", value = "")
  
    public String getInstagram() {
    return instagram;
  }

  public void setInstagram(String instagram) {
    this.instagram = instagram;
  }

  public Client goals(List<Goal> goals) {
    this.goals = goals;
    return this;
  }

  public Client addGoalsItem(Goal goalsItem) {
    if (this.goals == null) {
      this.goals = new ArrayList<Goal>();
    }
    this.goals.add(goalsItem);
    return this;
  }

  /**
   * Get goals
   * @return goals
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Goal> getGoals() {
    return goals;
  }

  public void setGoals(List<Goal> goals) {
    this.goals = goals;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Client client = (Client) o;
    return Objects.equals(this.id, client.id) &&
        Objects.equals(this.accountIBAN, client.accountIBAN) &&
        Objects.equals(this.accountName, client.accountName) &&
        Objects.equals(this.accountAuth, client.accountAuth) &&
        Objects.equals(this.balance, client.balance) &&
        Objects.equals(this.instagram, client.instagram) &&
        Objects.equals(this.goals, client.goals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, accountIBAN, accountName, accountAuth, balance, instagram, goals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    accountIBAN: ").append(toIndentedString(accountIBAN)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    accountAuth: ").append(toIndentedString(accountAuth)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    instagram: ").append(toIndentedString(instagram)).append("\n");
    sb.append("    goals: ").append(toIndentedString(goals)).append("\n");
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
