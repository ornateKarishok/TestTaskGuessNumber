package com.example.testtaskguessnumber.game.`object`

data class Numbers(val thoughtNumber: Int, var inputNumber: Int) {
    constructor(thoughtNumber: Int) : this(thoughtNumber, -1)
}
