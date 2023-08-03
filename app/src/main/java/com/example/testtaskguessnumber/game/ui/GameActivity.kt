package com.example.testtaskguessnumber.game.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.testtaskguessnumber.R
import com.example.testtaskguessnumber.databinding.ActivityGameBinding
import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.game.viewmodel.GameViewModel
import com.example.testtaskguessnumber.result.ui.ResultActivity
import com.example.testtaskguessnumber.util.SharedPreferencesUtil

class GameActivity : AppCompatActivity() {
    private val intentKeyGameResult = "Game result"
    private val intentKeyThoughtNumber = "Thought number"
    private lateinit var binding: ActivityGameBinding
    private var vmGame: GameViewModel = GameViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = resources.getString(R.string.simple_game)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)
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
            } else if (GameActivity::class.java == navigate) {
                Toast.makeText(
                    this,
                    resources.getString(R.string.incorrect) + (vmGame.getTerms()),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    resources.getString(R.string.not_valid_input),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun saveGameScore() {
        val sharedPreferences = SharedPreferencesUtil(this)
        if (vmGame.getGameScore() == GameScore.WIN) {
            sharedPreferences.increaseWonValue()
        } else if (vmGame.getGameScore() == GameScore.LOOSE) {
            sharedPreferences.increaseLoseValue()
        }
    }
}
