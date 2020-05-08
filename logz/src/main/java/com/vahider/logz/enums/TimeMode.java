package com.vahider.logz.enums;

public enum TimeMode {
  NONE(""), STAMP("STAMP"), CLOCK("HH:mm:ss"), DATE("yyyy/MM/dd"), FULL("yyyy/MM/dd-HH:mm:ss");

  private final String format;

  TimeMode(String format) {
    this.format = format;
  }

  public String getFormat() {
    return format;
  }
}