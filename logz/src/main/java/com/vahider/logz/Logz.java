package com.vahider.logz;

import android.util.Log;

import com.vahider.logz.enums.Case;
import com.vahider.logz.enums.Info;
import com.vahider.logz.enums.Summary;
import com.vahider.logz.enums.TimeMode;

import java.util.List;

public class Logz {

  public static final String ENTER = "\n                         ";
  private static boolean isInitilize = false;

  static String tag;
  static boolean enable; // used in debugging mode
  static boolean used;
  static String timeFormat;
  static boolean showInfo;
  static boolean infoClicable;
  static boolean showInfoFile;
  static boolean showInfoClass;
  static boolean showInfoMethod;
  static boolean showInfoLine;
  static Summary summary;
  static boolean elapsing;
  static Case titleCase;
  static boolean viewDetection;

  private Logz(final Builder builder) {
    tag = builder.tag;
    enable = builder.enable;
    used = builder.used;
    timeFormat = builder.timeFormat;
    showInfo = builder.info;
    infoClicable = builder.infoClickable;
    for (Info info : builder.infoMode)
      if (info == Info.FILE)
        showInfoFile = true;
      else if (info == Info.CLASS)
        showInfoClass = true;
      else if (info == Info.METHOD)
        showInfoMethod = true;
      else if (info == Info.LINE)
        showInfoLine = true;
    summary = builder.summary;
    elapsing = builder.elapsing;
    titleCase = builder.titleCase;
    viewDetection = builder.viewDetection;

    firstInit();
  }

  private static void firstInit() {
    if (!isInitilize) {
      Thread.setDefaultUncaughtExceptionHandler(new MrCrash());

      if (enable) {
        Log.v(tag, /*MrLog.log("",*/ "⌬ ──────────────────────────────────────────────────────────────────────────────────────────"/*, 0)*/);
        Log.v(tag, /*MrLog.log("",*/ "⌬ ────────────────────────────────── NEW LAUNCH WITH LOGZ ──────────────────────────────────"/*, 0)*/);
        Log.v(tag, /*MrLog.log("",*/ "⌬ ──────────────────────────────────────────────────────────────────────────────────────────"/*, 0)*/);
      } else if (!enable) {
        Log.e(tag, "──────────────────────────────── LOGZ IS DISABLE ───────────────────────────────");
      } else if (!used) {
        Log.w(tag, "─────────────────────────────── LOGZ WAS NOT USED ──────────────────────────────");
      }

      isInitilize = true;
    }
  }

  public static String getTag() {
    return tag;
  }

  // Logz
  public static void is(Object msg) {
    firstInit();
    MrLog.is(Util.safeDetection(msg));
  }

  public static void is(Object title, Object msg) {
    firstInit();
    MrLog.is(Util.safeDetection(title), Util.safeDetection(msg));
  }

  public static void v(Object title, Object msg) {
    firstInit();
    MrLog.v(Util.safeDetection(title), Util.safeDetection(msg));
  }

  public static void d(Object title, Object msg) {
    firstInit();
    MrLog.d(Util.safeDetection(title), Util.safeDetection(msg));
  }

  public static void i(Object title, Object msg) {
    firstInit();
    MrLog.i(Util.safeDetection(title), Util.safeDetection(msg));
  }

  public static void w(Object title, Object msg) {
    firstInit();
    MrLog.w(Util.safeDetection(title), Util.safeDetection(msg));
  }

  public static void e(Object title, Object msg) {
    firstInit();
    MrLog.e(Util.safeDetection(title), Util.safeDetection(msg));
  }

  public static void v(Object msg) {
    firstInit();
    MrLog.v(Util.safeDetection(msg));
  }

  public static void d(Object msg) {
    firstInit();
    MrLog.d(Util.safeDetection(msg));
  }

  public static void i(Object msg) {
    firstInit();
    MrLog.i(Util.safeDetection(msg));
  }

  public static void w(Object msg) {
    firstInit();
    MrLog.w(Util.safeDetection(msg));
  }

  public static void e(Object msg) {
    firstInit();
    MrLog.e(Util.safeDetection(msg));
  }

  public static void line(Object title) { // 50 character
    firstInit();
    MrLog.line(Util.safeDetection(title));
  }

  public static void line() {
    firstInit();
    MrLog.line();
  }

  // List
  public static void list(Object logList) {
    firstInit();
    MrList.list("", Util.safeDetection(logList));
  }

  public static void list(Object title, Object logList) {
    firstInit();
    MrList.list(Util.safeDetection(title).toString(), Util.safeDetection(logList));
  }

  // Json
  public static void json(Object logJson) {
    firstInit();
    MrJson.json("", Util.safeDetection(logJson));
  }

  public static void json(Object title, Object logJson) {
    firstInit();
    MrJson.json(Util.safeDetection(title), Util.safeDetection(logJson));
  }

  // Chart
  public static void chart(double... yPoints) {
    firstInit();
    MrChart.chart(yPoints);
  }

  // Table
  public static void table(List rowModel, String... columnMethods) {
    firstInit();
    MrTable.table(rowModel, columnMethods);
  }


  // region Biulder
  public static class Builder {

    private String tag = "LOGZ";
    private boolean enable = true;
    private boolean used = true;
    private String timeFormat = TimeMode.CLOCK.getFormat();
    private boolean info = true;
    private boolean infoClickable = false;
    private Info[] infoMode = new Info[]{Info.CLASS, Info.METHOD, Info.LINE};
    private Summary summary = Summary.START;
    private boolean elapsing = true;
    private Case titleCase = Case.CAMEL_SPACE;
    private boolean viewDetection = true;

    public Builder setTag(final String tag) {
      this.tag = tag;
      return this;
    }

    public Builder setEnable(final boolean enable) {
      this.enable = enable;
      return this;
    }

    public Builder setUsed(final boolean used) {
      this.used = used;
      return this;
    }

    public Builder setTimeFormat(final String timeFormat) {
      this.timeFormat = timeFormat;
      return this;
    }

    public Builder setTimeFormat(final TimeMode timeFormat) {
      this.timeFormat = timeFormat.getFormat();
      return this;
    }

    public Builder showInfo(final boolean info) {
      this.info = info;
      return this;
    }

    public Builder setInfoClickable(final boolean infoClickable) {
      this.infoClickable = infoClickable;
      return this;
    }

    public Builder setInfoMode(final Info... infoMode) {
      this.infoMode = infoMode;
      return this;
    }

    public Builder useSummaryMode(final Summary summary) {
      this.summary = summary;
      return this;
    }

    public Builder showElapsing(final boolean elapsing) {
      this.elapsing = elapsing;
      return this;
    }

    public Builder setTitleCase(final Case titleCase) {
      this.titleCase = titleCase;
      return this;
    }

    public Builder useViewDetection(final boolean viewDetection) {
      this.viewDetection = viewDetection;
      return this;
    }

    public Logz reload() {
      return new Logz(this);
      /*
      User user = new User(firstName, lastName, age);
        if (user.firstName.isEmpty()) {
          throw new IllegalStateException("You forgot the name");
        }
      return user;
      */
    }
  }
  // endregion
}