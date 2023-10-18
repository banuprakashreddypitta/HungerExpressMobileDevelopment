package com.teamd.hungerexpressfooddelivery.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import com.teamd.hungerexpressfooddelivery.AuthViewModel
import com.teamd.hungerexpressfooddelivery.data.adapter.RestaurantAdapter
import com.teamd.hungerexpressfooddelivery.data.model.SignUpRequest
import com.teamd.hungerexpressfooddelivery.databinding.FragmentHomeBinding
import com.teamd.hungerexpressfooddelivery.ui.base.BaseFragment
import com.teamd.hungerexpressfooddelivery.utils.network.NetworkResult
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private lateinit var homeBinding: FragmentHomeBinding
    private val authViewMode by viewModels<AuthViewModel>()

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return homeBinding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindObserver()
        authViewMode.restaurantList()
    }

    private fun bindObserver() {
        authViewMode.restaurantResponseLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is NetworkResult.Success -> {
                    if(it.data != null) {
                        homeBinding.rv.adapter = RestaurantAdapter(requireContext(), it.data)
                    }
                }

                is NetworkResult.Error -> {
                    Toast.makeText(requireContext(), "Error!! ${it.message}", Toast.LENGTH_LONG)
                        .show()
                }

                is NetworkResult.Loading -> {

                }
            }
        })
    }
}