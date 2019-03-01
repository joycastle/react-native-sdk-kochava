declare module 'react-native-sdk-kochava' {
    interface KochavaTrackerStatic {
        logCustomEvent(evtName: string, params: {[key: string]: string}): void;
    }

    const KochavaTracker: KochavaTrackerStatic;
    export default KochavaTracker;
}