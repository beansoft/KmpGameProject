# Live Coding：用 Compose Multiplatform 写出第一个小游戏

This is a Kotlin Multiplatform project targeting Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

修复初始化desktopRun找不到类的问题：
```gradle
desktopRun -DmainClass=MainKt
```

运行截图：
![screenshot.png](screenshot.png)

直播回放：https://mp.weixin.qq.com/s/YANZewiLqPKdZvAmwicTbw