# MIUI_Hacks  MIUI12 12.5 Hacks

## 下载地址：

[app-release.apk](./app-release.apk)


## 故事起源于1888狗东入手了个K40 12+256，激活了不能退了，再加上“又不是不能用”。

## 更改任意刷新率

Logcat:   6228  6463 I DisplayFrameSetting: onChange mUserFps=90

Hacks: $ settings list system |grep -i 90                       

user_refresh_rate=90

方式： adb shell settings put system user_refresh_rate [YOUR NUMBER]


## 关闭充电提示音

settings list global |grep -i sounds             

power_sounds_enabled=0



