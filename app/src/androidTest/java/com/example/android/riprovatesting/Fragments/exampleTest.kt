package com.example.android.riprovatesting.Fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.android.riprovatesting.MainActivity
import com.example.android.riprovatesting.MainActivity2
import com.example.android.riprovatesting.R
import com.example.android.riprovatesting.databinding.FragmentExampleBinding
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/*
    E' STATO AGGIUNTO IL DATABINDING E QUINDI CONVIENE TOGLIERLO PER SIMULARE CHE VENGA MESSO
    SE COMPARE IL MESSAGGIO DI ERRORE 'META INF-ALL'
    https://www.codegrepper.com/code-examples/java/More+than+one+file+was+found+with+OS+independent+path+%27META-INF%2FAL2.0%27.+when+running+android+test
    SE COMPARE UN MESSAGGIO DI ERRORE NO STATIC METHOD
    https://stackoverflow.com/questions/67358179/android-espresso-test-error-no-static-method-loadsingleserviceornull
    TOAST IN A FRAGMENT
    http://5.9.10.113/66823421/how-to-test-a-toast-in-a-fragment
 */

@MediumTest
@RunWith(AndroidJUnit4::class)
class exampleTest{

    //verifica il DataBinding su fragment o abilitazione

    //verifica la creazione del fragment
    @Test
    fun fragmentInUi() {
        launchFragmentInContainer<example>()
    }

    //testare la presenza di un frammento dentro una attività
    //si può anche mettere come Rule
    //verifica child
    @Test
    fun fragmentInsideActivity(){
        val activityRule = ActivityScenarioRule(MainActivity2::class.java)
        onView(withClassName(is('android.widget.Fragment'))).
    }

    //verifica i componenti UI in fragment
    @Test
    fun TextInFragment(){
        val scenario = launchFragmentInContainer<example>()
        onView(withId(R.id.testo_frammento)).check(matches(isDisplayed()))
        onView(withText("Hello Fragment!!")).check(matches(isDisplayed()))
        onView(withId(R.id.testo_frammento)).check(matches(withText("Hello Fragment!!")))
    }

    //verifica animazioni fragment

}