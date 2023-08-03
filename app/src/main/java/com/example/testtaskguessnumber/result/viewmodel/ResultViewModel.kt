package com.example.testtaskguessnumber.result.viewmodel

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.util.SharedPreferencesUtil

class ResultViewModel(private val gameScore: GameScore?, context: Context) : ViewModel() {

    private val sharedPreferencesUtil = SharedPreferencesUtil(context)
    private var wonGameScore = sharedPreferencesUtil.getWonValue()
    private var lostGameScore = sharedPreferencesUtil.getLoseValue()
    private var dataBindingWonGameScore =

        object : ObservableField<String>(wonGameScore.toString()) {
            override fun set(value: String?) {
                super.set(value)
                wonGameScore = value?.toIntOrNull() ?: wonGameScore
            }
        }
    private var dataBindingLostGameScore =

        object : ObservableField<String>(lostGameScore.toString()) {
            override fun set(value: String?) {
                super.set(value)
                lostGameScore = value?.toIntOrNull() ?: lostGameScore
            }
        }

    fun onButtonClick() {
    }

    fun getGameScore(): GameScore? {
        return gameScore
    }

    fun getLostGameScore(): ObservableField<String> {
        return dataBindingLostGameScore
    }

    fun getWonGameScore(): ObservableField<String> {
        return dataBindingWonGameScore
    }
}