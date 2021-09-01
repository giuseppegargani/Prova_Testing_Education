package com.example.android.riprovatesting

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.InstrumentationRegistry.getTargetContext
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import com.example.android.riprovatesting.Fragments.Primo
import com.example.android.riprovatesting.Fragments.example
import org.hamcrest.core.IsNot.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
    - PRESSBACK E PRESSBACK UNCONDITIONALLY
    https://developer.android.com/reference/androidx/test/espresso/Espresso#pressBack(
    - MOLTO INTERESSANTE!!! su come cliccare sul menù:
    https://www.py4u.net/discuss/612267
    - GET INSTRUMENTATION CONTEXT IN KOTLIN:
    https://stackoverflow.com/questions/52924431/androidx-test-instrumentationregistry-is-deprecated
    - CUCUMBER LIBRARY PER MIGLIORARE LA LEGGIBIITA'
    https://www.browserstack.com/guide/learn-about-cucumber-testing-tool
    - A VOLTE Thread.sleep(1000) PUò ESSERE UTILE PER VISUALIZZARE IN DIRETTA
    - PROVARE A CANCELLARE FRAMMENTI E LASCIARE IL TEST
    -PROBLEMI CON CLASSPATH SI SAFEARGS
    https://stackoverflow.com/questions/67039491/some-problems-were-found-with-the-configuration-of-task-appgeneratesafeargsde
    **************************************************************************************************************************
    COME TESTARE NAVIGAZIONE:
    **************************************************************************************************************************
    https://developer.android.com/guide/navigation/navigation-testing
    **************************************************************************************************************************
    GUIDA PER TESTARE FRAMMENTI:
    **************************************************************************************************************************
    https://developer.android.com/guide/fragments/test
    -SI PUO' PASSARE DA UNA ATTIVITA' AD UN ALTRA CON NAVGRAPH E PASSARE ARGOMENTI!!!
    https://stackoverflow.com/questions/62214514/navigate-from-one-activity-to-another-with-navigation-component
 */

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

    //SI PUO' ANCHE PARTIRE DA UN CERTO FRAMMENTO IN ISOLAMENTO?
    @Test
    fun verificaSchermoFinale(){
        onView(ViewMatchers.withId(R.id.primoFrammentoTest)).check(doesNotExist())
        onView(withId(R.id.pulsanteInizio)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.primoFrammentoTest)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.pulsanteAumenta)).perform(click())
        //DA RIDURRE e mettere con un ciclo
        onView(withId(R.id.pulsanteAumenta)).perform(click()).perform(click()).perform(click()).perform(click()).perform(click()).perform(click()).perform(click()).perform(click()).perform(click()).perform(click())
        onView(ViewMatchers.withId(R.id.frameLayout)).check(ViewAssertions.matches(isDisplayed()))
    }

    //Partendo da un certo frammento e vedendo il risultato
    @Test
    fun verificaDaFrammento(){
        val scenario = launchFragmentInContainer<Primo>()
        Espresso.onView(ViewMatchers.withId(R.id.primoFrammentoTest)).check(ViewAssertions.matches(isDisplayed()))
    }

    //testare il pulsante di back da varie angolazioni
    @Test
    fun verificaPulsanteBackDaPrimoAIniziale(){
    //verifica dal primo schermo e tornare indietro
        onView(withId(R.id.primoFrammentoTest)).check(doesNotExist())
        onView(withId(R.id.pulsanteInizio)).perform(click())
        onView(withId(R.id.primoFrammentoTest)).check(matches(isDisplayed()))
        onView(withId(R.id.frameLayout3)).check(doesNotExist())
        //Oppure PressBackUncoditionally e non genera errore se ritorna indietro al mobile
        onView(withId(R.id.primoFrammentoTest)).perform(pressBack())
        onView(withId(R.id.frameLayout3)).check(matches(isDisplayed()))
    }

    //verifica menù: verifica che inizialmente "About us" fragment non esiste e poi clicca su menù, apre il frammento e verifica la presenza del campo di testo interno
    @Test
    fun cliccareOpzioneSuMenu(){
        onView(withId(R.id.frameLayout4)).check(doesNotExist())
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().targetContext)
        onView(withText(R.string.about_us)).perform(click())
        onView(withId(R.id.frameLayout4)).check(matches(isDisplayed()))
        onView(withText(R.string.descrizione_about_us)).check(matches(isDisplayed()))
    }

    //verifica il corretto numero di click sul terzo frammento
    @Test
    fun numClicks_cinqueClicks_restituisciNumCorretto(){
        onView(withId(R.id.pulsanteInizio)).perform(click())
        onView(withId(R.id.pulsanteAumenta)).perform(click()).perform(click()).perform(click()).perform(click()).perform(click()).perform(click())
        onView(withId(R.id.pulsanteDiminuisci)).perform(click())
        onView(withId(R.id.PulsanteTermina)).perform(click())
        onView(withId(R.id.numeroClick)).check(matches(withText("5")))
    }

}