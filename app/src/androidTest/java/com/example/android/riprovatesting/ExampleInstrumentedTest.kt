package com.example.android.riprovatesting

import android.app.ActionBar
import android.app.Application
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintAttribute
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.not

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
    fun controllaPresenzaScritta() {
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
    fun controllaBackgroundComeColore(){
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

    //controlla i parametri del layout
    @Test
    fun controllaParametriLayout(){
        val scenario = activityRule.scenario
        scenario.onActivity {
            //prende il riferimento alla View
            val view = it.findViewById<TextView>(R.id.scritta)

            //verifica le impostazioni per la larghezza
            val actualLayoutWidth = view.layoutParams.width
            val expectedWidth = ViewGroup.LayoutParams.WRAP_CONTENT
            assertEquals(actualLayoutWidth, expectedWidth)

            //verifica le impostazioni per l'altezza
            val actualLayoutHeight = view.layoutParams.height
            val expectedHeight = ViewGroup.LayoutParams.WRAP_CONTENT
            assertEquals(actualLayoutHeight, expectedHeight)
        }
    }

    @Test
    fun controllaVincoli(){
        val scenario = activityRule.scenario
        scenario.onActivity {
            //prende il riferimento alla View
            val view = it.findViewById<TextView>(R.id.scritta)
            val pulsante = it.findViewById<Button>(R.id.button)
            val params = view.layoutParams as ConstraintLayout.LayoutParams

            //verifica le impostazioni per la larghezza
            val constraintStart = params.startToStart
            val constraintEnd = params.endToEnd
            //se messo su "parent" altrimenti direttamente su un elemento come nel caso seguente
            val expectedWidth = ConstraintLayout.LayoutParams.PARENT_ID
            assertEquals(constraintStart, pulsante.id)
            assertEquals(constraintEnd, pulsante.id)
        }
    }

    @Test
    fun controlloStatoPulsanteConBackground(){

    }

    @Test
    fun controlloModificaDinamicaVincoli(){

    }

    //verifica che al premere del pulsante per una o per tre volte genera un toast
    //si può anche verificare per tre volte
    //CON UNA STRINGA DA CREARE CON IL NOME R.STRING.SCRITTA_TOAST
    @Test
    fun pushButton_ToastDisplayMessage(){
        val scenario = activityRule.scenario
        onView(withId(R.id.button)).perform(click())
        onView(withText(R.string.scritta_toast))
            //.inRoot(ToastMatcher())
            .check(matches(isDisplayed()));
    }

    @Test
    fun verifica_animazioni(){

    }
}
