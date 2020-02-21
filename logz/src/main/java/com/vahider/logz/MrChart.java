package com.vahider.logz;


import java.text.DecimalFormat;
import java.util.Arrays;

class MrChart {

  static void chart(double... yPoints) {
    if (Logz.enable) {
      if (yPoints != null) {
        StringBuilder result = new StringBuilder(MrLog.setTitleStyle(Arrays.toString(yPoints)));

        if (yPoints.length > 0) {
          final int pointCount = yPoints.length;
          final int countLineY = 10;
          final int offsetX = 2;

          int maxLengthY = 0;
          double maxValueY = yPoints[0];
          double minValueY = yPoints[0];
          for (double yPoint : yPoints) {
            if ((yPoint + "   ").length() > maxLengthY) maxLengthY = (yPoint + "   ").length();
            if ((yPoint + "   ").length() > maxLengthY) maxLengthY = (yPoint + "   ").length();
            if (yPoint > maxValueY) maxValueY = yPoint;
            if (yPoint < minValueY) minValueY = yPoint;
          }

          double offsetMaxMinY = maxValueY - minValueY;
          for (int i = 0; i < yPoints.length; i++) {
            double mande = yPoints[i] - minValueY;
            yPoints[i] = (int) ((mande * countLineY) / offsetMaxMinY);
          }

          StringBuilder[] listLineY = new StringBuilder[countLineY];
          for (int line = 0; line < countLineY; line++) {
            listLineY[line] = new StringBuilder();
          }

          String spaceOffsetX = fillSpace(' ', offsetX - 1, 0);
          for (double yPoint : yPoints) {
            boolean showed = false;
//        float whichLog = yPoint / valueOffsetY;
//        for (int line = countLineY - 1; line >= 0; line--) {
//          if (yPoint == line + 1)
//            listLineY[line].append(spaceOffsetX).append("┃");
//          else
//            listLineY[line].append(spaceOffsetX).append(" ");
//        }
            for (int line = countLineY - 1; line >= 0; line--) {
              if (yPoint == line + 1) {
                listLineY[line].append(spaceOffsetX).append("┃");
                showed = true;
              } else {
                if (showed)
                  listLineY[line].append(spaceOffsetX).append("┃");
                else
                  listLineY[line].append(spaceOffsetX).append(" ");
              }
            }
          }

          String spaceNumbers = fillSpace('━', maxLengthY, 0);
          String lineBox = fillSpace('━', pointCount * offsetX - 1, 0);

          result.append(Logz.ENTER).append("┏").append(spaceNumbers).append(lineBox).append("━━━┑");

          int decimalCount = getDecimalCount(minValueY);
          for (int line = countLineY - 1; line >= 0; line--) {
            double titleValue = tinyDecimal(minValueY + ((offsetMaxMinY / (countLineY - 1)) * line), decimalCount);
            result.append(Logz.ENTER).append("┣ ").append(titleValue).append(fillSpace(' ', maxLengthY, String.valueOf(titleValue).length())).append(listLineY[line].toString());
          }

          result.append(Logz.ENTER).append("┗").append(spaceNumbers).append(lineBox).append("━━━┙");

          MrLog.show(result, 1);
        }
      } else {
        MrLog.error("Chart points are", "null", 1);
      }
    }
  }

//  static void chart(int... yPoints) {
//    MrLog.show(Arrays.toString(yPoints), 1);
//
//    if (yPoints.length > 0) {
//      final int pointCount = yPoints.length;
//      final int minXLine = 50;
//      final int minYLine = 4;
//      final int maxYLine = 15;
//
//      int offsetX;
//      if (pointCount < minXLine)
//        offsetX = minXLine / pointCount;
//      else
//        offsetX = 1;
//
//      int lengthMaxY = 0;
//      for (int yPoint : yPoints) if (yPoint > lengthMaxY) lengthMaxY = yPoint;
//      int countLineY;
//      int valueOffsetY;
//      if (lengthMaxY < minYLine) {
//        countLineY = minYLine;
//        valueOffsetY = lengthMaxY / minYLine;
//      } else if (lengthMaxY > maxYLine) {
//        countLineY = maxYLine;
//        valueOffsetY = lengthMaxY / maxYLine;
//      } else {
//        countLineY = lengthMaxY;
//        valueOffsetY = 1;
//      }
//
//      StringBuilder[] listLineY = new StringBuilder[countLineY];
//      for (int line = 0; line < countLineY; line++) {
//        listLineY[line] = new StringBuilder();
//      }
//
//      String spaceOffsetX = fillSpace(' ', offsetX - 1, 0);
//      for (int yPoint : yPoints) {
//        boolean showed = false;
//        int whichLog = yPoint / valueOffsetY;
//        for (int line = countLineY - 1; line >= 0; line--) {
//          if (whichLog == line + 1) {
//            listLineY[line].append(fillSpace(' ', offsetX - 1, 0)).append("☉");
//            showed = true;
//          } else {
//            if (showed)
//              listLineY[line].append(spaceOffsetX).append("┃");
//            else
//              listLineY[line].append(spaceOffsetX).append(" ");
//          }
//        }
//      }
//
//      String spaceMaxY = fillSpace('━', (lengthMaxY + "   ").length(), 0);
//      StringBuilder lineBox = new StringBuilder();
//      for (int x = 0; x < listLineY[0].length(); x += offsetX) {
//        lineBox.append(fillSpace('━', offsetX - 1, 0)).append("━");
//      }
//
//      MrLog.show("┏" + spaceMaxY + lineBox.toString() + "━┑", 1);
//
//      for (int line = countLineY - 1; line >= 0; line--) {
//        int titleValue = ((line + 1) * valueOffsetY);
//        MrLog.show("┣ " + titleValue + fillSpace(' ', (lengthMaxY + "  ").length(), String.valueOf(titleValue).length()) + listLineY[line].toString(), 1);
//      }
//
//      MrLog.show("┗" + spaceMaxY + lineBox.toString() + "━┙", 1);
//    }
//  }

  private static String fillSpace(char repeat, int max, int length) {
    char[] chars = new char[max - length];
    Arrays.fill(chars, repeat);
    return new String(chars);
  }

  private static int getDecimalCount(double number) {
    String text = Double.toString(Math.abs(number));
    int integerPlaces = text.indexOf('.');
    return text.length() - integerPlaces - 1;
  }

  public static double tinyDecimal(double number, int decimalCount) {
    char[] chars = new char[decimalCount];
    Arrays.fill(chars, '#');
    String newNumber = new DecimalFormat("#" + (decimalCount > 0 ? "." : "") + new String(chars)).format(number);
    return Double.parseDouble(newNumber);
  }
}