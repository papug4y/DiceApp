package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private var maxValue = 6
    private var diceCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val tvResultSum = findViewById<TextView>(R.id.tvResultSum)
        val tvDetails = findViewById<TextView>(R.id.tvDetails)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnReroll = findViewById<Button>(R.id.btnReroll)

        maxValue = intent.getIntExtra("MAX_VALUE", 6)
        diceCount = intent.getIntExtra("DICE_COUNT", 1)

        rollDice(tvResultSum, tvDetails)

        btnReroll.setOnClickListener {
            rollDice(tvResultSum, tvDetails)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun rollDice(tvResultSum: TextView, tvDetails: TextView) {
        var totalSum = 0
        val resultsList = mutableListOf<Int>()

        for (i in 1..diceCount) {
            val result = Random.nextInt(1, maxValue + 1)
            resultsList.add(result)
            totalSum += result
        }

        tvResultSum.text = "Сумма: $totalSum"
        val resultsString = resultsList.joinToString(", ")
        tvDetails.text = "Выпало: $resultsString"
    }
}