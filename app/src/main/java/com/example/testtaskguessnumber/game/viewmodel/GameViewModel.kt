package com.example.testtaskguessnumber.game.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testtaskguessnumber.game.Game
import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.game.`object`.Numbers
import com.example.testtaskguessnumber.game.ui.GameActivity
import com.example.testtaskguessnumber.result.ui.ResultActivity
import com.example.testtaskguessnumber.util.ValidationUtil

class GameViewModel : ViewModel() {
    private val number: Numbers = generateNumber()

    private var terms: Int = 3

    private val eventNavigate = MutableLiveData<Class<*>>()
    private var gameScore: GameScore = GameScore.LOOSE

    private var dataBindingNumber =

        object : ObservableField<String>() {
            override fun set(value: String?) {
                super.set(value)
                number.inputNumber = value?.toIntOrNull() ?: number.inputNumber
            }
        }

    fun getEventNavigate(): LiveData<Class<*>?> {
        return eventNavigate
    }

    fun getDataBindingNumber(): ObservableField<String> {
        return dataBindingNumber
    }

    fun getTerms(): Int {
        return terms
    }

    fun getGameScore(): GameScore {
        return gameScore
    }

    fun onCheckButtonClick() {
        if (ValidationUtil.checkValidity(number.inputNumber)) {
            gameScore = Game.play(number)
            terms--
            if (terms > 0 && gameScore == GameScore.LOOSE) {
                eventNavigate.value = GameActivity::class.java
            } else {
                eventNavigate.value = ResultActivity::class.java
            }
        } else {
            eventNavigate.value = null
        }
    }

    private fun generateNumber(): Numbers {
        return Numbers((0..100).random())
    }
}