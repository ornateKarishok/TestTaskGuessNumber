package com.example.testtaskguessnumber.result.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testtaskguessnumber.game.`object`.GameScore

class ResultViewModel(private val gameScore: GameScore?) : ViewModel() {
    fun onButtonClick() {
    }

    fun getGameScore(): GameScore? {
        return gameScore
    }
}