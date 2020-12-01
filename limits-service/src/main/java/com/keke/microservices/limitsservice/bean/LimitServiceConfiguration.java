package com.keke.microservices.limitsservice.bean;

public class LimitServiceConfiguration {
   private int maximum;
   private int minimum;

  protected LimitServiceConfiguration() {
  }

  public LimitServiceConfiguration(int maximum, int minimum) {
    this.maximum = maximum;
    this.minimum = minimum;
  }

  public int getMaximum() {
    return maximum;
  }

  public void setMaximum(int maximum) {
    this.maximum = maximum;
  }

  public int getMinimum() {
    return minimum;
  }

  public void setMinimum(int minimum) {
    this.minimum = minimum;
  }
}
