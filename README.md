# ⌬ 𝓛𝓸𝓰𝔃  [![](https://jitpack.io/v/Vahider/Logz.svg)](https://jitpack.io/#Vahider/Logz)
Very simple, practical, attractive and powerful logger for android

## Possibilities
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
- Set title for logs
- every arguamnt for logging

## Comparison
###### Comparison between default log and Logz
![Alt text](https://user-images.githubusercontent.com/51606884/75083512-6a63bf80-552e-11ea-9cb4-006a42382a36.png)

## Setup
###### in `biuld.gradle (Module app)`
```
implementation 'com.github.vahider:logz:1.5.7'
```
###### in `biuld.gradle (project)`
```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

## Document
> **Tip**: `Title` is optional with a different style for each log. To add *title* to log, add an object before the `msg`. Example: `Logz.i(title, everything);`
###### Normal log
```
Logz.v(eveything);
Logz.d(eveything);
Logz.i(eveything);
Logz.w(eveything);
Logz.e(eveything);
```
###### Fast & clear log
```
Logz.is(eveything);
```
###### Draw a line
```
Logz.line(eveythings);
Logz.line();
```
###### Draw a json
```
Logz.json(List);
```
###### Draw a chart
```
Logz.chart(double array);
```
###### Draw a table
```
Logz.table(list, Name of methods as reflection);
```

## Options
###### Write this code in `first activity` or `Application` class
###### They are default and Optional values, for not changing you can remove line of options.
```
new Logz.Builder()
      .setTag("LOGZ")
      .setEnable(true)
      .setUsed(true)
      .showInfo(true)
      .setInfoClickable(false)
      .setTimeFormat(Time.CLOCK)
      .setInfoMode(Info.CLASS, Info.METHOD, Info.LINE)
      .useSummaryMode(Summary.START)
      .setTitleCase(Case.CAMEL_SPACE)
      .showElapsing(true)
      .useViewDetection(true)
      .setLimitLength(false)
      .reload();
```

Method | Default | Arguments | Description | Usage
---|---|---|---|---
setTag | "LOGZ" | Anything | rename log tag | To follow the logs in Logcat, read more in the settings
setEnable | true | `true` `false` | To turn off the logz | You can disable it when you publish
setUsed | true | `true` `false` | To disable the Logz engine and use the default log | When browsing a few thousand logs, to increase speed
showInfo | true | `true` `false` | Show log time and address | Set `true` when you want to see the log information
setInfoClickable | true | `true` `false` | With click on the log information in the logcat and be directed to the location of the log | Everytime
setTimeFormat | Time.CLOCK | `NONE` `STAMP` `CLOCK` `DATE` `FULL` `"yyyy/MM/dd-HH:mm:ss"` | How do you want to see the information time? | Everytime
setInfoMode | Info.CLASS, Info.METHOD, Info.LINE | `FILE` `CLASS` `METHOD` `LINE` | Which log information to display? | Everytime
useSummaryMode | Summary.START | `START` `END` `NONE` | Summary of information | When the log information is longer than 20 characters
setTitleCase | Case.CAMEL_SPACE | `CAMEL` `CAMEL_SPACE` `NONE` | Types of log titles | Everytime
showElapsing | true | `true` `false` | Display the delay between two logs if more than 3 seconds have elapsed | Everytime
useViewDetection | true | `true` `false` | Summary of view | Everytime
setLimitLength | false | `true` `false` | Limitation for Maximum Line | When you have a table or jason that has countless lines

## Advanced settings
To have a better experience than Logz, make the above settings and feel the change
###### Hide old information
To delete old information as well as shorten it, you have to click on the settings icon in the left menu of logcat and delete all the ticks.![Alt text](https://user-images.githubusercontent.com/51606884/75083508-6899fc00-552e-11ea-8708-32e6e972d120.png)
###### Hide extra logs
For only writed logs to be displayed, you must create a new `filter` in the logcat.
So in the logcat, click on the filters menu and click on `Edit Filter Configuration` and choose a name for your filter, and finally write the `⌬` in the `Log Message` field or tagname in the `Log Tag` field.
If you want to see other logs, just select other filters, such as `show only selected applicatinos` or `no filters`
![Alt text](https://user-images.githubusercontent.com/51606884/75083511-69cb2900-552e-11ea-8722-f05ac4119f2f.png)
###### Paint the logcat
To better identify the logs, you can change the color of the logs in Android Studio.
Go to File>Settings>Editor>ColorScheme>AndroidLogcat then change color the color of each levels.
![Alt text](https://user-images.githubusercontent.com/51606884/75083515-6b94ec80-552e-11ea-95fb-4d14186cecf3.png)
###### Use the same width font
To align the templates, try using a font that has the same letters.
go to File>Settings>Editor>ColorScheme>ConsoleFont and select a font that is the same width, example `Consolas`
###### Opening the logate faster
Press Alt + 6 to open or close the logcat

## Licence
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
