package com.synth3sisgame.synth3sisgame.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Prefs {

    public static String SEQUANTIAL_HOUR = "SEQUANTIAL_HOUR";
    public static String SEQUANTIAL_MIN = "SEQUANTIAL_MIN";
    public static String DES_BTW_SCHEDULE_RANDOM = "DES_BTW_SCHEDULE_RANDOM";
    public static String RANDOM_TIME = "RANDOM_TIME";

    public static void putString(Context ctx, String key, String value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(Context ctx, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        return preferences.getString(key, "");
    }

    public static void putBool(Context ctx, String key, boolean value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();

    }

    public static boolean getBool(Context ctx, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        return preferences.getBoolean(key, false);
    }

    public static void removeValue(Context ctx, String key) {
        SharedPreferences mySPrefs =PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor editor = mySPrefs.edit();
        editor.remove(key);
        editor.apply();
    }

}
