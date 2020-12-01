package com.keke.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CorrencyConversionBean {
  private long id;
  private String from;
  private String to;
  private BigDecimal quantity;
  private BigDecimal totalCalculateAmount;
  private BigDecimal conversionMultiple;
  private int port;
 public  CorrencyConversionBean(){

 }
  public CorrencyConversionBean(long id, String from, String to, BigDecimal quantity,
      BigDecimal totalCalculateAmount, BigDecimal conversionMultiple, int port) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.quantity = quantity;
    this.totalCalculateAmount = totalCalculateAmount;
    this.conversionMultiple = conversionMultiple;
    this.port = port;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public BigDecimal getQuantity() {
    return quantity;
  }

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getTotalCalculateAmount() {
    return totalCalculateAmount;
  }

  public void setTotalCalculateAmount(BigDecimal totalCalculateAmount) {
    this.totalCalculateAmount = totalCalculateAmount;
  }

  public BigDecimal getConversionMultiple() {
    return conversionMultiple;
  }

  public void setConversionMultiple(BigDecimal conversionMultiple) {
    this.conversionMultiple = conversionMultiple;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
