
package io.github.ichonal.sdkkochava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.kochava.base.Tracker;


public class RNSdkKochavaModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNSdkKochavaModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNSdkKochava";
  }


  @ReactMethod
  public void logCustomEvent(@NonNull String eventName, @NonNull ReadableMap params) {
    final JSONObject jsonData = readableMapToJsonObject(params);
    Tracker.sendEvent(eventName, jsonData == null ? "{}" : jsonData.toString());
  }

  private static JSONObject readableMapToJsonObject(@Nullable final ReadableMap m) {
    if (m == null) return null;

    final ReadableMapKeySetIterator iterator = m.keySetIterator();
    final JSONObject jsonObj = new JSONObject();

    while(iterator.hasNextKey()) {
      final String key = iterator.nextKey();
      try {
        switch (m.getType(key)) {
          case Array:
            jsonObj.put(key, readableArrayToJsonArray(m.getArray(key)));
            break;
          case Number:
            jsonObj.put(key, m.getDouble(key));
            break;
          case Boolean:
            jsonObj.put(key, m.getBoolean(key));
            break;
          case Map:
            jsonObj.put(key, readableMapToJsonObject(m.getMap(key)));
            break;
          case String:
            jsonObj.put(key, m.getString(key));
            break;
          case Null:
            //Null types are ignored.
            break;
        }
      } catch(@NonNull final Throwable ignored) {}
    }
    return jsonObj;
  }

  private static JSONArray readableArrayToJsonArray(@Nullable final ReadableArray readableArray) {
    if(readableArray == null) {
      return null;
    }

    final JSONArray jsonArray = new JSONArray();
    for(int i=0; i<readableArray.size(); i++) {
      try {
        switch (readableArray.getType(i)) {
          case Array:
            jsonArray.put(readableArrayToJsonArray(readableArray.getArray(i)));
            break;
          case Number:
            jsonArray.put(readableArray.getDouble(i));
            break;
          case Boolean:
            jsonArray.put(readableArray.getBoolean(i));
            break;
          case Map:
            jsonArray.put(readableMapToJsonObject(readableArray.getMap(i)));
            break;
          case String:
            jsonArray.put(readableArray.getString(i));
            break;
          case Null:
            //Null types are ignored.
            break;
        }
      } catch(@NonNull final Throwable ignored) {}
    }
    return jsonArray;
  }
}