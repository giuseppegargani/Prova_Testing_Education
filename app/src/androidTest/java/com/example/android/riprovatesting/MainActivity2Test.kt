package com.example.android.riprovatesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivity2Test {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity2::class.java)

    //verifica la presenza del fragment dentro l'attività
    @Test
    fun verificaPresenzaFragment(){
        onView(withId(R.id.ExampleFragment)).check(matches(isDisplayed()))
    }

    //verifica presenza del textview dentro il fragment
    @Test
    fun verificaPresenzaTextViewFragment(){
        onView(withId(R.id.testo_frammento)).check(matches(isDisplayed()))
    }

}