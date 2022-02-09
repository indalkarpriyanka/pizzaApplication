package com.appsfactory.pizzaapplication.common

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.appsfactory.pizzaapplication.viewModels.AddDishViewModel
import com.appsfactory.pizzaapplication.viewModels.DishListViewModel

class ActivityCompositeRoot(
    activity: AppCompatActivity,
    applicationCompositeRoot: ApplicationCompositeRoot
) {

    private val viewModelProviderFactory =
        applicationCompositeRoot.viewModelProviderFactory
    val addDishViewModel by lazy {
        ViewModelProvider(
            activity,
            viewModelProviderFactory
        )[AddDishViewModel::class.java]
    }

    val dishListViewModel by lazy {
        ViewModelProvider(
            activity,
            viewModelProviderFactory
        )[DishListViewModel::class.java]
    }
}
