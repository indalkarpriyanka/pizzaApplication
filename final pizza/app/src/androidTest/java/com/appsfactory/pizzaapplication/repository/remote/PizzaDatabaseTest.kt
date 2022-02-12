package com.appsfactory.pizzaapplication.repository.remote

import android.content.Context
import androidx.lifecycle.asLiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.IOException

class PizzaDatabaseTest {

    private lateinit var db: PizzaDatabase
    private lateinit var pizzaDao: PizzaDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        db = Room.inMemoryDatabaseBuilder(
            context, PizzaDatabase::class.java
        ).build()
        pizzaDao = db.pizzaDao()

    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() = runBlocking {
        val pizza = Pizza("pizza1", "onion,garlic,olives")
        pizzaDao.insertPizza(pizza)

        val pizzaList = pizzaDao.getAllPizzas().first()

        assertEquals(pizzaList[0].name, pizza.name)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }


}