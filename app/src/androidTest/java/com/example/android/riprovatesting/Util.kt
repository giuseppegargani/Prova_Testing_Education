package com.example.android.riprovatesting

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.internal.util.Checks
import org.hamcrest.Description
import org.hamcrest.Matcher

fun withTextColor(color: Int): Matcher<View?>? {
    Checks.checkNotNull(color)
    return object : BoundedMatcher<View?, TextView>(TextView::class.java) {
        override fun matchesSafely(textView: TextView): Boolean {
            return ContextCompat.getColor(InstrumentationRegistry.getTargetContext(), color) == textView.currentTextColor
        }

        override fun describeTo(description: Description) {
            description.appendText("with text color: ")
        }
    }
}

/*fun withBackgroundColor(color: Int): Matcher<View?>? {
    Checks.checkNotNull(color)
    return object : BoundedMatcher<View?, TextView>(TextView::class.java) {
        override fun matchesSafely(textView: TextView): Boolean {
            return ContextCompat.getAttributionTag(Context.) getColor(InstrumentationRegistry.getTargetContext(), color) == textView.currentTextColor
        }

        override fun describeTo(description: Description) {
            description.appendText("with text color: ")
        }
    }
}*/

