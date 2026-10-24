package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AuthorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authors)

        val btnBackAuthors = findViewById<Button>(R.id.btnBackAuthors)
        btnBackAuthors.setOnClickListener {
            finish()
        }
    }
}