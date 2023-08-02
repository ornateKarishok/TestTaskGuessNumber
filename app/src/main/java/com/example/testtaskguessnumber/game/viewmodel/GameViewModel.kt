package com.example.testtaskguessnumber.game.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testtaskguessnumber.game.Game
import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.game.`object`.Numbers
import com.example.testtaskguessnumber.result.ui.ResultActivity

class GameViewModel : ViewModel() {
    private val number: Numbers = generateNumber()

    private var terms: Int = 0

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

    fun getNumber(): Numbers {
        return number
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
        gameScore = Game.play(number)
        if (terms < 3 && gameScore == GameScore.LOOSE) {
            terms++
            eventNavigate.value = null
        } else {
            eventNavigate.value = ResultActivity::class.java
        }
    }


    private fun generateNumber(): Numbers {
        return Numbers((0..100).random())
    }
}