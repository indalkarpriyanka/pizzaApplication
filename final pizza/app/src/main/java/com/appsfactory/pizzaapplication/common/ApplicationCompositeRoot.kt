package com.appsfactory.pizzaapplication.common

import android.content.Context

import com.appsfactory.pizzaapplication.viewModels.PizzaViewModelProviderFactory
import com.appsfactory.pizzaapplication.repository.remote.PizzaDatabase
import com.appsfactory.pizzaapplication.repository.remote.PizzaRepository

class ApplicationCompositeRoot(context: Context) {

    private val database by lazy {
        PizzaDatabase.getDatabase(context)
    }
    val repository by lazy {
        PizzaRepository(database.pizzaDao())
    }
    val viewModelProviderFactory by lazy {
        PizzaViewModelProviderFactory(repository)
    }

}