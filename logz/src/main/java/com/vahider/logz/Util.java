package com.vahider.logz;

import android.view.View;

import com.vahider.logz.enums.Case;

import java.util.Arrays;

public class Util {

  static String setTitleStyle(String text) {
    if (!text.isEmpty()) {
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
        else
          builder.append(t.toUpperCase()).append(space);
      }

      String result = builder.toString();
      return setFont(result) + ": ";
    }
    return "";
  }

  static Object checkNullViewArray(Object object) {
    if (object == null)
      return "null";
    if (Logz.used) {
      if (Logz.viewDetection && object instanceof View) {
        View view = (View) object;
        String id = "-";
        if (view.getId() != View.NO_ID)
          id = view.getContext().getResources().getResourceEntryName(view.getId());
        return view.getClass().getSimpleName() + "(" + id + ")";
      }
      if (object.getClass().isArray()) {
        if (object instanceof View[]) {
          View[] views = ((View[]) object);
          StringBuilder result = new StringBuilder("{");
          for (View view : views) {
            result.append(Util.checkNullViewArray(view).toString());
            if (view != views[views.length - 1])
              result.append(", ");
          }
          result.append("}");
          return result.toString();
        } else {
          // Integer applied on object[]
          if (object instanceof long[])
            return Arrays.toString((long[]) object);
          else if (object instanceof int[])
            return Arrays.toString((int[]) object);
          else if (object instanceof short[])
            return Arrays.toString((short[]) object);
          else if (object instanceof byte[])
            return Arrays.toString((byte[]) object);
          else if (object instanceof double[])
            return Arrays.toString((double[]) object);
          else if (object instanceof float[])
            return Arrays.toString((float[]) object);
          else if (object instanceof char[])
            return Arrays.toString((char[]) object);
          else if (object instanceof boolean[])
            return Arrays.toString((boolean[]) object);
          else if (object instanceof Object[])
            return Arrays.toString((Object[]) object);
//      else if (logList instanceof String[])
//        return Arrays.toString((long[]) logList);
        }
      }
    }
    return object;
  }

  static String fillSpace(char repeat, int length) {
    if (length >= 0) {
      char[] chars = new char[length];
      Arrays.fill(chars, repeat);
      return new String(chars);
    }
    return "";
  }

  static String fixSpaceExtra(String text, char repeat, int max) { // for Decimal
    if (text.length() < max) {
      String fixSpace = fillSpace(repeat, max - text.length());
      return text + fixSpace;
    }
    return text;
  }

  // .matches("[A-Za-z0-9 ]*");
  private static String setFont(String text) {
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
