package com.projectb.nogo.constant;

public enum AuthMethod {
  PHONE("phone"), IPIN("ipin");

  private String method;

  AuthMethod(String method) {
    this.method = method;
  }

  public String getMethod() {
    return method;
  }

}
