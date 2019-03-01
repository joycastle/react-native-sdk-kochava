import { NativeModules } from 'react-native';

const { RNSdkKochava } = NativeModules;

class KochavaTracker {
    static logCustomEvent(evtName, params={}) {
        if (!!evtName) {
            RNSdkKochava.logCustomEvent(evtName, params);
        } else {
            __DEV__ && console.warn(`[RNSdkKochava] logCustomEvent: evtName is not set`);
        }
    }
};

export default KochavaTracker;