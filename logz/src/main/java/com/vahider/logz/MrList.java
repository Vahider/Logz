package com.vahider.logz;


import android.view.View;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MrList {

  private static StringBuilder result;

//  static void list(Object logList) {
//    if (Logz.enable)
//      logList("", Logz.safeDetection(logList));
//  }

  static void list(String title, Object logList) {
    if (Logz.enable) {
      result = new StringBuilder(MrLog.setTitleStyle(title));

      // Array
      if (logList.getClass().isArray()) {
        if (logList instanceof View[]) {
          View[] views = ((View[]) logList);
          result.append("[");
          for (View view : views) {
            result.append(Logz.safeDetection(view).toString());
            if (view != views[views.length - 1])
              result.append(", ");
          }
          result.append("]");
        } else {
          result.append(Arrays.toString(((Object[]) logList)));
        }

        // Map
      } else if (logList instanceof Map) {
        Map map = ((Map) logList);
        result.append("{");
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
          Map.Entry pair = (Map.Entry) it.next();
          result.append(Logz.safeDetection(pair.getKey())).append(":").append(Logz.safeDetection(pair.getValue()));
          if (it.hasNext())
            result.append(", ");
          it.remove(); // avoids a ConcurrentModificationException
        }
        result.append("}");

        // Set
      } else if (logList instanceof Set) {
        result.append(Arrays.toString(((Set) logList).toArray()));

        // List
      } else if (logList instanceof List) {
//        MrLog.show(Arrays.toString(((List) logList).toArray()), 2);
        List list = ((List) logList);
         result.append("[");
        for (Object object : list) {
          result.append(Logz.safeDetection(object).toString());
          if (object != list.get(list.size() - 1))
            result.append(", ");
        }
        result.append("]");

      } else {
        MrLog.error("List Not Valid", logList, 1);
        return;
      }

      MrLog.show(result, 1);
    }
  }
}