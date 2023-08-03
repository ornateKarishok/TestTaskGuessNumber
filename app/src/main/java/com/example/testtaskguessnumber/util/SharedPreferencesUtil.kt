package com.example.testtaskguessnumber.util

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesUtil(context: Context) {
    private val wonPreferencesKey = "WON_PREFERENCES_KEY"
    private val losePreferencesKey = "LOSE_PREFERENCES_KEY"
    private val sharedPreference: SharedPreferences =
        context.getSharedPreferences("GAME_PREFERENCE", Context.MODE_PRIVATE)

    fun increaseWonValue() {
        val editor = sharedPreference.edit()
        val wonQuantity = getWonValue()
        editor.putInt(wonPreferencesKey, wonQuantity + 1)
        editor.apply()
    }

    fun getWonValue(): Int {
        return sharedPreference.getInt(wonPreferencesKey, 0)
    }

    fun increaseLoseValue() {
        val editor = sharedPreference.edit()
        val loseQuantity = getLoseValue()
        editor.putInt(losePreferencesKey, loseQuantity + 1)
        editor.apply()
    }

    fun getLoseValue(): Int {
        return sharedPreference.getInt(losePreferencesKey, 0)
    }

}