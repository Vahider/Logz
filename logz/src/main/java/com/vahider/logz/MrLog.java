package com.vahider.logz;


import android.util.Log;

import com.vahider.logz.enums.Case;
import com.vahider.logz.enums.Summary;
import com.vahider.logz.enums.Time;

import java.text.SimpleDateFormat;
import java.util.Arrays;
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
        int baghi = (40 - len) / 2;
        char[] chars = new char[baghi];
        Arrays.fill(chars, '─');
        Log.v(Logz.tag, log("", new String(chars) + " " + title + " " + new String(chars), 0));
      }
    }
  }

  static void line() {
    if (Logz.enable)
      Log.v(Logz.tag, log("", "────────────────────────────────────────", 0)); // 50 character
  }

  // For another class
//  static void title(Object title, int extraLevel) {
//    if (Logz.enable)
//      Log.i(Logz.tag, log(title), "", extraLevel));
//  }

  static void show(Object log, int extraLevel) {
    if (Logz.enable)
      Log.i(Logz.tag, log("", log, extraLevel));
  }

  static void error(Object title, Object log, int extraLevel) {
    if (Logz.enable)
      Log.e(Logz.tag, log(title, log, extraLevel));
  }

  // Settings

  // delete space from title
  // INFO_CLICABLE "【onCreate.(SplashActivity.java:50)】"
  // change space to offset
  // Get name thread Thread.currentThread().getName()
  // Adapted with crashing
  // massage with one_time_use
  // array and collection
  // without any external library

  // [ { ---- : , } ]
  // List level, name

  // Above
  static String log(Object title, Object log, int extraPos) {
    if (Logz.used) {
      checkElapsed();
      return totalSettings(title.toString(), log.toString(), extraPos) + log;
    } else {
      return "⌬ " + (!title.toString().isEmpty() ? title : "") + log;
    }
  }

  private static String totalSettings(String title, String log, int extraPos) {
    String info = "⌬ " + "【" + (!Logz.timeFormat.equals(Time.NONE.getFormat()) ? getTime() : "") + getPosition(log, extraPos) + "】 ";
    return info + (!title.isEmpty() ? setTitleStyle(title) : "");
  }

  static String setTitleStyle(String text) {
    text = text
      .trim()
      .replaceAll("/+", "")
      .replaceAll(":", "")
      .trim();
    String[] textArray = text.split(" ");

    String space = Logz.titleCase == Case.CAMEL_SPACE ? " " : "";

    StringBuilder builder = new StringBuilder();
    for (String t : textArray) {
      if (t.length() > 1)
        builder.append(Character.toUpperCase(t.charAt(0))).append(t.substring(1)).append(space);
    }

    String result = builder.toString();
    return setFont(result) + (result.isEmpty() ? "" : ": ");
  }

  private static void checkElapsed() {
    if (Logz.elapsing) {
      long minus = System.currentTimeMillis() - lastLog;
      if (minus > CALCULATE_ELAPSING) {
//        if (Logz.elapsingMode == Elapse.BOTH)
//          Log.v(Logz.tag, "⌬ " + getTime() + "(" + minus / 1000 + "s)");
//        else if (Logz.elapsingMode == Elapse.TIME)
//          Log.v(Logz.tag, "⌬ " + getTime());
//        else if (Logz.elapsingMode == Elapse.ELAPSED)
        Log.v(Logz.tag, "⌬ " + "(⏳ " + minus / 1000 + "s)");
      }
      lastLog = System.currentTimeMillis();
    }
  }

  private static String getTime() {
    String result;
    if (Logz.timeFormat.equals(Time.STAMP.getFormat())) {
      String timeMillis = String.valueOf(System.currentTimeMillis());
      result = timeMillis.substring(0, timeMillis.length() - 3) + "″" + timeMillis.substring(timeMillis.length() - 3) + "‴";
    } else {
      Calendar calendar = Calendar.getInstance();
      SimpleDateFormat simpleDateFormat;
      try {
        simpleDateFormat = new SimpleDateFormat(Logz.timeFormat, Locale.ENGLISH);
      } catch (IllegalArgumentException e) {
        simpleDateFormat = new SimpleDateFormat(Time.CLOCK.getFormat(), Locale.ENGLISH);
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

  static String getOffset(String info) {
    int len = info.length();
    char[] chars = new char[len];
    Arrays.fill(chars, ' ');
    return new String(chars);
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

//  /**
//   * ¹²³⁴⁵⁶⁷⁸⁹⁰
//   * 𝟷𝟸𝟹𝟺𝟻𝟼𝟽𝟾𝟿𝟶
//   */
//  // .matches("[A-Za-z0-9 ]*");
//  private static String setLittle(String text) {
//    return text
//      .replaceAll("0", "⁰")
//      .replaceAll("1", "¹")
//      .replaceAll("2", "²")
//      .replaceAll("3", "³")
//      .replaceAll("4", "⁴")
//      .replaceAll("5", "⁵")
//      .replaceAll("6", "⁶")
//      .replaceAll("7", "⁷")
//      .replaceAll("8", "⁸")
//      .replaceAll("9", "⁹");
//  }

  /**
   * 𝐀𝐁𝐂𝐃𝐄𝐅𝐆𝐇𝐈𝐉𝐊𝐋𝐌𝐍𝐎𝐏𝐐𝐑𝐒𝐓𝐔𝐕𝐖𝐗𝐘𝐙 𝐚𝐛𝐜𝐝𝐞𝐟𝐠𝐡𝐢𝐣𝐤𝐥𝐦𝐧𝐨𝐩𝐪𝐫𝐬𝐭𝐮𝐯𝐰𝐱𝐲𝐳
   * 𝟎𝟏𝟐𝟑𝟒𝟓𝟔𝟕𝟖𝟗
   * .
   * 𝗔𝗕𝗖𝗗𝗘𝗙𝗚𝗛𝗜𝗝𝗞𝗟𝗠𝗡𝗢𝗣𝗤𝗥𝗦𝗧𝗨𝗩𝗪𝗫𝗬𝗭 𝗮𝗯𝗰𝗱𝗲𝗳𝗴𝗵𝗶𝗷𝗸𝗹𝗺𝗻𝗼𝗽𝗾𝗿𝘀𝘁𝘂𝘃𝘄𝘅𝘆𝘇
   * 𝟬𝟭𝟮𝟯𝟰𝟱𝟲𝟳𝟴𝟵
   * .
   * 𝘈𝘉𝘊𝘋𝘌𝘍𝘎𝘏𝘐𝘑𝘒𝘓𝘔𝘕𝘖𝘗𝘘𝘙𝘚𝘛𝘜𝘝𝘞𝘟𝘠𝘡 𝘢𝘣𝘤𝘥𝘦𝘧𝘨𝘩𝘪𝘫𝘬𝘭𝘮𝘯𝘰𝘱𝘲𝘳𝘴𝘵𝘶𝘷𝘸𝘹𝘺𝘻
   * 0123456789
   * .
   * 𝘼𝘽𝘾𝘿𝙀𝙁𝙂𝙃𝙄𝙅𝙆𝙇𝙈𝙉𝙊𝙋𝙌𝙍𝙎𝙏𝙐𝙑𝙒𝙓𝙔𝙕 𝙖𝙗𝙘𝙙𝙚𝙛𝙜𝙝𝙞𝙟𝙠𝙡𝙢𝙣𝙤𝙥𝙦𝙧𝙨𝙩𝙪𝙫𝙬𝙭𝙮𝙯
   * 0123456789
   */
  // .matches("[A-Za-z0-9 ]*");
  private static String setFont(String text) {
//    return text
//      .replaceAll("0", "0")
//      .replaceAll("1", "1")
//      .replaceAll("2", "2")
//      .replaceAll("3", "3")
//      .replaceAll("4", "4")
//      .replaceAll("5", "5")
//      .replaceAll("6", "6")
//      .replaceAll("7", "7")
//      .replaceAll("8", "8")
//      .replaceAll("9", "9")
//      .replaceAll("a", "𝘢")
//      .replaceAll("b", "𝘣")
//      .replaceAll("c", "𝘤")
//      .replaceAll("d", "𝘥")
//      .replaceAll("e", "𝘦")
//      .replaceAll("f", "𝘧")
//      .replaceAll("g", "𝘨")
//      .replaceAll("h", "𝘩")
//      .replaceAll("i", "𝘪")
//      .replaceAll("j", "𝘫")
//      .replaceAll("k", "𝘬")
//      .replaceAll("l", "𝘭")
//      .replaceAll("m", "𝘮")
//      .replaceAll("n", "𝘯")
//      .replaceAll("o", "𝘰")
//      .replaceAll("p", "𝘱")
//      .replaceAll("q", "𝘲")
//      .replaceAll("r", "𝘳")
//      .replaceAll("s", "𝘴")
//      .replaceAll("t", "𝘵")
//      .replaceAll("u", "𝘶")
//      .replaceAll("v", "𝘷")
//      .replaceAll("w", "𝘸")
//      .replaceAll("x", "𝘹")
//      .replaceAll("y", "𝘺")
//      .replaceAll("z", "𝘻")
//      .replaceAll("A", "𝘈")
//      .replaceAll("B", "𝘉")
//      .replaceAll("C", "𝘊")
//      .replaceAll("D", "𝘋")
//      .replaceAll("E", "𝘌")
//      .replaceAll("F", "𝘍")
//      .replaceAll("G", "𝘎")
//      .replaceAll("H", "𝘏")
//      .replaceAll("I", "𝘐")
//      .replaceAll("J", "𝘑")
//      .replaceAll("K", "𝘒")
//      .replaceAll("L", "𝘓")
//      .replaceAll("M", "𝘔")
//      .replaceAll("N", "𝘕")
//      .replaceAll("O", "𝘖")
//      .replaceAll("P", "𝘗")
//      .replaceAll("Q", "𝘘")
//      .replaceAll("R", "𝘙")
//      .replaceAll("S", "𝘚")
//      .replaceAll("T", "𝘛")
//      .replaceAll("U", "𝘜")
//      .replaceAll("V", "𝘝")
//      .replaceAll("W", "𝘞")
//      .replaceAll("X", "𝘟")
//      .replaceAll("Y", "𝘠")
//      .replaceAll("Z", "𝘡");
    return text
      .replaceAll("0", "\uD835\uDFEC")
      .replaceAll("1", "\uD835\uDFED")
      .replaceAll("2", "\uD835\uDFEE")
      .replaceAll("3", "\uD835\uDFEF")
      .replaceAll("4", "\uD835\uDFF0")
      .replaceAll("5", "\uD835\uDFF1")
      .replaceAll("6", "\uD835\uDFF2")
      .replaceAll("7", "\uD835\uDFF3")
      .replaceAll("8", "\uD835\uDFF4")
      .replaceAll("9", "\uD835\uDFF5")
      .replaceAll("a", "\uD835\uDDEE")
      .replaceAll("b", "\uD835\uDDEF")
      .replaceAll("c", "\uD835\uDDF0")
      .replaceAll("d", "\uD835\uDDF1")
      .replaceAll("e", "\uD835\uDDF2")
      .replaceAll("f", "\uD835\uDDF3")
      .replaceAll("g", "\uD835\uDDF4")
      .replaceAll("h", "\uD835\uDDF5")
      .replaceAll("i", "\uD835\uDDF6")
      .replaceAll("j", "\uD835\uDDF7")
      .replaceAll("k", "\uD835\uDDF8")
      .replaceAll("l", "\uD835\uDDF9")
      .replaceAll("m", "\uD835\uDDFA")
      .replaceAll("n", "\uD835\uDDFB")
      .replaceAll("o", "\uD835\uDDFC")
      .replaceAll("p", "\uD835\uDDFD")
      .replaceAll("q", "\uD835\uDDFE")
      .replaceAll("r", "\uD835\uDDFF")
      .replaceAll("s", "\uD835\uDE00")
      .replaceAll("t", "\uD835\uDE01")
      .replaceAll("u", "\uD835\uDE02")
      .replaceAll("v", "\uD835\uDE03")
      .replaceAll("w", "\uD835\uDE04")
      .replaceAll("x", "\uD835\uDE05")
      .replaceAll("y", "\uD835\uDE06")
      .replaceAll("z", "\uD835\uDE07")
      .replaceAll("A", "\uD835\uDDD4")
      .replaceAll("B", "\uD835\uDDD5")
      .replaceAll("C", "\uD835\uDDD6")
      .replaceAll("D", "\uD835\uDDD7")
      .replaceAll("E", "\uD835\uDDD8")
      .replaceAll("F", "\uD835\uDDD9")
      .replaceAll("G", "\uD835\uDDDA")
      .replaceAll("H", "\uD835\uDDDB")
      .replaceAll("I", "\uD835\uDDDC")
      .replaceAll("J", "\uD835\uDDDD")
      .replaceAll("K", "\uD835\uDDDE")
      .replaceAll("L", "\uD835\uDDDF")
      .replaceAll("M", "\uD835\uDDE0")
      .replaceAll("N", "\uD835\uDDE1")
      .replaceAll("O", "\uD835\uDDE2")
      .replaceAll("P", "\uD835\uDDE3")
      .replaceAll("Q", "\uD835\uDDE4")
      .replaceAll("R", "\uD835\uDDE5")
      .replaceAll("S", "\uD835\uDDE6")
      .replaceAll("T", "\uD835\uDDE7")
      .replaceAll("U", "\uD835\uDDE8")
      .replaceAll("V", "\uD835\uDDE9")
      .replaceAll("W", "\uD835\uDDEA")
      .replaceAll("X", "\uD835\uDDEB")
      .replaceAll("Y", "\uD835\uDDEC")
      .replaceAll("Z", "\uD835\uDDED");
  }

}