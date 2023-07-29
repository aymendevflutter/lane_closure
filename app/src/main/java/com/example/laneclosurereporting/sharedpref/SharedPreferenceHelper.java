package com.example.laneclosurereporting.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.laneclosurereporting.object.lanesData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPreferenceHelper {
    private static final String PREF_NAME = "lanesDataPref";
    private static final String KEY_LANES_DATA = "lanesData";

    public static void saveLanesDataList(Context context, List<lanesData> lanesDataList) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(lanesDataList);

        editor.putString(KEY_LANES_DATA, json);
        editor.apply();
    }

    public static List<lanesData> getLanesDataList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String json = sharedPreferences.getString(KEY_LANES_DATA, null);

        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<lanesData>>() {}.getType();
            return gson.fromJson(json, type);
        } else {
            return new ArrayList<>();
        }
    }
}
