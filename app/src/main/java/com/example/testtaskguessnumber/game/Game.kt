package com.example.testtaskguessnumber.game

import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.game.`object`.Numbers

class Game {
    companion object Factory {
        fun play(number: Numbers): GameScore {
            return if (number.inputNumber == number.thoughtNumber) {
                GameScore.WIN
            } else {
                GameScore.LOSE
            }
        }
    }
}