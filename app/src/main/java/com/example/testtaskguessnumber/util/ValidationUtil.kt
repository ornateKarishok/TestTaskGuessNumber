package com.example.testtaskguessnumber.util

class ValidationUtil {
    companion object Factory {
        fun checkValidity(inputNumber: Int): Boolean {
            return inputNumber in 1..100
        }
    }
}