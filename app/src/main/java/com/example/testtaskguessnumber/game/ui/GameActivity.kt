package com.example.testtaskguessnumber.game.ui

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.testtaskguessnumber.R
import com.example.testtaskguessnumber.databinding.ActivityGameBinding
import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.game.viewmodel.GameViewModel
import com.example.testtaskguessnumber.result.ui.ResultActivity
import com.example.testtaskguessnumber.util.SharedPreferencesUtil

class GameActivity : AppCompatActivity() {
    private val intentKeyGameResult = "GAME_RESULT"
    private val intentKeyThoughtNumber = "THOUGHT_NUMBER"
    private lateinit var binding: ActivityGameBinding
    private lateinit var vmGame: GameViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = resources.getString(R.string.simple_game)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)
        vmGame = GameViewModel(application)
        binding.viewmodel = vmGame
        binding.executePendingBindings()
        observe()
    }

    private fun observe() {
        vmGame.getEventNavigate().observe(this) { navigate ->
            if (ResultActivity::class.java == navigate) {
                saveGameScore()
                val nextActivity = Intent(this, navigate)
                nextActivity.putExtra(intentKeyGameResult, vmGame.getGameScore())
                nextActivity.putExtra(intentKeyThoughtNumber, vmGame.getNumbers().thoughtNumber)
                startActivity(nextActivity)

                finish()
            }
        }
    }

    private fun saveGameScore() {
        val sharedPreferences = SharedPreferencesUtil(this)
        if (vmGame.getGameScore() == GameScore.WON) {
            sharedPreferences.increaseWonValue()
        } else if (vmGame.getGameScore() == GameScore.LOSE) {
            sharedPreferences.increaseLoseValue()
        }
    }
}
