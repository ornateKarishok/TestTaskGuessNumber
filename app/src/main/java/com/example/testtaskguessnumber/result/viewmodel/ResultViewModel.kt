package com.example.testtaskguessnumber.result.viewmodel

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.menu.ui.MenuActivity
import com.example.testtaskguessnumber.util.SharedPreferencesUtil

class ResultViewModel(private val gameScore: GameScore?, private val guessedNumber: Int, context: Context) :
    ViewModel() {

    private var eventNavigate = MutableLiveData<Class<*>>()
    private val sharedPreferencesUtil = SharedPreferencesUtil(context)
    private var wonGameScore = sharedPreferencesUtil.getWonValue()
    private var lostGameScore = sharedPreferencesUtil.getLoseValue()
    private var dataBindingWonGameScore =

        object : ObservableField<String>(wonGameScore.toString()) {
            override fun set(value: String?) {
                super.set(value)
            }
        }
    private var dataBindingLostGameScore =

        object : ObservableField<String>(lostGameScore.toString()) {
            override fun set(value: String?) {
                super.set(value)
            }
        }
    private var dataBindingThoughtNumber =

        object : ObservableField<String>(guessedNumber.toString()) {
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

    fun getLostGameScore(): ObservableField<String> {
        return dataBindingLostGameScore
    }

    fun getWonGameScore(): ObservableField<String> {
        return dataBindingWonGameScore
    }

    fun getEventNavigate(): LiveData<Class<*>?> {
        return eventNavigate
    }
}