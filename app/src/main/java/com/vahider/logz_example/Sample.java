package com.vahider.logz_example;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vahider.logz.Logz;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class Sample extends AppCompatActivity {

  private final boolean USED = true;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample);

//    new Logz.Builder()
//      .setTag("LOGZ")
//      .setEnable(true)
//      .setUsed(USED)
//      .showInfo(true)
//      .setInfoClickable(true)
//      .setTimeFormat(TimeMode.CLOCK)
//      .setInfoMode(Info.CLASS, Info.METHOD, Info.LINE)
//      .useSummaryMode(Summary.START)
//      .setTitleCase(Case.CAMEL_SPACE)
//      .showElapsing(true)
//      .useViewDetection(true)
//      .setLimitLength(true)
//      .reload();

//    Logz.is("Hello world");

    runExamples();
//    githubCompare();

  }

  private void githubCompare() {

    Logz.line("Color");
    Logz.v("V is Gray", "Low level Log");
    Logz.d("D is Yellow", "Clear log");
    Logz.i("I is Indigo", "Normal info Log");
    Logz.w("W is Orange", "Warning Log");
    Logz.e("E is Red", "Danger Log");

    ///////////////////////////////////////////////////////

    // region data
    Object[] array = new Object[]{1, "Saeed", true, null};
    HashMap map = new HashMap();
    map.put(1, "Ali");
    map.put(2, "Bibi");
    map.put(3, "Saeed");
    List list = new ArrayList();
    list.add(1);
    list.add("a");
    list.add(true);
    list.add(null);
    list.add(new EditText(this));
    String json = "{\"name\":\"Ram\", \"email\":\"Ram@gmail.com\"}";
    double[] doubleArray = new double[]{8, 4, 6, 9, 1, 0, -3, 6, -1, 7, 8, -4, 6, 2, 1, 0, -3, 6, -1, 7, 8, 4, 6, -1, -5};
    TextView mTvHomeLogo = findViewById(R.id.tv_home_logo);
    List<User> rows = new ArrayList<>();
    User u = new User();
    u.setId(0);
    u.setName("وحید");
    u.setEmail("Victor@gmail.com");
    u.setRegister(true);
    rows.add(u);
    User u1 = new User();
    u1.setId(1);
    u1.setName("Adams");
    u1.setEmail("Adams@gmail.com");
    u1.setRegister(false);
    rows.add(u1);
    User u2 = new User();
    u2.setId(2);
    u2.setName("David");
    u2.setEmail("David@gmail.com");
    u2.setRegister(true);
    rows.add(u2);
    User u3 = new User();
    u3.setId(4);
    u3.setName("Jones");
    u3.setEmail("فارسی");
    u3.setRegister(false);
    rows.add(u3);
    User u4 = new User();
    u4.setId(5);
    u4.setName("Zafar");
    u4.setEmail("Zafar@gmail.com");
    u4.setRegister(false);
    rows.add(u4);
    User u5 = new User();
    u5.setId(6);
    u5.setName("Lopez");
    u5.setEmail("Lopez@gmail.com");
    u5.setRegister(true);
    rows.add(u5);
    // endregion

    Logz.line("LOGZ");

    Logz.i("title", "with title");

    Logz.v(null);
    Logz.d(12345);
    Logz.i(true);
    Logz.w(array);
    Logz.e(mTvHomeLogo);

    Logz.is("fast and clear");

    Logz.json(json);
    Logz.chart(doubleArray);
    Logz.table(rows, "getId", "getName"); // List<User>

    Logz.line();

    ////////////////////////////////

    Log.i("TAG", "-------Default log example-------");

    Log.v("TAG", "TITLE: " + "with title");

    // Log.v("TAG", null); // crashed
    Log.d("TAG", "" + 12345);
    Log.i("TAG", "" + true);
    Log.w("TAG", "" + Arrays.toString(array));
    Log.e("TAG", "" + mTvHomeLogo);

    Log.d("TAG", "*** not fast maybe clear");

    Log.d("TAG", json);
    // Can't draw a chart easily
    // Can't draw a table easily

    Log.i("TAG", "--------------------------------");

    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        Logz.i("");
      }
    }, 10000);
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
    Logz.i(list);
    HashMap list2 = new HashMap();
    list2.put("a", "a");
    list2.put("b", 2);
    list2.put("c", true);
    list2.put("d", new EditText(this));
    Logz.i("List is", list2);
    Logz.i(new EditText[]{new EditText(this), new EditText(this), null});
    Logz.i(new String[]{"a", "b", null});
    Logz.i(null);
    Logz.i(new TextView(this));

    String json = "[{\"نام\":\"Ram\", \"email\":\"Ram@gmail.com\"},{\"name\":\"Bob\", \"email\":\"bob32@gmail.com\"}]";
    String json2 = "[{\"_id\":\"5eb8efb0af30162109be7bee\",\"index\":0,\"guid\":\"627b743f-7bcd-4acb-b294-37a4cfe065d4\",\"isActive\":true,\"balance\":\"$2,813.83\",\"picture\":\"http://placehold.it/32x32\",\"age\":40,\"eyeColor\":\"blue\",\"name\":\"Brandie Shaffer\",\"gender\":\"female\",\"company\":\"TROPOLIS\",\"email\":\"brandieshaffer@tropolis.com\",\"phone\":\"+1 (831) 517-3794\",\"address\":\"251 Bassett Avenue, Veyo, Nebraska, 7801\",\"about\":\"Culpa incididunt commodo voluptate enim dolore cupidatat magna cillum incididunt aute non nisi. Magna consectetur culpa commodo exercitation. Laboris deserunt ea duis pariatur irure cillum irure quis consectetur. Veniam aliquip proident sunt eu cillum consectetur aliquip consectetur enim esse id ipsum aliqua. Aliqua eiusmod duis nisi reprehenderit consectetur incididunt. Aliqua anim enim tempor ad aute enim. Duis sit aliquip duis minim quis esse et adipisicing sit.\\r\\n\",\"registered\":\"2019-07-15T12:08:26 -05:-30\",\"latitude\":0.213961,\"longitude\":55.857053,\"tags\":[\"id\",\"culpa\",\"nulla\",\"proident\",\"nisi\",\"excepteur\",\"deserunt\"],\"friends\":[{\"id\":0,\"name\":\"Aguilar Huber\"},{\"id\":1,\"name\":\"Sanford Durham\"},{\"id\":2,\"name\":\"Pearl Schultz\"}],\"greeting\":\"Hello, Brandie Shaffer! You have 9 unread messages.\",\"favoriteFruit\":\"apple\"},{\"_id\":\"5eb8efb05eec1770abf5526d\",\"index\":1,\"guid\":\"eb9b915b-ec67-465d-8802-be04537473f8\",\"isActive\":true,\"balance\":\"$1,385.05\",\"picture\":\"http://placehold.it/32x32\",\"age\":26,\"eyeColor\":\"green\",\"name\":\"Traci Madden\",\"gender\":\"female\",\"company\":\"UBERLUX\",\"email\":\"tracimadden@uberlux.com\",\"phone\":\"+1 (953) 441-3592\",\"address\":\"205 Boulevard Court, Faywood, Virgin Islands, 345\",\"about\":\"Sunt nulla esse laboris amet deserunt culpa commodo culpa et proident. Voluptate officia irure qui esse reprehenderit mollit magna. Est nulla aliquip nisi cupidatat consectetur pariatur aliqua anim nostrud veniam proident mollit. Aliquip voluptate ad cupidatat consequat occaecat occaecat ex et ipsum sunt cillum dolor nisi. Aliquip enim excepteur voluptate do enim consequat. Eu deserunt consequat dolore est magna eiusmod tempor velit nulla eu eiusmod excepteur commodo dolore. Consectetur exercitation in mollit anim pariatur commodo Lorem ea laboris velit pariatur sit.\\r\\n\",\"registered\":\"2019-12-28T01:31:57 -04:-30\",\"latitude\":-53.65241,\"longitude\":162.733118,\"tags\":[\"anim\",\"Lorem\",\"in\",\"irure\",\"commodo\",\"pariatur\",\"ex\"],\"friends\":[{\"id\":0,\"name\":\"Therese Roberts\"},{\"id\":1,\"name\":\"Lea Quinn\"},{\"id\":2,\"name\":\"Kathleen Whitney\"}],\"greeting\":\"Hello, Traci Madden! You have 1 unread messages.\",\"favoriteFruit\":\"banana\"},{\"_id\":\"5eb8efb02474f8e4a6f62b7f\",\"index\":2,\"guid\":\"251f3758-525d-46e8-ad56-382e44ada943\",\"isActive\":false,\"balance\":\"$2,381.60\",\"picture\":\"http://placehold.it/32x32\",\"age\":35,\"eyeColor\":\"blue\",\"name\":\"Gaines Heath\",\"gender\":\"male\",\"company\":\"VIAGRAND\",\"email\":\"gainesheath@viagrand.com\",\"phone\":\"+1 (842) 584-2493\",\"address\":\"337 Kimball Street, Loyalhanna, Alaska, 7917\",\"about\":\"Consequat irure qui irure labore aute veniam commodo nostrud ex mollit. Amet est esse eu amet velit sit sit. Voluptate irure consequat ut non eu do et excepteur pariatur sunt. Cillum enim veniam Lorem ullamco nisi ullamco dolor nulla elit commodo dolore nulla nulla ea. Officia elit in deserunt anim velit sint nostrud cillum. Pariatur cillum ad excepteur fugiat id labore irure excepteur.\\r\\n\",\"registered\":\"2016-05-15T01:26:09 -05:-30\",\"latitude\":6.308582,\"longitude\":-114.093181,\"tags\":[\"est\",\"fugiat\",\"aliquip\",\"consequat\",\"mollit\",\"aliquip\",\"tempor\"],\"friends\":[{\"id\":0,\"name\":\"Herminia Sweeney\"},{\"id\":1,\"name\":\"Sexton Ratliff\"},{\"id\":2,\"name\":\"Claudette Stuart\"}],\"greeting\":\"Hello, Gaines Heath! You have 6 unread messages.\",\"favoriteFruit\":\"banana\"},{\"_id\":\"5eb8efb0e9b9f024e5e2bb9c\",\"index\":3,\"guid\":\"a6e6d4ad-6d81-41cc-993d-f25bcefed54d\",\"isActive\":true,\"balance\":\"$1,102.78\",\"picture\":\"http://placehold.it/32x32\",\"age\":36,\"eyeColor\":\"brown\",\"name\":\"Genevieve Johnson\",\"gender\":\"female\",\"company\":\"EXTREMO\",\"email\":\"genevievejohnson@extremo.com\",\"phone\":\"+1 (840) 466-3306\",\"address\":\"577 Bowne Street, Grantville, Mississippi, 5040\",\"about\":\"Pariatur excepteur qui proident ea ut. Dolor est cupidatat amet adipisicing aliqua cillum ex. Proident mollit esse quis non. Lorem esse voluptate proident ullamco est qui officia aute tempor cupidatat magna consectetur. Enim ad commodo irure consequat consequat in exercitation quis officia adipisicing reprehenderit.\\r\\n\",\"registered\":\"2016-05-02T07:35:12 -05:-30\",\"latitude\":-41.181853,\"longitude\":-1.602298,\"tags\":[\"magna\",\"et\",\"aute\",\"excepteur\",\"nostrud\",\"incididunt\",\"nulla\"],\"friends\":[{\"id\":0,\"name\":\"Elva Castillo\"},{\"id\":1,\"name\":\"Stein Sosa\"},{\"id\":2,\"name\":\"Meyer Pacheco\"}],\"greeting\":\"Hello, Genevieve Johnson! You have 3 unread messages.\",\"favoriteFruit\":\"apple\"},{\"_id\":\"5eb8efb084d626f135faf8ca\",\"index\":4,\"guid\":\"88bf20bc-36e1-47bd-baf7-a952060507ca\",\"isActive\":false,\"balance\":\"$3,556.60\",\"picture\":\"http://placehold.it/32x32\",\"age\":35,\"eyeColor\":\"brown\",\"name\":\"Paula Farrell\",\"gender\":\"female\",\"company\":\"PYRAMIS\",\"email\":\"paulafarrell@pyramis.com\",\"phone\":\"+1 (806) 468-2422\",\"address\":\"556 Lawrence Street, Sanford, North Dakota, 6112\",\"about\":\"Minim proident adipisicing proident in ad. Cupidatat eiusmod aute esse ad id eu officia consectetur enim. Quis aute nisi sint sint cillum Lorem consequat elit esse sunt pariatur nulla sint qui. Dolor esse culpa reprehenderit commodo nulla enim. Eiusmod ullamco voluptate qui enim est id duis dolore exercitation mollit. Et est ex proident velit velit veniam nisi officia. Voluptate reprehenderit esse magna consequat nostrud enim commodo laboris esse sit.\\r\\n\",\"registered\":\"2019-01-22T11:22:02 -04:-30\",\"latitude\":-68.866334,\"longitude\":-37.054273,\"tags\":[\"aliquip\",\"incididunt\",\"pariatur\",\"proident\",\"ex\",\"officia\",\"dolore\"],\"friends\":[{\"id\":0,\"name\":\"Sadie Suarez\"},{\"id\":1,\"name\":\"Lilian Nieves\"},{\"id\":2,\"name\":\"Lucy Harrell\"}],\"greeting\":\"Hello, Paula Farrell! You have 3 unread messages.\",\"favoriteFruit\":\"apple\"},{\"_id\":\"5eb8efb0c89d47a25599eebe\",\"index\":5,\"guid\":\"73707c76-27c4-46aa-9b77-5a738ce308f4\",\"isActive\":false,\"balance\":\"$3,596.65\",\"picture\":\"http://placehold.it/32x32\",\"age\":33,\"eyeColor\":\"green\",\"name\":\"Marion Garcia\",\"gender\":\"female\",\"company\":\"HELIXO\",\"email\":\"mariongarcia@helixo.com\",\"phone\":\"+1 (941) 463-2033\",\"address\":\"581 Emmons Avenue, Maplewood, South Dakota, 9475\",\"about\":\"Laboris adipisicing est labore id eu reprehenderit magna ex pariatur fugiat occaecat. Magna eu irure aliquip fugiat Lorem non incididunt esse quis labore. Qui amet veniam eiusmod esse irure ex. Mollit velit deserunt culpa enim.\\r\\n\",\"registered\":\"2014-06-11T02:38:20 -05:-30\",\"latitude\":65.152996,\"longitude\":26.178393,\"tags\":[\"aliquip\",\"nostrud\",\"mollit\",\"veniam\",\"quis\",\"deserunt\",\"proident\"],\"friends\":[{\"id\":0,\"name\":\"Jones Montoya\"},{\"id\":1,\"name\":\"Leta Compton\"},{\"id\":2,\"name\":\"Nona Davis\"}],\"greeting\":\"Hello, Marion Garcia! You have 2 unread messages.\",\"favoriteFruit\":\"apple\"}]";
    try {
      JSONArray array = new JSONArray(json);
      Logz.json(array);
    } catch (Throwable t) {
    }
    Logz.json("Json is", json);
    Logz.json("long json", json2);
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

    List<User> rows = new ArrayList<>();
    User u = new User();
    u.setId(0);
    u.setName("وحید");
    u.setEmail("2");
    u.setRegister(true);
    rows.add(u);
    User u1 = new User();
    u1.setId(1);
    u1.setName("علی");
    u1.setEmail("سلام");
    u1.setRegister(false);
    rows.add(u1);
    User u2 = new User();
    u2.setId(2);
    u2.setName("David");
    u2.setEmail("David@gmail.com");
    u2.setRegister(true);
    rows.add(u2);
    User u3 = new User();
    u3.setId(4);
    u3.setName("Jones");
    u3.setEmail("فارسی");
    u3.setRegister(false);
    rows.add(u3);
    User u4 = new User();
    u4.setId(5);
    u4.setName("Zafar");
    u4.setEmail("Zafar@gmail.com");
    u4.setRegister(false);
    rows.add(u4);
    User u5 = new User();
    u5.setId(6);
    u5.setName("Lopez");
    u5.setEmail("Lopez@gmail.com");
    u5.setRegister(true);
    rows.add(u5);
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
    rows.add(new User());
//    data.add(null);
    Logz.table(rows, "getId", "getName", "getEmail", "isRegister");
    Logz.table(rows, "asd");
    Logz.table(rows, null);
    Logz.table(null, null);

    rows.clear();
    User u1000 = new User();
    u1000.setId(2);
    u1000.setName("قصد دارید تصمیمی بگیرید اما خودتان نمی توانید، ترجیح می دهید دیگران برایتان تصمیم بگیرند یا بصورت شانسی یک طرف را انتخاب کنید؟");
    u1000.setEmail("ترجیح می دهید خودتان فرد مشهوری باشید یا بهترین دوست یک فرد مشهور باشید؟");
    u1000.setRegister(true);
    rows.add(u1000);
    Logz.table(rows, "getId", "getName", "getEmail", "isRegister");

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
        Toast.makeText(Sample.this, "Intentional error", Toast.LENGTH_SHORT).show();
        throw null; // in main thread
      }
    }, 4000);
//    throw null;
  }
}