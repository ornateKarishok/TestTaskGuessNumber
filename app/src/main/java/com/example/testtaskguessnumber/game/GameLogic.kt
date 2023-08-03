package com.example.testtaskguessnumber.game

import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.game.`object`.Numbers

class GameLogic {
    companion object Factory {
        fun play(number: Numbers): GameScore {
            return if (number.inputNumber == number.thoughtNumber) {
                GameScore.WON
            } else {
                GameScore.LOSE
            }
        }
    }
}