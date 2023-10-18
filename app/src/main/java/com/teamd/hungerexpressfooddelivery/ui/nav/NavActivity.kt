package com.teamd.hungerexpressfooddelivery.ui.nav

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.teamd.hungerexpressfooddelivery.R
import com.teamd.hungerexpressfooddelivery.databinding.ActivityNavBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavActivity : AppCompatActivity() {
    companion object {
        fun start(activity: Activity) {
            activity.startActivity(Intent(activity,NavActivity::class.java))
            activity.finish()
        }
    }
    private lateinit var binding:ActivityNavBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)
    }
}