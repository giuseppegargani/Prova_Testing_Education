package com.example.android.riprovatesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scritto: String = "cliccato"

        findViewById<Button>(R.id.button).setOnClickListener{
            findViewById<TextView>(R.id.scritta).text = scritto.toString()
        }
    }
}
