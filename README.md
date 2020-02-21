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
###### in biuld.gradle (Module app)
```
implementation 'com.github.Vahider:Logz:0.1.0'
```
###### in biuld.gradle (project)
```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### Initialize
###### Write this code in first activity or Application class
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

### Document
> for add title to every log, add string and split with ',' before everythings example: Logz.i(title, everythings);
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
###### Write this code in first activity or Application class
###### They are default and Optional values, for not changing you can remove line of options.
```
new Logz.Builder()
      .setTag("LOGZ") // For following logs in Logcat
      .setEnable(true) // For disabling logs on realse issue
      .setUsed(USED) // For when you want use Logz or default log for biulding logs. (When you have very very much logs and in tip)
      .showInfo(true) // Show info of log (time, class, method, line)
      .setInfoClickable(false) // You can click on address log in logcat and transform to log writed place
      .setTimeFormat(Time.CLOCK) // NONE, STAMP, CLOCK, DATE, FULL or put your coustom format: "yyyy/MM/dd-HH:mm:ss"
      .setInfoMode(Info.CLASS, Info.METHOD, Info.LINE) // show wich info? FILE, CLASS, METHOD, LINE;
      .useSummaryMode(Summary.NONE) // When info is long, cut every info to 20 chars, START, END, NONE
      .setTitleCase(Case.CAMEL_SPACE) // Difference title style and log, CAMEL, CAMEL_SPACE, NONE
      .showElapsing(true) // Show offset between logs if was above 3 secounds 
      .useViewDetection(true) // Show views shortly and with id
      .reload();
```

Method | Default | Values | Usage | Desc | Example
--- | --- | --- | --- |--- |---
setTag | "LOGZ" | String | 290 | 286 | 289
--- | --- | --- | --- |--- |---
setTag | "LOGZ" | String | 290 | 286 | 289
setTag | "LOGZ" | String | 290 | 286 | 289

### Advanced
- Remove extra logs
- Color

### Settings

### Samples

### Licence
