
# react-native-sdk-kochava

## Getting started

`$ npm install git+https://github.com/iChonal/react-native-sdk-kochava.git --save`

or

`$ yarn add https://github.com/iChonal/react-native-sdk-kochava.git`

### Native SDK is **REQUIRED**

To intergrate native SDK, see [Kochava Docs](https://support.kochava.com/sdk-integration/).

### Mostly automatic installation

`$ react-native link react-native-sdk-kochava`

### Manual installation

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-sdk-kochava` and add `RNSdkKochava.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNSdkKochava.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`

#### Android

1. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-sdk-kochava'
  	project(':react-native-sdk-kochava').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-sdk-kochava/android')
  	```
2. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      implementation project(':react-native-sdk-kochava')
  	```
3. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import io.github.ichonal.sdkkochava.RNSdkKochavaPackage;` to the imports at the top of the file
  - Add `new RNSdkKochavaPackage()` to the list returned by the `getPackages()` method


## Usage

```javascript
import KochavaTracker from 'react-native-sdk-kochava';
```
  