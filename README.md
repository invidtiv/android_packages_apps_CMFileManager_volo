LineageOS File Manager
========================

A file manager for AOSP, focused on rooted devices and specially designed
for the LineageOS Project.

## Requirements

- Java 17
- Android SDK with platform API 33 installed (compileSdkVersion is 33)

## Building

### Command line (Windows)

Debug APK:

```
./gradlew.bat assembleDebug
```

Release APK:

```
./gradlew.bat assembleRelease
```

APK outputs:

- `build/outputs/apk/debug/`
- `build/outputs/apk/release/`

### Android Studio

- Open the project folder.
- Let Gradle sync.
- Use the `debug` or `release` build variant.

## Documentation

- [Intents Documentation](INTENTS.md) - Details on supported Intent actions and parameters.

## Notes

- minSdkVersion: 23
- targetSdkVersion: 33
- This app requests legacy external storage behavior via `android:requestLegacyExternalStorage="true"`.

This source was released under the terms of
[Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0.html) license.

Visit [LineageOS Github](https://github.com/LineageOS) and [LineageOS
Code Review](http://review.lineageos.org/) to get the source and patches.

This application uses also third party libraries. Checkout the individual
license of every library in libs folder.

Copyright © 2012 The CyanogenMod Project
Copyright © 2017 The LineageOS Project
