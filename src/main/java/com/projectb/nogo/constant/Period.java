package com.projectb.nogo.constant;

public enum Period {
  ONE_YEAR("oneYear"), THREE_YEAR("threeYear"), UNTIL_WITHDRAWAL("untilWithdrawal");

  private String period;

  Period(String period) {
    this.period = period;
  }

  public String getPeriod() {
    return period;
  }
}
