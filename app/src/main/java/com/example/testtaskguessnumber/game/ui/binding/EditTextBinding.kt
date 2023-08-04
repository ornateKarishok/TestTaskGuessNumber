package com.example.testtaskguessnumber.game.ui.binding

import android.widget.EditText
import androidx.databinding.BindingAdapter


class EditTextBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("requestFocus")
        fun requestFocus(view: EditText, requestFocus: Boolean) {
            if (requestFocus) {
                view.isFocusableInTouchMode = true
                view.requestFocus()
            }
        }
    }

}