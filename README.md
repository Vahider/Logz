# ⌬ 𝓛𝓸𝓰𝔃
Very simple, practical, attractive and powerful logger for android

### Possibilities
- Show list content
- Draw chart
- Open json format
- View detection
- Show log's address
- Customize time
- Safe null
- Fast log
- Split lounch
- Show elapsing
- Adapted with crashing
- Set title for logging

### Setup
###### in `biuld.gradle (Module app)`
```
implementation 'com.github.Vahider:Logz:0.1.0'
```
###### in `biuld.gradle (project)`
```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### Document
> for add `title` to every log, add string and split with `,` before everythings example: `Logz.i(title, everythings);`
- Normal log
```
Logz.v(eveythings);
Logz.d(eveythings);
Logz.i(eveythings);
Logz.w(eveythings);
Logz.e(eveythings);
```
- Fast log
```
Logz.is(eveythings);
```
- Draw line
```
Logz.line(eveythings);
```
- Log list content
```
Logz.list(List);
Logz.list(Array);
Logz.list(Set);
Logz.list(Map);
```
- Log json format
```
Logz.json(List);
```
- Draw chart
```
Logz.chart(double array);
```


### Options
###### Write this code in `first activity` or `Application` class
###### They are default and Optional values, for not changing you can remove line of options.
```
new Logz.Builder()
      .setTag("LOGZ")
      .setEnable(true)
      .setUsed(USED)
      .showInfo(true)
      .setInfoClickable(false)
      .setTimeFormat(Time.CLOCK)
      .setInfoMode(Info.CLASS, Info.METHOD, Info.LINE)
      .useSummaryMode(Summary.NONE)
      .setTitleCase(Case.CAMEL_SPACE)
      .showElapsing(true)
      .useViewDetection(true)
      .reload();
```

Method | Default | Values | Desc | Usage 
---|---|---|---|---
setTag | "LOGZ" | Every | Change log tag | For following logs in Logcat, More desc in Continue(Settings)
setEnable | true | `true` `false` | For disable and hide logz | set false when release issue
setUsed | true | true/false | For disable Logz engine and use logz options with default log | when use very much logs (monitoring) and want to fastest log
showInfo | true | true/false | Fow showing time and address of log | true when you want see info of logs
setInfoClickable | true | true/false | You can click on address log in logcat and transform to log writed place | Everytime
setTimeFormat | Time.CLOCK | NONE, STAMP, CLOCK, DATE, FULL, "yyyy/MM/dd-HH:mm:ss" | how you will see time of info? | Everytime
setInfoMode | Info.CLASS, Info.METHOD, Info.LINE | FILE, CLASS, METHOD, LINE | Show wich info? | Everytime
useSummaryMode | Summary.START | START, END, NONE | Shortly item of infos | When every info longest from 20 char
setTitleCase | Case.CAMEL_SPACE | CAMEL, CAMEL_SPACE, NONE | Difference title style and log | Everytime
showElapsing | true | true/false | Show offset between logs if was above 3 secounds  | Everytime
useViewDetection | true | true/false | Show views shortly and with id | Everytime

### Advanced
- Remove extra logs
- Color

### Settings

### Samples

### Licence
