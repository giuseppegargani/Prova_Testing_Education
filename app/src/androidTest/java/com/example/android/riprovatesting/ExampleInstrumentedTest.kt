package com.example.android.riprovatesting

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
    @Test fun listGoesOverTheFold() {
        onView(withId(R.id.scritta)).check(matches(isDisplayed()))
        onView(withText("Eccomi qui!")).check(matches(isDisplayed()))
    }

    //verifica listener messo che modifica una textView
    @Test fun cliccaBottone_cambiaTesto(){
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.scritta)).check(matches(withText("cliccato")))
    }
}