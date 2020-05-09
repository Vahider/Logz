package com.vahider.logz;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

class MrChart {

  static void chart(double... yPoints) {
    if (Logz.enable) {
      if (yPoints != null) {
        StringBuilder result = new StringBuilder(Util.setTitleStyle(Arrays.toString(yPoints)));

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

          String spaceOffsetX = Util.fillSpace(' ', offsetX - 1);
          for (double yPoint : yPoints) {
            boolean showed = false;
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

          String spaceNumbers = Util.fillSpace('━', maxLengthY);
          String lineBox = Util.fillSpace('━', pointCount * offsetX - 1);

          result.append(Logz.ENTER).append("𝘭┏").append(spaceNumbers).append(lineBox).append("━━━┑");

          int decimalCount = getDecimalCount(minValueY);
          for (int line = countLineY - 1; line >= 0; line--) {
            double titleValue = tinyDecimal(minValueY + ((offsetMaxMinY / (countLineY - 1)) * line), decimalCount);
            result.append(Logz.ENTER).append("𝘭┣ ").append(titleValue).append(Util.fillSpace(' ', maxLengthY - String.valueOf(titleValue).length())).append(listLineY[line].toString());
          }

          result.append(Logz.ENTER).append("𝘭┗").append(spaceNumbers).append(lineBox).append("━━━┙");

          MrLog.show(result, 1);
        }
      } else {
        MrLog.error("Chart is", yPoints, 1);
      }
    }
  }

  private static int getDecimalCount(double number) {
    String text = Double.toString(Math.abs(number));
    int integerPlaces = text.indexOf('.');
    return text.length() - integerPlaces - 1;
  }

  public static double tinyDecimal(double number, int decimalCount) {
    char[] chars = new char[decimalCount];
    Arrays.fill(chars, '#');
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
    String newNumber = new DecimalFormat("#" + (decimalCount > 0 ? "." : "") + new String(chars), symbols).format(number);
    return Double.parseDouble(newNumber);
  }
}