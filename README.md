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

### Advanced
- Remove extra logs
- Color

### Settings

### Samples

### Licence
