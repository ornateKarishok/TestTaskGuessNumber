package com.example.testtaskguessnumber.util

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesUtil(context: Context) {
    private val WON_PREFERENCES_KEY = "WON_PREFERENCES_KEY"
    private val LOST_PREFERENCES_KEY = "LOST_PREFERENCES_KEY"
    private val sharedPreference: SharedPreferences =
        context.getSharedPreferences("GAME_PREFERENCE", Context.MODE_PRIVATE)

    fun increaseWonValue() {
        val editor = sharedPreference.edit()
        val wonQuantity = getWonValue()
        editor.putInt(WON_PREFERENCES_KEY, wonQuantity + 1)
        editor.apply()
    }

    fun getWonValue(): Int {
        return sharedPreference.getInt(WON_PREFERENCES_KEY, 0)
    }

    fun increaseLoseValue() {
        val editor = sharedPreference.edit()
        val lostQuantity = getLoseValue()
        editor.putInt(LOST_PREFERENCES_KEY, lostQuantity + 1)
        editor.apply()
    }

    fun getLoseValue(): Int {
        return sharedPreference.getInt(LOST_PREFERENCES_KEY, 0)
    }

}