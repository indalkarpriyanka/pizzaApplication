package com.appsfactory.pizzaapplication

import android.app.Application
import com.appsfactory.pizzaapplication.common.ApplicationCompositeRoot


class PizzaApplication : Application() {
    var applicationCompositeRoot: ApplicationCompositeRoot = ApplicationCompositeRoot(this)
}