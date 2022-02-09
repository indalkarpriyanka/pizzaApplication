package com.appsfactory.pizzaapplication.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.appsfactory.pizzaapplication.repository.remote.Pizza
import com.appsfactory.pizzaapplication.repository.remote.PizzaRepository

class DishListViewModel(repository: PizzaRepository) : ViewModel() {

    val allPizzaList: LiveData<List<Pizza>> = repository.allPizzaList.asLiveData()

}