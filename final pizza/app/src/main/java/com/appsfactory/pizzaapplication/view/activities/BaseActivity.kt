package com.appsfactory.pizzaapplication.view.activities

import androidx.appcompat.app.AppCompatActivity
import com.appsfactory.pizzaapplication.PizzaApplication
import com.appsfactory.pizzaapplication.common.ActivityCompositeRoot

open class BaseActivity : AppCompatActivity() {

    private val appCompositeRoot get() = (application as PizzaApplication).applicationCompositeRoot

    val compositeRoot get() = ActivityCompositeRoot(this, appCompositeRoot)
}