package com.example.android.riprovatesting

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.core.IsNot.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivity3Test {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity3::class.java)

    @Test
    fun verificaIniziale(){
            Espresso.onView(ViewMatchers.withId(R.id.frameLayout3)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }

    //non esiste all'inizio ma dopo sì
    @Test
    fun verificaNonEsistenza(){
        onView(ViewMatchers.withId(R.id.primoFrammentoTest)).check(doesNotExist())
        onView(withId(R.id.pulsanteInizio)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.primoFrammentoTest)).check(ViewAssertions.matches(isDisplayed()))
    }

    //SI PUO' ANCHE PARTIRE DA UN CERTO FRAMMENTO IN ISOLAMENTO
    @Test
    fun verificaSchermoFinale(){
        onView(ViewMatchers.withId(R.id.primoFrammentoTest)).check(doesNotExist())
        onView(withId(R.id.pulsanteInizio)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.primoFrammentoTest)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.pulsanteAumenta)).perform(click())
        //DA RIDURRE e mettere con un ciclo
        onView(withId(R.id.pulsanteAumenta)).perform(click())
        onView(withId(R.id.pulsanteAumenta)).perform(click())
        onView(withId(R.id.pulsanteAumenta)).perform(click())
        onView(withId(R.id.pulsanteAumenta)).perform(click())
        onView(withId(R.id.pulsanteAumenta)).perform(click())
        onView(withId(R.id.pulsanteAumenta)).perform(click())
        onView(withId(R.id.pulsanteAumenta)).perform(click())
        onView(withId(R.id.pulsanteAumenta)).perform(click())
        onView(withId(R.id.pulsanteAumenta)).perform(click())
        onView(withId(R.id.pulsanteAumenta)).perform(click())
        onView(ViewMatchers.withId(R.id.frameLayout)).check(ViewAssertions.matches(isDisplayed()))
    }
}