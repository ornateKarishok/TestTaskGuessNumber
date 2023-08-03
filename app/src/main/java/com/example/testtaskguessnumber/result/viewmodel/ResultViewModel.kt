package com.example.testtaskguessnumber.result.viewmodel

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.menu.ui.MenuActivity
import com.example.testtaskguessnumber.util.SharedPreferencesUtil

class ResultViewModel(
    private val gameScore: GameScore?,
    private val thoughtNumber: Int,
    context: Context
) :
    ViewModel() {

    private var eventNavigate = MutableLiveData<Class<*>>()
    private val sharedPreferencesUtil = SharedPreferencesUtil(context)
    private var wonGameScore = sharedPreferencesUtil.getWonValue()
    private var loseGameScore = sharedPreferencesUtil.getLoseValue()
    private var dataBindingWonGameScore =

        object : ObservableField<String>(wonGameScore.toString()) {
            override fun set(value: String?) {
                super.set(value)
            }
        }
    private var dataBindingLoseGameScore =

        object : ObservableField<String>(loseGameScore.toString()) {
            override fun set(value: String?) {
                super.set(value)
            }
        }
    private var dataBindingThoughtNumber =

        object : ObservableField<String>(thoughtNumber.toString()) {
            override fun set(value: String?) {
                super.set(value)
            }
        }

    fun onButtonClick() {
        eventNavigate.value = MenuActivity::class.java
    }

    fun getGameScore(): GameScore? {
        return gameScore
    }

    fun getDataBindingThoughtNumber(): ObservableField<String> {
        return dataBindingThoughtNumber
    }

    fun getLoseGameScore(): ObservableField<String> {
        return dataBindingLoseGameScore
    }

    fun getWonGameScore(): ObservableField<String> {
        return dataBindingWonGameScore
    }

    fun getEventNavigate(): LiveData<Class<*>?> {
        return eventNavigate
    }
}