package com.example.testtaskguessnumber.result.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.testtaskguessnumber.R
import com.example.testtaskguessnumber.databinding.ActivityResultBinding
import com.example.testtaskguessnumber.game.`object`.GameScore
import com.example.testtaskguessnumber.game.ui.GameActivity
import com.example.testtaskguessnumber.result.viewmodel.ResultViewModel

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
        vmResult.getEventNavigate().observe(this) { navigate ->
            if (GameActivity::class.java == navigate) {
                val nextActivity = Intent(this, navigate)
                startActivity(nextActivity)

                finish()
            }
        }
    }
}