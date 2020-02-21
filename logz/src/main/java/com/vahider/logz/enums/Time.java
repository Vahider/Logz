package com.vahider.logz.enums;

public enum Time {
  NONE(""), STAMP("STAMP"), CLOCK("HH:mm:ss"), DATE("yyyy/MM/dd"), FULL("yyyy/MM/dd-HH:mm:ss");

  private final String format;

  Time(String format) {
    this.format = format;
  }

  public String getFormat() {
    return format;
  }
}