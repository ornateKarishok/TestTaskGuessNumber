package com.example.testtaskguessnumber.util

import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.game.`object`.Numbers

class Game {
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