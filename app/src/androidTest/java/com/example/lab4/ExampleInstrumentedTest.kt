package com.example.lab4

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.Assert.assertEquals
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activityActivityTestRule = ActivityTestRule(MainActivity::class.java)
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.lab4", appContext.packageName)
    }
    @Test
    fun test1(){
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.button)).check(matches(withText("Зачем вы нажали?")))
        onView(withId(R.id.editText)).perform(typeText("hello"))
        activityActivityTestRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        onView(withId(R.id.editText)).check(matches(withText("hello")))
        onView(withId(R.id.button)).check(matches(withText("Button")))

    }
}