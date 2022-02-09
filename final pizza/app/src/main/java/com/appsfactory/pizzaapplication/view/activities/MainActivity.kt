package com.appsfactory.pizzaapplication.view.activities

import android.app.Application
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.appsfactory.pizzaapplication.PizzaApplication
import com.appsfactory.pizzaapplication.R
import com.appsfactory.pizzaapplication.common.ActivityCompositeRoot
import com.appsfactory.pizzaapplication.common.ApplicationCompositeRoot
import com.appsfactory.pizzaapplication.databinding.ActivityMainBinding
import com.appsfactory.pizzaapplication.viewModels.DishListViewModel
import com.appsfactory.pizzaapplication.viewModels.AddDishViewModel

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var addDishViewModel: AddDishViewModel
    private lateinit var dishListViewModel: DishListViewModel
    private lateinit var navController: NavController
    private lateinit var activityCompositeRoot: ApplicationCompositeRoot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavController()
        setViewModels()
    }

    private fun setViewModels() {
        addDishViewModel = compositeRoot.addDishViewModel
        dishListViewModel = compositeRoot.dishListViewModel
    }

    private fun setNavController() {
        navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_pizza_list
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }

    fun hideBottomNavigationView() {
        binding.navView.clearAnimation()
        binding.navView.animate().translationY(binding.navView.height.toFloat()).duration = 300
    }

    fun showBottomNavigationView() {
        binding.navView.clearAnimation()
        binding.navView.animate().translationY(0f).duration = 300
    }
}