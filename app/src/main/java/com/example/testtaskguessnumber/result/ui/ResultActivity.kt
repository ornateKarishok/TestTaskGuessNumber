package com.example.testtaskguessnumber.result.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.testtaskguessnumber.R
import com.example.testtaskguessnumber.databinding.ActivityResultBinding
import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.menu.ui.MenuActivity
import com.example.testtaskguessnumber.result.viewmodel.ResultViewModel
import com.example.testtaskguessnumber.util.SerializableUtil.Factory.getSerializable

class ResultActivity : AppCompatActivity() {
    private val intentKeyGameResult = "Game result"
    private val intentKeyThoughtNumber = "Thought number"
    private lateinit var binding: ActivityResultBinding
    private lateinit var vmResult: ResultViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = resources.getString(R.string.game_results)

        val resultGame: GameScore =
            getSerializable(this, intentKeyGameResult, GameScore::class.java)
        val thoughtNumber = intent.getIntExtra(intentKeyThoughtNumber, 0)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)
        vmResult = ResultViewModel(resultGame, thoughtNumber, this)
        binding.viewmodel = vmResult
        binding.executePendingBindings()
        observe()
    }

    private fun observe() {
        vmResult.getEventNavigate().observe(this) { navigate ->
            if (MenuActivity::class.java == navigate) {
                val nextActivity = Intent(this, navigate)
                startActivity(nextActivity)

                finish()
            }
        }
    }
}