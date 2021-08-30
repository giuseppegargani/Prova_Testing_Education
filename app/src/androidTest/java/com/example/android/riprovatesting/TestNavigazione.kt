package com.example.android.riprovatesting

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TestNavigazione {

    //indica quale attività aprire
    @get:Rule
    val activityRule2 = ActivityScenarioRule(MainActivity2::class.java)

    //TODO si può iniziare testando la presenza di un fragment in una attività

    //TODO e poi andiamo a testare la UI del fragment


}