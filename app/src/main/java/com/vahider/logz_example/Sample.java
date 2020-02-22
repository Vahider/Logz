package com.vahider.logz_example;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.vahider.logz.Logz;
import com.vahider.logz.enums.Case;
import com.vahider.logz.enums.Info;
import com.vahider.logz.enums.Summary;
import com.vahider.logz.enums.Time;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class Sample extends AppCompatActivity {

  private final boolean USED = true;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample);

    new Logz.Builder()
      .setTag("LOGZ")
      .setEnable(true)
      .setUsed(USED)
      .showInfo(true)
      .setInfoClickable(false)
      .setTimeFormat(Time.CLOCK)
      .setInfoMode(Info.CLASS, Info.METHOD, Info.LINE)
      .useSummaryMode(Summary.START)
      .setTitleCase(Case.CAMEL_SPACE)
      .showElapsing(true)
      .useViewDetection(true)
      .reload();

    runExamples();
//    githubCompare();

  }

  private void githubCompare() {
    Logz.line();
    Logz.v("V is Gray", "Low level Log");
    Logz.d("D is Yellow", "Clear log");
    Logz.i("I is Indigo", "Normal info Log");
    Logz.w("W is Orange", "Warning Log");
    Logz.e("E is Red", "Danger Log");
    Logz.line();

    ///////////////////////////////////////////////////////

    List list = new ArrayList();
    list.add(1);
    list.add("a");
    list.add(true);
    list.add(null);
    list.add(new EditText(this));
    String json = "{\"name\":\"Ram\", \"email\":\"Ram@gmail.com\"}";
    double[] doubleArray = new double[]{8, 4, 6, 9, 1, 0, -3, 6, -1, 7, 8, -4, 6, 2, 1, 0, -3, 6, -1, 7, 8, 4, 6, -1, -5};
    TextView mTvHomeLogo = findViewById(R.id.tv_home_logo);

    Logz.line("logz  examples");

    Logz.i("title", "with title");

    Logz.v("Without title");
    Logz.d(12345);
    Logz.i(true);
    Logz.w(null);
    Logz.e(mTvHomeLogo);

    Logz.is("fast and clear");

    Logz.list(list); // List
    Logz.json(json); // String
    Logz.chart(doubleArray); // double[]

    Logz.line();

    ////////////////////////////////

    Log.i("TAG", "-------------Default log example-----------");

    Log.v("TAG", "String: " + "with title");

    Log.v("TAG", "Without title");
    Log.d("TAG", "" + 12345);
    Log.i("TAG", "" + true);
    // Log.w("TAG", null); // crashed
    Log.e("TAG", "" + mTvHomeLogo);

    Log.d("TAG", "************ not fast maybe clear");

    Log.d("TAG", "" + list);
    Log.d("TAG", json);
    Log.d("TAG", "" + doubleArray);

    Log.i("TAG", "--------------------------------");
  }

  private void runExamples() {

    Logz.line("Examples");
    Logz.line("Hello Worldddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
    Logz.line();
    Logz.line(" ");
    Logz.line("");
    Logz.line(null);
    Logz.line(new TextView(this));

    Logz.v(Logz.getTag());
    Logz.d(Logz.getTag());
    Logz.i(Logz.getTag());
    Logz.w(Logz.getTag());
    Logz.e(Logz.getTag());

    Logz.is(1);

    Logz.i(null);
    Logz.i(new TextView(this));

    List list = new ArrayList();
    list.add(1);
    list.add("a");
    list.add(true);
    list.add(null);
    list.add(new EditText(this));
    Logz.list(list);
    HashMap list2 = new HashMap();
    list2.put("a", "a");
    list2.put("b", 2);
    list2.put("c", true);
    list2.put("d", new EditText(this));
    Logz.list("List is", list2);
    Logz.list(new EditText[]{new EditText(this), new EditText(this), null});
    Logz.list(new String[]{"a", "b", null});
    Logz.list(null);
    Logz.list(new TextView(this));

    String json = "[{\"name\":\"Ram\", \"email\":\"Ram@gmail.com\"},{\"name\":\"Bob\", \"email\":\"bob32@gmail.com\"}]";
    try {
      JSONArray array = new JSONArray(json);
      Logz.json(array);
    } catch (Throwable t) {
    }
    Logz.json("Json is", json);
    Logz.json("");
    Logz.json(null);
    Logz.json(new TextView(this));

    Logz.chart(132.4, 702.4, 502.4, 412.4, 592.4, 322.4, 802.4, 702.4, 502.4, 412.4, 592.4, 322.4, 802.4, 702.4, 502.4, 412.4, 592.4, 322.4, 802.4, 702.4, 502.4, 412.4, 592.4, 322.4, 802.4);
    Logz.chart(1);
    Logz.chart(0, 0);
    Logz.chart(-10, -50, -23, -50, 2);
    Logz.chart(-40.4562, -2.123);
    Logz.chart(0.00123, 0.00042);
    Logz.chart(null);
    Logz.chart();

//    long t1 = System.currentTimeMillis();
//    for (int i = 0; i < 1000; i++)
//      Logz.i("Salam" + i); // Logz log
//    long t2 = System.currentTimeMillis();
//    for (int i = 0; i < 1000; i++)
//      Log.i("LOGZ", "Salam" + i); // Normal log
//    long t3 = System.currentTimeMillis();
//    Logz.i("1000 logs with Logz with used logz: " + USED , " "+(t2 - t1) + "ms");
//    Logz.i("1000 logs with normal log", t3 - t2 + "ms");

//    W: 1: 1582177455540
//    W: 2: 1582177456529 = 989
//    W: 3: 1582177456539 = 10

//    W: 1: 1582177609682
//    W: 2: 1582177609695 = 13
//    W: 3: 1582177609706 = 11

    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
         throw null; // in main thread
      }
    }, 4000);
//    throw null;
  }
}
