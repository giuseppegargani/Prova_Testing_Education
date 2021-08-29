package com.example.android.riprovatesting

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule





/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class HelloWorldEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    //verifica la presenza di un campo di testo con una certa scritta
    @Test
    fun listGoesOverTheFold() {
        onView(withId(R.id.scritta)).check(matches(isDisplayed()))
        onView(withText("Eccomi qui!")).check(matches(isDisplayed()))
    }

    //verifica listener messo che modifica una textView
    @Test
    fun cliccaBottone_cambiaTesto(){
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.scritta)).check(matches(withText("cliccato")))
    }

    //verifica con un custom matcher sulle caratteristiche della view UI
    @Test
    fun controllaColore(){
        onView(withId(R.id.scritta)).check(matches(withTextColor(R.color.black)))
    }

    //verifica il colore di background con un esemplio semplice
    @Test
    fun controllaColoreBackground(){
        val scenario = activityRule.scenario
        scenario.onActivity {
            val view = it.findViewById<TextView>(R.id.scritta)
            val actualColor = (view.background as ColorDrawable).color
            val expectedColor = Color.parseColor("#99CC00")
            assertEquals(actualColor, expectedColor)
        }
    }

    //verifica altre caratteristiche di base della View
    //ma c'è un sistema per riferirsi ad una identica view? istanziare una View programmaticamente e verificarla
    @Test
    fun controllaOrientamentoLayout(){
        val scenario = activityRule.scenario
        scenario.onActivity {
            val view = it.findViewById<TextView>(R.id.scritta)
            val actualLayoutWidth = (view.layout.width).toString()
            val expectedWidth: String = "190"
            assertEquals(actualLayoutWidth, expectedWidth)
            Log.d("customView", actualLayoutWidth)
        }
    }
}
