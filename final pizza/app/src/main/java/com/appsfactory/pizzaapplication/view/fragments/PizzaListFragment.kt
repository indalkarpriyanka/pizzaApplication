package com.appsfactory.pizzaapplication.view.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.appsfactory.pizzaapplication.R
import com.appsfactory.pizzaapplication.databinding.FragmentPizzaListBinding
import com.appsfactory.pizzaapplication.repository.remote.Pizza
import com.appsfactory.pizzaapplication.common.utils.Constants
import com.appsfactory.pizzaapplication.view.activities.MainActivity
import com.appsfactory.pizzaapplication.view.adapters.PizzaAdapter
import com.appsfactory.pizzaapplication.viewModels.DishListViewModel

class PizzaListFragment : Fragment() {

    private var _binding: FragmentPizzaListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.header_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            openAddPizzaFragment()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(requireActivity())[DishListViewModel::class.java]

        _binding = FragmentPizzaListBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView = binding.rcvDishList
        val adapter = PizzaAdapter()
        adapter.onItemClick = {
            openPizzaDetailFragment(it)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        dashboardViewModel.allPizzaList.observe(viewLifecycleOwner) {
            if(it.isEmpty()){
                binding.tvNoData.visibility=View.VISIBLE
                binding.rcvDishList.visibility=View.GONE

            }else
            {
                binding.tvNoData.visibility=View.GONE
                binding.rcvDishList.visibility=View.VISIBLE
                adapter.submitList(it)
            }

        }
        return root
    }

    private fun openAddPizzaFragment() {
        findNavController().navigate(
            R.id.action_navigation_pizza_list_to_navigation_add_pizza
        )
        hideBottomView()
    }

    private fun openPizzaDetailFragment(pizza: Pizza) {
        val bundle = Bundle()
        bundle.putParcelable(Constants.PIZZA_MODEL, pizza)
        findNavController().navigate(
            R.id.action_navigation_pizza_list_to_navigation_pizza_details, bundle
        )
        hideBottomView()
    }

    override fun onResume() {
        super.onResume()
        if (requireActivity() is MainActivity) {
            (requireActivity() as MainActivity).showBottomNavigationView()
        }
    }

    private fun hideBottomView() {
        if (requireActivity() is MainActivity) {
            (requireActivity() as MainActivity).hideBottomNavigationView()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}