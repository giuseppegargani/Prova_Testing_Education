package com.example.android.riprovatesting

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scritto: String = "cliccato"

        findViewById<Button>(R.id.button).setOnClickListener{
            val testo= findViewById<TextView>(R.id.scritta)
            testo.text = scritto

            /*e modifica i vincoli in Constraint Layout
            val params = testo.layoutParams as ConstraintLayout.LayoutParams
            Log.d("parametro", params.startToStart.toString())
            params.leftToLeft = ConstraintLayout.LayoutParams.LEFT
            testo.invalidate()
            testo.requestLayout()*/

            Toast.makeText(this,R.string.scritta_toast, Toast.LENGTH_SHORT).show()
        }
    }
}
