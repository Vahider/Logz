package com.vahider.logz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

class MrTable {

  private static final int maxWord = 100;

  static void table(List rowModel, String... columnMethods) {
    if (rowModel == null) {
      MrLog.error("Table, Rows not valid", rowModel, 1);
    } else if (columnMethods == null) {
      MrLog.error("Table, ColumnMethods not valid", columnMethods, 1);
    } else {
      for (int i = 0; i < columnMethods.length; i++)
        columnMethods[i] = String.valueOf(Util.checkNullViewArray(columnMethods[i]));
      draw(rowModel, columnMethods);
    }
  }

  private static void draw(List rowModel, String... columnMethods) {

    // Method 1
    try {
      int[] maxWordPerColumn = new int[columnMethods.length];

      // Get max length from every column
      for (int i = 0; i < columnMethods.length; i++) {
        if (columnMethods[i].length() > maxWord)
          maxWordPerColumn[i] = maxWord;
        else if (columnMethods[i].length() > maxWordPerColumn[i])
          maxWordPerColumn[i] = columnMethods[i].length();

        for (Object row : rowModel) {
          Method method = row.getClass().getMethod(columnMethods[i]);
          String desc = String.valueOf(method.invoke(row));

          if (desc.length() > maxWord)
            maxWordPerColumn[i] = maxWord;
          else if (desc.length() > maxWordPerColumn[i])
            maxWordPerColumn[i] = desc.length();
        }
      }

      // Columns
      StringBuilder title = new StringBuilder();
      for (int i = 0; i < columnMethods.length; i++) {
        String text = columnMethods[i];
        if (text.length() > maxWord)
          text = text.substring(0, maxWord - 1) + "‥"; // 1 * '‥'
        String space = Util.fillSpace(' ', (maxWordPerColumn[i] - text.length()) / 2);
        String newColumn = "ǁ" + space + " " + text + " " + space; // ǀǁ \u0009(4chars spaces) are utf-8
        newColumn = Util.fixSpaceExtra(newColumn, ' ', maxWordPerColumn[i] + 3); // 1 "┃" and 2 " "
        title.append(newColumn);
      }
      title.append("ǁ");
      int lineLength = title.length() - 2; // 2 "┃"

      // '𝘭Ⅰᶥᶧ' for ltr sentence
      StringBuilder result = new StringBuilder();
      result.append(Logz.LOG_ENTER).append("╔").append(Util.fillSpace('═', lineLength)).append("╗");
      result.append(Logz.LOG_ENTER).append(title.toString());
      result.append(Logz.LOG_ENTER).append("╠").append(Util.fillSpace('═', lineLength)).append("╣");

      // Rows
      for (Object row : rowModel) {
        StringBuilder desc = new StringBuilder();
        for (int i = 0; i < columnMethods.length; i++) {
          Method method = row.getClass().getMethod(columnMethods[i]);
          String text = String.valueOf(method.invoke(row));
          if (text.length() > maxWord)
            text = text.substring(0, maxWord - 1) + "‥"; // 1 * '‥'
          String space = Util.fillSpace(' ', (maxWordPerColumn[i] - text.length()) / 2);
          String newRow = "ǁ" + space + " " + text + " " + space;
          newRow = Util.fixSpaceExtra(newRow, ' ', maxWordPerColumn[i] + 3); // 1 "┃" and 2 " "
          desc.append(newRow);
        }
        if (!Logz.limitedLog && result.length() + desc.length() > 3000) {
          MrLog.show(result, 2);
          result = new StringBuilder();
        }
        result.append(Logz.LOG_ENTER).append(desc).append("ǁ");
      }
      result.append(Logz.LOG_ENTER).append("╚").append(Util.fillSpace('═', lineLength)).append("╝");
      MrLog.show(result, 2);

    } catch (NullPointerException e) {
      MrLog.error("Table, Some values are null", rowModel, 2);
    } catch (IllegalAccessException e) {
      MrLog.error("Table, Some methods are private", e.getMessage(), 2);
    } catch (NoSuchMethodException e) {
      MrLog.error("Table, Some methods were not found", e.getMessage(), 2);
    } catch (InvocationTargetException e) {
      MrLog.error("Table", e.getMessage(), 2);
    }
  }
}