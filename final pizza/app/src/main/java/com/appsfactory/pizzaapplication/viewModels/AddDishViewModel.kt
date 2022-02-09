package com.appsfactory.pizzaapplication.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsfactory.pizzaapplication.repository.remote.Pizza
import com.appsfactory.pizzaapplication.repository.remote.PizzaRepository
import kotlinx.coroutines.launch

class AddDishViewModel(private val repository: PizzaRepository) : ViewModel() {
    fun addPizza(pizza: Pizza) {
        viewModelScope.launch {
            repository.insertPizza(pizza)
        }
    }
}