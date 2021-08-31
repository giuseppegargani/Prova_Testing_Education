package com.example.android.riprovatesting.Fragments

import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
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
import org.hamcrest.core.AllOf
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import org.hamcrest.core.Is.`is`


/*
    E' STATO AGGIUNTO IL DATABINDING E QUINDI CONVIENE TOGLIERLO PER SIMULARE CHE VENGA MESSO
    SE COMPARE IL MESSAGGIO DI ERRORE 'META INF-ALL'
    https://www.codegrepper.com/code-examples/java/More+than+one+file+was+found+with+OS+independent+path+%27META-INF%2FAL2.0%27.+when+running+android+test
    SE COMPARE UN MESSAGGIO DI ERRORE NO STATIC METHOD
    https://stackoverflow.com/questions/67358179/android-espresso-test-error-no-static-method-loadsingleserviceornull
    TOAST IN A FRAGMENT
    http://5.9.10.113/66823421/how-to-test-a-toast-in-a-fragment
    PER VEDERE ESEMPI DI UTILIZZO DI "WITHCLASSNAME"
    https://www.tabnine.com/code/java/methods/android.support.test.espresso.matcher.ViewMatchers/withClassName
    CHE SONO MOLTO INTERESSANTI!!!!
    ESEMPI DI TABNINE!!!!
    ISASSIGNABLEFROM:
    https://www.tabnine.com/code/java/methods/android.support.test.espresso.matcher.ViewMatchers/isAssignableFrom
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

    //testare la presenza di un frammento dentro una attività - SPOSTATO AD UN FILE A PARTE - MODO PIù CORRETTO
    //il fragment è testato isolatamente

    //verifica i componenti UI in fragment
    @Test
    fun TextInFragment(){
        val scenario = launchFragmentInContainer<example>()
        onView(withId(R.id.testo_frammento)).check(matches(isDisplayed()))
        onView(withText("Hello Fragment!!")).check(matches(isDisplayed()))
        onView(withId(R.id.testo_frammento)).check(matches(withText("Hello Fragment!!")))
    }

    //con utilizzo di isAssignablefrom e matcher multipli
    @Test
    fun ElementoTextviewDiscendenteDirettoDiFrameLayout_VerificaTesto(){
        val scenario = launchFragmentInContainer<example>()
        onView(allOf(withId(R.id.testo_frammento), withText("Hello Fragment!!"))).check(matches(isDisplayed()))
        //verifica che la TextView con un certo ID ha come contenuto un certo testo
        onView(allOf(isAssignableFrom(TextView::class.java), withId(R.id.testo_frammento))).check(matches(withText("Hello Fragment!!")))
        onView(allOf(isAssignableFrom(TextView::class.java), withId(R.id.testo_frammento), isDescendantOfA(withClassName(`is`("android.widget.FrameLayout"))))).check(matches(withText("Hello Fragment!!")))
        //riprova: il seguente fallisce perchè la classe non è corretta
        //onView(allOf(isAssignableFrom(Button::class.java), withId(R.id.testo_frammento), isDescendantOfA(withClassName(`is`("android.widget.FrameLayout"))))).check(matches(withText("Hello Fragment!!")))
        //oppure il genitore non è del tipo giusto
        //onView(allOf(isAssignableFrom(TextView::class.java), withId(R.id.testo_frammento), isDescendantOfA(withClassName(`is`("android.widget.ConstraintLayout"))))).check(matches(withText("Hello Fragment!!")))
    }

    //verifica animazioni fragment

}