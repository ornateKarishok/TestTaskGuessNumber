package com.example.testtaskguessnumber.game.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.testtaskguessnumber.R
import com.example.testtaskguessnumber.result.ui.ResultActivity
import com.example.testtaskguessnumber.databinding.ActivityGameBinding
import com.example.testtaskguessnumber.game.viewmodel.GameViewModel
import com.example.testtaskguessnumber.util.ValidationUtil

class GameActivity : AppCompatActivity() {
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
                if (ValidationUtil.checkValidity(vmGame.getNumber().inputNumber)) {
                    val nextActivity = Intent(this, navigate)
                    startActivity(nextActivity)

                    finish()
                } else {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.not_valid_input),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }
}