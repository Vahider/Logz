package com.vahider.logz;


public class MrCrash implements Thread.UncaughtExceptionHandler {

  private Thread.UncaughtExceptionHandler defaultUEH;

  public MrCrash() {
    this.defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
  }

  public void uncaughtException(Thread thread, Throwable throwable) {
    StackTraceElement[] arr = throwable.getStackTrace();
    Throwable cause = throwable.getCause();

    StringBuilder report = new StringBuilder();
    report.append(Logz.ENTER).append(MrLog.setTitleStyle("Crash")).append(throwable.toString());
    for (StackTraceElement stackTraceElement : arr) {
      report.append(Logz.ENTER).append(stackTraceElement.toString());
    }

    // If the exception was thrown in a background thread inside
    // AsyncTask, then the actual exception can be found with getCause
    if (cause != null) {
      report.append(Logz.ENTER).append(Logz.ENTER).append(MrLog.setTitleStyle("Crash in background")).append(cause.toString());
      arr = cause.getStackTrace();
      for (StackTraceElement stackTraceElement : arr) {
        report.append(Logz.ENTER).append(stackTraceElement.toString());
      }
    }

    MrLog.error("", report, 0);
    defaultUEH.uncaughtException(thread, throwable);
  }
}