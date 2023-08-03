package com.example.testtaskguessnumber.result.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.testtaskguessnumber.R
import com.example.testtaskguessnumber.databinding.ActivityResultBinding
import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.result.viewmodel.ResultViewModel
import com.example.testtaskguessnumber.util.ValidationUtil

class ResultActivity : AppCompatActivity() {
    val INTENT_KEY = "Game result"
    private lateinit var binding: ActivityResultBinding
    private lateinit var vmResult: ResultViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = resources.getString(R.string.game_results)

        val resultGame: GameScore? = intent.getSerializableExtra(INTENT_KEY) as GameScore?
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)
        binding.viewmodel = ResultViewModel(resultGame, this)
        binding.executePendingBindings()
        observe()
    }

    private fun observe() {

                    Toast.makeText(
                        this,
                        resources.getString(R.string.not_valid_input),
                        Toast.LENGTH_SHORT
                    ).show()
    }
}