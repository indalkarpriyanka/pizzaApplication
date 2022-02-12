package com.appsfactory.pizzaapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.appsfactory.pizzaapplication.view.activities.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class NavigationTest {

    @Test
    fun test_activity_navigation() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.navigation_pizza_list)).perform(click())
        onView(withId(R.id.layout_parent_pizza_list)).check(matches(isDisplayed()))

        onView(withId(R.id.menu_add)).perform(click())
        onView(withId(R.id.layout_parent_add_pizza)).check(matches(isDisplayed()))

        pressBack()
        onView(withId(R.id.layout_parent_pizza_list)).check(matches(isDisplayed()))

        pressBack()
        onView(withId(R.id.layout_parent_home)).check(matches(isDisplayed()))
    }
}