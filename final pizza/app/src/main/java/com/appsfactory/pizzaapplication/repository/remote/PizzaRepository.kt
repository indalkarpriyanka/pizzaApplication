package com.appsfactory.pizzaapplication.repository.remote

import kotlinx.coroutines.flow.Flow

class PizzaRepository(private val pizzaDao: PizzaDao) {
    suspend fun insertPizza(pizza: Pizza) {
        pizzaDao.insertPizza(pizza)
    }

    suspend fun deletePizza(pizza: Pizza) {
        pizzaDao.insertPizza(pizza)
    }

    val allPizzaList: Flow<List<Pizza>> = pizzaDao.getAllPizzas()
}