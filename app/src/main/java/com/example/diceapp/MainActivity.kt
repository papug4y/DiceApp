package com.example.diceapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerDice = findViewById<Spinner>(R.id.spinnerDice)
        val spinnerCount = findViewById<Spinner>(R.id.spinnerCount)
        val btnRoll = findViewById<Button>(R.id.btnRoll)
        val btnAuthors = findViewById<Button>(R.id.btnAuthors)

        val diceTypes = arrayOf("d4 (4 грани)", "d6 (6 граней)", "d8 (8 граней)", "d12 (12 граней)", "d20 (20 граней)")
        val adapterDice = ArrayAdapter(this, android.R.layout.simple_spinner_item, diceTypes)
        adapterDice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDice.adapter = adapterDice

        val diceCounts = arrayOf("1 кость", "2 кости", "3 кости", "4 кости", "5 костей")
        val adapterCount = ArrayAdapter(this, android.R.layout.simple_spinner_item, diceCounts)
        adapterCount.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCount.adapter = adapterCount

        btnRoll.setOnClickListener {
            val selectedDiceIndex = spinnerDice.selectedItemPosition
            val maxValue = when (selectedDiceIndex) {
                0 -> 4
                1 -> 6
                2 -> 8
                3 -> 12
                4 -> 20
                else -> 6
            }
            val numberOfDice = spinnerCount.selectedItemPosition + 1

            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("MAX_VALUE", maxValue)
            intent.putExtra("DICE_COUNT", numberOfDice)
            startActivity(intent)
        }

        btnAuthors.setOnClickListener {
            startActivity(Intent(this, AuthorsActivity::class.java))
        }
    }
}