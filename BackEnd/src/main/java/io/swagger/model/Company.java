package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Company
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-07T19:30:51.910Z[GMT]")

@Entity
@Table(name = "Companies")
public class Company   {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  @JsonProperty("id")
  private UUID id = null;

  @Column(name = "counterpartyAccountName", nullable = false)
  @JsonProperty("counterpartyAccountName")
  private String counterpartyAccountName = null;

  @Column(name = "counterpartyAccountData")
  @JsonProperty("counterpartyAccountData")
  private String counterpartyAccountData = null;

  /**
   * Gets or Sets counterpartyAccountInfo
   */
  public enum CounterpartyAccountInfoEnum {
    IBAN("IBAN"),
    
    BIC("BIC");

    private String value;

    CounterpartyAccountInfoEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CounterpartyAccountInfoEnum fromValue(String text) {
      for (CounterpartyAccountInfoEnum b : CounterpartyAccountInfoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @Column(name = "counterpartyAccountInfo")
  @JsonProperty("counterpartyAccountInfo")
  private CounterpartyAccountInfoEnum counterpartyAccountInfo = null;

  public Company id(UUID id) {
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

  public Company counterpartyAccountName(String counterpartyAccountName) {
    this.counterpartyAccountName = counterpartyAccountName;
    return this;
  }

  /**
   * Get counterpartyAccountName
   * @return counterpartyAccountName
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public String getCounterpartyAccountName() {
    return counterpartyAccountName;
  }

  public void setCounterpartyAccountName(String counterpartyAccountName) {
    this.counterpartyAccountName = counterpartyAccountName;
  }

  public Company counterpartyAccountData(String counterpartyAccountData) {
    this.counterpartyAccountData = counterpartyAccountData;
    return this;
  }

  /**
   * Get counterpartyAccountData
   * @return counterpartyAccountData
  **/
  @ApiModelProperty(value = "")
  
    public String getCounterpartyAccountData() {
    return counterpartyAccountData;
  }

  public void setCounterpartyAccountData(String counterpartyAccountData) {
    this.counterpartyAccountData = counterpartyAccountData;
  }

  public Company counterpartyAccountInfo(CounterpartyAccountInfoEnum counterpartyAccountInfo) {
    this.counterpartyAccountInfo = counterpartyAccountInfo;
    return this;
  }

  /**
   * Get counterpartyAccountInfo
   * @return counterpartyAccountInfo
  **/
  @ApiModelProperty(value = "")
  
    public CounterpartyAccountInfoEnum getCounterpartyAccountInfo() {
    return counterpartyAccountInfo;
  }

  public void setCounterpartyAccountInfo(CounterpartyAccountInfoEnum counterpartyAccountInfo) {
    this.counterpartyAccountInfo = counterpartyAccountInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Company company = (Company) o;
    return Objects.equals(this.id, company.id) &&
        Objects.equals(this.counterpartyAccountName, company.counterpartyAccountName) &&
        Objects.equals(this.counterpartyAccountData, company.counterpartyAccountData) &&
        Objects.equals(this.counterpartyAccountInfo, company.counterpartyAccountInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, counterpartyAccountName, counterpartyAccountData, counterpartyAccountInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Company {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    counterpartyAccountName: ").append(toIndentedString(counterpartyAccountName)).append("\n");
    sb.append("    counterpartyAccountData: ").append(toIndentedString(counterpartyAccountData)).append("\n");
    sb.append("    counterpartyAccountInfo: ").append(toIndentedString(counterpartyAccountInfo)).append("\n");
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
