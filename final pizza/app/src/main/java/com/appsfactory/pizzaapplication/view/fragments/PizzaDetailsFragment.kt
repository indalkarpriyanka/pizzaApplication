package com.appsfactory.pizzaapplication.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.room.util.StringUtil
import com.appsfactory.pizzaapplication.common.utils.Constants
import com.appsfactory.pizzaapplication.common.utils.Constants.capitalise
import com.appsfactory.pizzaapplication.databinding.FragmentPizzaDetailsBinding
import com.appsfactory.pizzaapplication.repository.remote.Pizza


class PizzaDetailsFragment : Fragment() {
    private var _binding: FragmentPizzaDetailsBinding? = null
    private val binding get() = _binding!!

    private var pizza: Pizza? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pizza = it.getParcelable(Constants.PIZZA_MODEL)
            pizza?.name?.let { it1 -> Log.d("name", it1) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPizzaDetailsBinding.inflate(inflater, container, false)
        pizza?.let {
            binding.txtPizzaDesc.text = it.description
            (activity as AppCompatActivity?)!!.supportActionBar!!.title = it.name.capitalise()
        }


        return binding.root
    }
}