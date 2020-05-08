package com.vahider.logz;


import android.util.Log;

import com.vahider.logz.enums.Summary;
import com.vahider.logz.enums.TimeMode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

class MrLog {

  private static final int PATH_POSITION = 7;
  private static final int CALCULATE_ELAPSING = 3000;
  private static long lastLog = System.currentTimeMillis();

  static void v(Object title, Object log) {
    if (Logz.enable)
      Log.v(Logz.tag, log(title, log, 0));
  }

  static void d(Object title, Object log) {
    if (Logz.enable)
      Log.d(Logz.tag, log(title, log, 0));
  }

  static void i(Object title, Object log) {
    if (Logz.enable)
      Log.i(Logz.tag, log(title, log, 0));
  }

  static void w(Object title, Object log) {
    if (Logz.enable)
      Log.w(Logz.tag, log(title, log, 0));
  }

  static void e(Object title, Object log) {
    if (Logz.enable)
      Log.e(Logz.tag, log(title, log, 0));
  }

  static void is(Object title, Object log) {
    if (Logz.enable)
      Log.d(Logz.tag, log(title, "✦✦✦ " + log, 0));
  }

  static void v(Object log) {
    if (Logz.enable)
      Log.v(Logz.tag, log("", log, 0));
  }

  static void d(Object log) {
    if (Logz.enable)
      Log.d(Logz.tag, log("", log, 0));
  }

  static void i(Object log) {
    if (Logz.enable)
      Log.i(Logz.tag, log("", log, 0));
  }

  static void w(Object log) {
    if (Logz.enable)
      Log.w(Logz.tag, log("", log, 0));
  }

  static void e(Object log) {
    if (Logz.enable)
      Log.e(Logz.tag, log("", log, 0));
  }

  static void is(Object log) {
    if (Logz.enable)
      Log.d(Logz.tag, log("", "✦✦✦ " + log, 0));
  }

  static void line(Object title) { // 40 character
    if (Logz.enable) {
      int len = title.toString().length() + 2; // 2 Spcae
      if (len >= 38) // - 2 Dash
        Log.v(Logz.tag, log("", "―― " + title + " ――", 0));
      else {
        String spaceLine = Util.fillSpace('─', (40 - len) / 2);
        Log.v(Logz.tag, log("", Util.fixSpaceExtra(spaceLine + " " + title + " " + spaceLine, '─', 40), 0));
      }
    }
  }

  static void line() {
    if (Logz.enable)
      Log.v(Logz.tag, log("", "────────────────────────────────────────", 0)); // 50 character
  }

  // For another class
  static void show(Object log, int extraLevel) {
    if (Logz.enable)
      Log.i(Logz.tag, log("", log, extraLevel));
  }

  static void error(Object title, Object log, int extraLevel) {
    if (Logz.enable)
      Log.e(Logz.tag, log(title, log, extraLevel));
  }

  // Settings
  static String log(Object title, Object log, int extraPos) {
    if (Logz.used) {
      checkElapsed();
      return totalSettings(title.toString(), log.toString(), extraPos) + log;
    } else {
      return "⌬ " + (!title.toString().isEmpty() ? title : "") + log;
    }
  }

  private static String totalSettings(String title, String log, int extraPos) {
    String info = "⌬ " + "【" + (!Logz.timeFormat.equals(TimeMode.NONE.getFormat()) ? getTime() : "") + getPosition(log, extraPos) + "】 ";
    return info + (!title.isEmpty() ? Util.setTitleStyle(title) : "");
  }

  private static void checkElapsed() {
    if (Logz.elapsing) {
      long minus = System.currentTimeMillis() - lastLog;
      if (minus > CALCULATE_ELAPSING)
        Log.v(Logz.tag, "⌬ " + "(⏳ " + minus / 1000 + "s)");
      lastLog = System.currentTimeMillis();
    }
  }

  private static String getTime() {
    String result;
    if (Logz.timeFormat.equals(TimeMode.STAMP.getFormat())) {
      String timeMillis = String.valueOf(System.currentTimeMillis());
      result = timeMillis.substring(0, timeMillis.length() - 3) + "″" + timeMillis.substring(timeMillis.length() - 3) + "‴";
    } else {
      Calendar calendar = Calendar.getInstance();
      SimpleDateFormat simpleDateFormat;
      try {
        simpleDateFormat = new SimpleDateFormat(Logz.timeFormat, Locale.ENGLISH);
      } catch (IllegalArgumentException e) {
        simpleDateFormat = new SimpleDateFormat(TimeMode.CLOCK.getFormat(), Locale.ENGLISH);
      }
      // simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT")); // missing line
      result = simpleDateFormat.format(calendar.getTime());
    }
    return result + " "; // 🌕🌗🌘🌖🌑🌓🌒🌔 🕛🕐🕐🕖🕕🕔🕓🕒🕑🕘🕙🕚🕛 ⏳⌛⏰
  }

  private static String getPosition(Object log, int extraPos) {
    if (Logz.showInfo) {
      int pathPos = PATH_POSITION + extraPos;
      StackTraceElement[] elements = Thread.currentThread().getStackTrace();
      if (elements[pathPos] != null) {
        if (Logz.infoClicable)
          return "Ⓕ" + summaryText(elements[pathPos].getMethodName()) + ".(" + summaryText(elements[pathPos].getFileName()) + ":" + elements[pathPos].getLineNumber() + ")";
        else
          return "Ⓕ" + summaryText(elements[pathPos].getFileName().replace(".java", "").replace(".kt", "")) + " ⓜ" + summaryText(elements[pathPos].getMethodName()) + " Ⓛ" + elements[pathPos].getLineNumber();
      }
    }
    return "Ⓕnull ⓜnull Ⓛnull";
  }

  private static String summaryText(String text) {
    int len = text.length();
    if (len > 20) {
      if (Logz.summary == Summary.START) {
        return "‥" + text.substring(len - 20);
      } else if (Logz.summary == Summary.END) {
        return text.substring(0, 20) + "‥";
      }
    }
    return text;
  }

}