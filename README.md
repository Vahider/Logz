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

### Comparison

### Setup
###### in `biuld.gradle (Module app)`
```
implementation 'com.github.Vahider:Logz:1.0.0'
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
> **Tip**: `Title` is optional item and diffrente text style for every log. For add *title* to log, add a Object before `everythings`. Example: `Logz.i(title, everythings);`
###### Normal log
```
Logz.v(eveythings);
Logz.d(eveythings);
Logz.i(eveythings);
Logz.w(eveythings);
Logz.e(eveythings);
```
###### Fast log
```
Logz.is(eveythings);
```
###### Draw line
```
Logz.line(eveythings);
```
###### Log list content
```
Logz.list(List);
Logz.list(Array);
Logz.list(Set);
Logz.list(Map);
```
###### Log json format
```
Logz.json(List);
```
###### Draw chart
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
setUsed | true | `true` `false` | For disable Logz engine and use logz options with default log | when use very much logs (monitoring) and want to fastest log
showInfo | true | `true` `false` | Fow showing time and address of log | true when you want see info of logs
setInfoClickable | true | `true` `false` | You can click on address log in logcat and transform to log writed place | Everytime
setTimeFormat | Time.CLOCK | `NONE` `STAMP` `CLOCK` `DATE` `FULL` `"yyyy/MM/dd-HH:mm:ss"` | how you will see time of info? | Everytime
setInfoMode | Info.CLASS, Info.METHOD, Info.LINE | `FILE` `CLASS` `METHOD` `LINE` | Show wich info? | Everytime
useSummaryMode | Summary.START | `START` `END` `NONE` | Shortly item of infos | When any info longest from 20 char
setTitleCase | Case.CAMEL_SPACE | `CAMEL` `CAMEL_SPACE` `NONE` | Difference title style and log | Everytime
showElapsing | true | `true` `false` | Show offset between logs if was above 3 secounds  | Everytime
useViewDetection | true | `true` `false` | Show views shortly and with id | Everytime

### Advanced settings
For get better expensive from logging, pass below levels and feel changes.
###### Hide old info
For remove old logs's info and shortly too, you must be click on left settings icon in logcat, and remove all ticks.
###### Hide extra logs
For show just your log, you must be create new filter in logcat. click on Filter, then click on Edit filter configuration and set name for filter and write `⌬` in Log message field.
If you want show other logs, just select other filter example `show only selected applicatinos` or `no filters`
###### Use coloric text
For better detection log, you can change log colors in android studio settings.
go to File>Settings>Editor>ColorScheme>ConsoleColors and click on Log Console then change every log levels.
###### Use same width font
For better expencive, use font that same of characters width.
go to File>Settings>Editor>ColorScheme>ConsoleFont and use same width font example `Consolas`
###### Open logcat fastest
Put Alt+6 for open and close logcat

### Licence
```
MIT License

Copyright (c) 2020 Vahid

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
