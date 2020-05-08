package com.vahider.logz;


import android.view.View;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MrList {

  private static StringBuilder result;

  static void list(String title, Object logList) {
    if (Logz.enable) {
      result = new StringBuilder(Util.setTitleStyle(title));

      // Array
      if (logList.getClass().isArray())
        openArrayContent(logList);

        // Map
      else if (logList instanceof Map)
        openMapContent(logList);

        // Set
      else if (logList instanceof Set)
        openSetContent(logList);

        // List
      else if (logList instanceof List)
        openListContent(logList);

      else {
        MrLog.error("List Not Valid", logList, 1);
        return;
      }

      MrLog.show(result, 1);
    }
  }

  static void openArrayContent(Object logList) {
    if (logList instanceof View[]) {
      View[] views = ((View[]) logList);
      result.append("[");
      for (View view : views) {
        result.append(Util.safeDetection(view).toString());
        if (view != views[views.length - 1])
          result.append(", ");
      }
      result.append("]");
    } else {
      result.append(Arrays.toString(((Object[]) logList)));
    }
  }

  static void openMapContent(Object logList) {
    Map map = ((Map) logList);
    result.append("{");
    Iterator it = map.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry) it.next();
      result.append(Util.safeDetection(pair.getKey())).append(":").append(Util.safeDetection(pair.getValue()));
      if (it.hasNext())
        result.append(", ");
      it.remove(); // avoids a ConcurrentModificationException
    }
    result.append("}");
  }

  static void openSetContent(Object logList) {
    result.append(Arrays.toString(((Set) logList).toArray()));
  }

  static void openListContent(Object logList) {
    // MrLog.show(Arrays.toString(((List) logList).toArray()), 2);
    List list = ((List) logList);
    result.append("[");
    for (Object object : list) {
      result.append(Util.safeDetection(object).toString());
      if (object != list.get(list.size() - 1))
        result.append(", ");
    }
    result.append("]");
  }
}