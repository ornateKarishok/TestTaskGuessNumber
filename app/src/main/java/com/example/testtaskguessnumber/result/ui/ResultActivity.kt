package com.example.testtaskguessnumber.result.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testtaskguessnumber.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = resources.getString(R.string.game_results)

        setContentView(R.layout.activity_result)
    }
}