package com.example.testtaskguessnumber.game.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testtaskguessnumber.R
import com.example.testtaskguessnumber.game.GameLogic
import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.game.`object`.Numbers
import com.example.testtaskguessnumber.result.ui.ResultActivity
import com.example.testtaskguessnumber.util.ValidationUtil

class GameViewModel(application: Application) : AndroidViewModel(application) {
    private val number: Numbers = generateNumber()

    private var terms: Int = 3

    private val focus = true

    private val eventNavigate = MutableLiveData<Class<*>>()
    private var gameScore: GameScore = GameScore.LOSE

    private var infoGameText =

        object : ObservableField<String>() {
            override fun set(value: String) {
                super.set(value)
            }
        }
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

    fun getFocus(): Boolean {
        return focus
    }

    fun getDataBindingNumber(): ObservableField<String> {
        return dataBindingNumber
    }

    fun getNumbers(): Numbers {
        return number
    }

    fun getGameScore(): GameScore {
        return gameScore
    }

    fun getGameScoreText(): ObservableField<String> {
        return infoGameText
    }

    fun onCheckButtonClick() {
        if (ValidationUtil.checkValidity(number.inputNumber)) {
            gameScore = GameLogic.play(number)
            terms--
            if (terms > 0 && gameScore == GameScore.LOSE) {
                dataBindingNumber.set("")
                number.inputNumber = -1
                infoGameText.set(getResourcesStringById(R.string.incorrect) + terms)
            } else {
                eventNavigate.value = ResultActivity::class.java
            }
        } else {
            infoGameText.set(getResourcesStringById(R.string.not_valid_input))
        }
    }

    private fun generateNumber(): Numbers {
        return Numbers((0..100).random())
    }

    private fun getResourcesStringById(id: Int): String {
        return getApplication<Application>().resources.getString(id)
    }
}