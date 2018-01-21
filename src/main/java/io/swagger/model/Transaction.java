package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Transaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-21T13:41:11.054+01:00")

public class Transaction   {
  @JsonProperty("owner")
  private String owner = null;

  @JsonProperty("timestamp")
  private String timestamp = null;

  @JsonProperty("usd")
  private Double usd = null;

  @JsonProperty("btc")
  private Double btc = null;

  @JsonProperty("type")
  private Boolean type = null;

  public Transaction owner(String owner) {
    this.owner = owner;
    return this;
  }

  /**
   * Get owner
   * @return owner
  **/
  @ApiModelProperty(value = "")


  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Transaction timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
  **/
  @ApiModelProperty(value = "")


  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public Transaction usd(Double usd) {
    this.usd = usd;
    return this;
  }

  /**
   * Get usd
   * @return usd
  **/
  @ApiModelProperty(value = "")


  public Double getUsd() {
    return usd;
  }

  public void setUsd(Double usd) {
    this.usd = usd;
  }

  public Transaction btc(Double btc) {
    this.btc = btc;
    return this;
  }

  /**
   * Get btc
   * @return btc
  **/
  @ApiModelProperty(value = "")


  public Double getBtc() {
    return btc;
  }

  public void setBtc(Double btc) {
    this.btc = btc;
  }

  public Transaction type(Boolean type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")


  public Boolean isType() {
    return type;
  }

  public void setType(Boolean type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.owner, transaction.owner) &&
        Objects.equals(this.timestamp, transaction.timestamp) &&
        Objects.equals(this.usd, transaction.usd) &&
        Objects.equals(this.btc, transaction.btc) &&
        Objects.equals(this.type, transaction.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, timestamp, usd, btc, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    usd: ").append(toIndentedString(usd)).append("\n");
    sb.append("    btc: ").append(toIndentedString(btc)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

