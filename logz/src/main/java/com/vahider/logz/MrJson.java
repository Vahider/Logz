package com.vahider.logz;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Arrays;
import java.util.Iterator;

class MrJson {

  private static StringBuilder result;

  static void json(Object title, Object logList) {
    if (Logz.enable) {
      result = new StringBuilder(Util.setTitleStyle(title.toString()));
      draw(logList);
    }
  }

  private static void draw(Object logJson) {
    if (Logz.enable) {
      try {
        Object json = new JSONTokener(logJson.toString()).nextValue();
        if (json instanceof JSONObject) {
          iJson("{");

        } else if (json instanceof JSONArray) {
          iJson("[");

        } else {
          MrLog.error("Json not valid", logJson, 2);
          return;
        }
        if (json instanceof JSONObject) {
          JSONObject getJson = new JSONObject(json.toString());
          readJsonObject(getJson, 0);
        } else if (json instanceof JSONArray) {
          JSONArray getJson = new JSONArray(json.toString());
          readJsonArray(getJson, 0);
        }

        MrLog.show(result, 2);
      } catch (JSONException e) {
        MrLog.error("Json not valid", logJson, 2);
        // e.printStackTrace();
      }
    }
  }

  private static void iJson(String json) {
    result.append(Logz.ENTER).append("│").append(json);
  }

  private static void readJsonObject(JSONObject jsonObject, int level) throws JSONException {
    level += 1;
    Iterator<String> itrator = jsonObject.keys();
    while (itrator.hasNext()) {
      String name = itrator.next();

      if (jsonObject.get(name) instanceof JSONObject) {
        iJson(getJsonOffset(level) + detectJsonClass(name) + " {");
        JSONObject getJson = new JSONObject(jsonObject.get(name).toString());
        readJsonObject(getJson, level);

      } else if (jsonObject.get(name) instanceof JSONArray) {
        iJson("│" + getJsonOffset(level) + detectJsonClass(name) + " [");
        JSONArray getJson = new JSONArray(jsonObject.get(name).toString());
        readJsonArray(getJson, level);

      } else {
        iJson(getJsonOffset(level) + detectJsonClass(name) + " : " + detectJsonClass(jsonObject.get(name)));
      }

      if (!itrator.hasNext())
        iJson(getJsonOffset(level - 1) + "}");
    }
  }

  private static void readJsonArray(JSONArray jsonArray, int level) throws JSONException {
    level += 1;
    for (int i = 0; i < jsonArray.length(); i++) {
      Object json = jsonArray.get(i);

      if (json instanceof JSONObject) {
        iJson(getJsonOffset(level) + i + " {");
        JSONObject getJson = new JSONObject(json.toString());
        readJsonObject(getJson, level);

      } else if (json instanceof JSONArray) {
        iJson(getJsonOffset(level) + i + " [");
        JSONArray getJson = new JSONArray(json.toString());
        readJsonArray(getJson, level);

      } else {
        iJson(getJsonOffset(level) + i + " : " + detectJsonClass(json.toString()));
      }

      if (i == jsonArray.length() - 1)
        iJson(getJsonOffset(level - 1) + "]");
    }
  }

  private static String getJsonOffset(int space) {
    char[] chars = new char[space * 4];
    Arrays.fill(chars, ' ');
    return new String(chars);
  }

  private static String detectJsonClass(Object json) {
    if (json instanceof String) {
      return "\"" + json + "\"";
    } else
      return json.toString();
  }
}