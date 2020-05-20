package com.vahider.logz;


public class MrError implements Thread.UncaughtExceptionHandler {

  private Thread.UncaughtExceptionHandler defaultUEH;

  public MrError() {
    this.defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
  }

  public void uncaughtException(Thread thread, Throwable throwable) {
    StackTraceElement[] arr = throwable.getStackTrace();
    Throwable cause = throwable.getCause();

    StringBuilder report = new StringBuilder();
    report.append(Logz.LOG_ENTER).append(Util.setTitleStyle("Error")).append(throwable.toString());
    for (StackTraceElement stackTraceElement : arr) {
      report.append(Logz.LOG_ENTER).append(stackTraceElement.toString());
    }

    // If the exception was thrown in a background thread inside
    // AsyncTask, then the actual exception can be found with getCause
    if (cause != null) {
      report.append(Logz.LOG_ENTER).append(Logz.LOG_ENTER).append(Util.setTitleStyle("Error in background")).append(cause.toString());
      arr = cause.getStackTrace();
      for (StackTraceElement stackTraceElement : arr) {
        report.append(Logz.LOG_ENTER).append(stackTraceElement.toString());
      }
    }

    MrLog.error("", report, 0);
    defaultUEH.uncaughtException(thread, throwable);
  }
}