package com.keke.microservices.currencyexchangeservice.bean;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
  @Id
  private long id;
  @Column(name = "currencyFrom")
  private String from;
  @Column(name = "currencyTo")
  private String to;
  private  BigDecimal conversionMultiple;

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  private int port;
  public ExchangeValue(){

  }

  public void setId(long id) {
    this.id = id;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public void setConversionMultiple(BigDecimal conversionMultiple) {
    this.conversionMultiple = conversionMultiple;
  }

  public long getId() {
    return id;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public BigDecimal getConversionMultiple() {
    return conversionMultiple;
  }

  public ExchangeValue(long id, String from, String to, BigDecimal conversionMultiple) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
  }
}
