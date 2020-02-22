package com.vahider.logz;


import android.util.Log;
import android.view.View;

import com.vahider.logz.enums.Case;
import com.vahider.logz.enums.Info;
import com.vahider.logz.enums.Summary;
import com.vahider.logz.enums.Time;

public class Logz {

  static final String ENTER = "\n                         ";
  private static boolean isInitilize = false;

  static final String LOGZ = "LOGZ";
  static String tag = LOGZ;
  static boolean enable = true; // used in debugging mode
  static boolean used = true;
  static String timeFormat = Time.CLOCK.getFormat();
  static boolean showInfo = true;
  static boolean infoClicable = false;
  static boolean showInfoFile = false;
  static boolean showInfoClass = true;
  static boolean showInfoMethod = true;
  static boolean showInfoLine = true;
  static Summary summary = Summary.START;
  static boolean elapsing = true;
  static Case titleCase = Case.CAMEL;
  static boolean viewDetection = true;

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
  }

  private static void firstInit() {
    if (!isInitilize) {
      Thread.setDefaultUncaughtExceptionHandler(new MrCrash());

      if (enable) {
        Log.v(tag, MrLog.log("", "────────────────────────────────────────────────────────────────────────────────", 0));
        Log.v(tag, MrLog.log("", "───────────────────────────── NEW LAUNCH WITH LOGZ ─────────────────────────────", 0));
        Log.v(tag, MrLog.log("", "────────────────────────────────────────────────────────────────────────────────", 0));
      } else if (!enable) {
        Log.e(tag, "──────────────────────────────── LOGZ IS DISABLE ───────────────────────────────");
      } else if (!used) {
        Log.w(tag, "─────────────────────────────── LOGZ WAS NOT USED ──────────────────────────────");
      }

      isInitilize = true;
    }
  }

  static Object safeDetection(Object object) { // view and null
    if (object == null)
      return "null";
    if (viewDetection && object instanceof View) {
      View view = (View) object;
      String id = "-";
      if (view.getId() != View.NO_ID)
        id = view.getContext().getResources().getResourceEntryName(view.getId());
      return view.getClass().getSimpleName() + "(" + id + ")";
    }
    return object;
  }


  public static String getTag() {
    return tag;
  }

  // Logz
  public static void is(Object log) {
    firstInit();
    MrLog.is(safeDetection(log));
  }

  public static void v(Object title, Object log) {
    firstInit();
    MrLog.v(safeDetection(title), safeDetection(log));
  }

  public static void d(Object title, Object log) {
    firstInit();
    MrLog.d(safeDetection(title), safeDetection(log));
  }

  public static void i(Object title, Object log) {
    firstInit();
    MrLog.i(safeDetection(title), safeDetection(log));
  }

  public static void w(Object title, Object log) {
    firstInit();
    MrLog.w(safeDetection(title), safeDetection(log));
  }

  public static void e(Object title, Object log) {
    firstInit();
    MrLog.e(safeDetection(title), safeDetection(log));
  }

  public static void v(Object log) {
    firstInit();
    MrLog.v(safeDetection(log));
  }

  public static void d(Object log) {
    firstInit();
    MrLog.d(safeDetection(log));
  }

  public static void i(Object log) {
    firstInit();
    MrLog.i(safeDetection(log));
  }

  public static void w(Object log) {
    firstInit();
    MrLog.w(safeDetection(log));
  }

  public static void e(Object log) {
    firstInit();
    MrLog.e(safeDetection(log));
  }

  public static void line(Object title) { // 50 character
    firstInit();
    MrLog.line(safeDetection(title));
  }

  public static void line() {
    firstInit();
    MrLog.line();
  }

  // List
  public static void list(Object logList) {
    firstInit();
    MrList.list("", safeDetection(logList));
  }

  public static void list(Object title, Object logList) {
    firstInit();
    MrList.list(safeDetection(title).toString(), safeDetection(logList));
  }

  // Json
  public static void json(Object logJson) {
    firstInit();
    MrJson.json("", safeDetection(logJson));
  }

  public static void json(Object title, Object logJson) {
    firstInit();
    MrJson.json(safeDetection(title), safeDetection(logJson));
  }

  // Chart
  public static void chart(double... yPoints) {
    firstInit();
    MrChart.chart(yPoints);
  }

  // Table


  // region Biulder
  public static class Builder {

    private String tag;
    private boolean enable;
    private boolean used;
    private String timeFormat;
    private boolean info;
    private boolean infoClickable;
    private Info[] infoMode;
    private Summary summary;
    private boolean elapsing;
    private Case titleCase;
    private boolean viewDetection;

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

    public Builder setTimeFormat(final Time timeFormat) {
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