package com.appsfactory.pizzaapplication.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.appsfactory.pizzaapplication.R
import com.appsfactory.pizzaapplication.databinding.FragmentAddPizzaBinding
import com.appsfactory.pizzaapplication.repository.remote.Pizza
import com.appsfactory.pizzaapplication.view.activities.MainActivity
import com.appsfactory.pizzaapplication.viewModels.AddDishViewModel
import com.google.android.material.snackbar.Snackbar


class AddPizzaFragment : Fragment() {

    private var _binding: FragmentAddPizzaBinding? = null
    private val binding get() = _binding!!
    private lateinit var addDishViewModel: AddDishViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addDishViewModel = (requireActivity() as MainActivity).compositeRoot.addDishViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddPizzaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddDish.setOnClickListener {

            val nameText = binding.etName.text.toString()
            val descriptionText = binding.etDescription.text.toString()
            when {
                nameText.isEmpty() -> showSnackBar(it, getString(R.string.invalid_name))
                descriptionText.isEmpty() -> showSnackBar(
                    it,
                    getString(R.string.invalid_description)
                )
                else -> {
                    val pizza = Pizza(nameText, descriptionText)
                    addDishViewModel.addPizza(pizza)
                    showSnackBar(it, getString(R.string.add_dish_success))
                    findNavController().popBackStack()
                }
            }
        }
    }

    private fun showSnackBar(view: View, text: String) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}