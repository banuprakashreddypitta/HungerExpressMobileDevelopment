package com.teamd.hungerexpressfooddelivery.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.teamd.hungerexpressfooddelivery.R
import com.teamd.hungerexpressfooddelivery.data.model.RestaurantListRequestItem
import com.teamd.hungerexpressfooddelivery.databinding.ItemRestaurantsBinding

class RestaurantAdapter (private val context:Context,private val restaurantList: List<RestaurantListRequestItem>) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = ItemRestaurantsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentRestaurant = restaurantList[position]
        holder.bind(currentRestaurant)
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    inner class RestaurantViewHolder(private val binding: ItemRestaurantsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurant: RestaurantListRequestItem) {
            // Bind data to the view elements using ViewBinding
            Glide.with(context)
                .load(restaurant.restaurantImg)
                .placeholder(R.drawable.loader)
                .into(binding.restaurantIv)

            binding.titleTv.text = restaurant.name
            binding.descriptionTv.text = restaurant.description
            binding.addressTv.text = restaurant.address
            binding.phoneNumberTv.text = restaurant.phone_number

            itemView.setOnClickListener {

            }
        }
    }
}