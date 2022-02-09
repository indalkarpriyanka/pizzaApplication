package com.appsfactory.pizzaapplication.repository.remote

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PizzaDao {

    @Insert
    suspend fun insertPizza(pizza: Pizza)

    @Query("SELECT * FROM pizza_table ORDER BY id")
    fun getAllPizzas(): Flow<List<Pizza>>

    @Delete
    fun delete(pizza: Pizza)
}