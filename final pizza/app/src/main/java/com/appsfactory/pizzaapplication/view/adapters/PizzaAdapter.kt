package com.appsfactory.pizzaapplication.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.appsfactory.pizzaapplication.databinding.ItemPizzaLayoutBinding
import com.appsfactory.pizzaapplication.repository.remote.Pizza


class PizzaAdapter :
    ListAdapter<Pizza, PizzaAdapter.PizzaViewHolder>(PizzaComparator()) {

    var onItemClick: ((Pizza) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {

        val itemBinding: ItemPizzaLayoutBinding = ItemPizzaLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PizzaViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.name)
    }

    inner class PizzaViewHolder(itemBinding: ItemPizzaLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        private val txDishName: TextView = itemBinding.tvDishName

        init {
            itemBinding.root.setOnClickListener {
                onItemClick?.invoke(getItem(adapterPosition))
            }
        }

        fun bind(text: String?) {
            txDishName.text = text
        }
    }
}

class PizzaComparator : DiffUtil.ItemCallback<Pizza>() {
    override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
        return oldItem == newItem
    }
}