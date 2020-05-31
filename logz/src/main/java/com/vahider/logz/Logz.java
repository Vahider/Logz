package com.vahider.logz;

import android.util.Log;

import com.vahider.logz.enums.Case;
import com.vahider.logz.enums.Info;
import com.vahider.logz.enums.Summary;
import com.vahider.logz.enums.TimeMode;

import java.util.List;

// ⌬
public class Logz {

  public static final String LOG_ENTER = "\n                         ";
  private static boolean isInitilize = false;

  // Tip: Values must be define in here and on biulder
  static String tag = "⌬ LOGZ";
  static boolean enable = true; // useing in debugging mode
  static boolean used = true;
  static String timeFormat = TimeMode.CLOCK.getFormat();
  static boolean showInfo = true;
  static boolean infoClicable = false;
  static boolean showInfoFile = false;
  static boolean showInfoClass = true;
  static boolean showInfoMethod = true;
  static boolean showInfoLine = true;
  static Summary summary = Summary.START;
  static boolean elapsing = true;
  static Case titleCase = Case.CAMEL_SPACE;
  static boolean viewDetection = true;
  static boolean limitedLog = false;

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
    limitedLog = builder.limitedLength;

    firstInit();
  }

  private static void firstInit() {
    if (!isInitilize) {
      Thread.setDefaultUncaughtExceptionHandler(new MrError());

      if (enable) {
        if (used) {
          Log.v(tag, "⌬ ──────────────────────────────────────────────────────────────────────────────────────────");
          Log.v(tag, "⌬ ────────────────────────────────── NEW LAUNCH WITH LOGZ ──────────────────────────────────");
          Log.v(tag, "⌬ ──────────────────────────────────────────────────────────────────────────────────────────");
        } else {
          Log.w(tag, "⌬ ──────────────────────────────────────────────────────────────────────────────────────────");
          Log.w(tag, "⌬ ──────────────────────────────────── LOGZ WAS NOT USED ───────────────────────────────────");
          Log.w(tag, "⌬ ──────────────────────────────────────────────────────────────────────────────────────────");
        }
      } else {
        Log.e(tag, "⌬ ───────────────────────────────────── LOGZ IS DISABLE ────────────────────────────────────");
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
    if (Logz.enable)
      if (Logz.used)
        MrLog.is(Util.checkNullViewArray(msg));
      else
        Log.d(Logz.tag, "⌬ " + Util.checkNullViewArray(msg));
  }

  public static void is(Object title, Object msg) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.is(Util.checkNullViewArray(title), Util.checkNullViewArray(msg));
      else
        Log.d(Logz.tag, "⌬ " + Util.checkNullViewArray(title) + " : " + Util.checkNullViewArray(msg));
  }

  public static void v(Object title, Object msg) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.v(Util.checkNullViewArray(title), Util.checkNullViewArray(msg));
      else
        Log.v(Logz.tag, "⌬ " + Util.checkNullViewArray(title) + " : " + Util.checkNullViewArray(msg));
  }

  public static void d(Object title, Object msg) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.d(Util.checkNullViewArray(title), Util.checkNullViewArray(msg));
      else
        Log.d(Logz.tag, "⌬ " + Util.checkNullViewArray(title) + " : " + Util.checkNullViewArray(msg));
  }

  public static void i(Object title, Object msg) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.i(Util.checkNullViewArray(title), Util.checkNullViewArray(msg));
      else
        Log.i(Logz.tag, "⌬ " + Util.checkNullViewArray(title) + " : " + Util.checkNullViewArray(msg));
  }

  public static void w(Object title, Object msg) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.w(Util.checkNullViewArray(title), Util.checkNullViewArray(msg));
      else
        Log.w(Logz.tag, "⌬ " + Util.checkNullViewArray(title) + " : " + Util.checkNullViewArray(msg));
  }

  public static void e(Object title, Object msg) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.e(Util.checkNullViewArray(title), Util.checkNullViewArray(msg));
      else
        Log.e(Logz.tag, "⌬ " + Util.checkNullViewArray(title) + " : " + Util.checkNullViewArray(msg));
  }

  public static void v(Object msg) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.v(Util.checkNullViewArray(msg));
      else
        Log.v(Logz.tag, "⌬ " + Util.checkNullViewArray(msg));
  }

  public static void d(Object msg) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.d(Util.checkNullViewArray(msg));
      else
        Log.d(Logz.tag, "⌬ " + Util.checkNullViewArray(msg));
  }

  public static void i(Object msg) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.i(Util.checkNullViewArray(msg));
      else
        Log.i(Logz.tag, "⌬ " + Util.checkNullViewArray(msg));
  }

  public static void w(Object msg) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.w(Util.checkNullViewArray(msg));
      else
        Log.w(Logz.tag, "⌬ " + Util.checkNullViewArray(msg));
  }

  public static void e(Object msg) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.e(Util.checkNullViewArray(msg));
      else
        Log.e(Logz.tag, "⌬ " + Util.checkNullViewArray(msg));
  }

  public static void line(Object title) { // 50 character
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.line(Util.checkNullViewArray(title));
      else
        Log.v(Logz.tag, "⌬ " + Util.checkNullViewArray(title));
  }

  public static void line() {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrLog.line();
      else
        Log.v(Logz.tag, "⌬ " + "");
  }

  // Array
//  public static void array(Object logList) {
//    firstInit();
//    if (Logz.enable)
//      if (Logz.used)
//        MrArray.array("", Util.checkNullViewArray(logList));
//      else
//        Log.i(Logz.tag, "⌬ " + Util.checkNullViewArray(logList));
//  }
//
//  public static void array(Object title, Object logList) {
//    firstInit();
//    if (Logz.enable)
//      if (Logz.used)
//        MrArray.array(Util.checkNullViewArray(title).toString(), Util.checkNullViewArray(logList));
//      else
//        Log.i(Logz.tag, "⌬ " + Util.checkNullViewArray(title) + " : " + Util.checkNullViewArray(logList));
//  }

  // Json
  public static void json(Object logJson) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrJson.json("", Util.checkNullViewArray(logJson));
      else
        Log.i(Logz.tag, "⌬ " + Util.checkNullViewArray(logJson));
  }

  public static void json(Object title, Object logJson) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrJson.json(Util.checkNullViewArray(title), Util.checkNullViewArray(logJson));
      else
        Log.i(Logz.tag, "⌬ " + Util.checkNullViewArray(title) + " : " + Util.checkNullViewArray(logJson));
  }

  // Chart
  public static void chart(double... yPoints) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrChart.chart(yPoints);
      else
        Log.i(Logz.tag, "⌬ (Chart) " + Util.checkNullViewArray(yPoints));
  }

  // Table
  public static void table(List rowModel, String... columnMethods) {
    firstInit();
    if (Logz.enable)
      if (Logz.used)
        MrTable.table(rowModel, columnMethods); // Self check
      else
        Log.i(Logz.tag, "⌬ (Table) " + Util.checkNullViewArray(rowModel));
  }


  // region Biulder
  public static class Builder {

    // Tip: Values must be define in here and on biulder
    private String tag = "⌬ LOGZ";
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
    private boolean limitedLength = false;

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

    public Builder setLimitLength(boolean limitedLength) {
      this.limitedLength = limitedLength;
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