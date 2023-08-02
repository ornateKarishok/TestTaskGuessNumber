package com.example.testtaskguessnumber.game.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testtaskguessnumber.result.ui.ResultActivity
import com.example.testtaskguessnumber.game.`object`.Numbers

class GameViewModel : ViewModel() {
    private val number: Numbers = generateNumber()

    private val eventNavigate = MutableLiveData<Class<*>>()
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


    fun onCheckButtonClick() {

            eventNavigate.value = ResultActivity::class.java

    }

    private fun generateNumber(): Numbers {
        return Numbers((0..100).random())
    }
}