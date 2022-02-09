package com.appsfactory.pizzaapplication.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appsfactory.pizzaapplication.repository.remote.PizzaRepository

@Suppress("UNCHECKED_CAST")
class PizzaViewModelProviderFactory(private val repository: PizzaRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when (modelClass) {
        AddDishViewModel::class.java -> AddDishViewModel(repository)
        DishListViewModel::class.java -> DishListViewModel(repository)
        else -> throw IllegalArgumentException("Unknown ViewModel class")
    } as T
}