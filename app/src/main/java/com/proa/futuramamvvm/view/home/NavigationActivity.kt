package com.proa.futuramamvvm.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.proa.futuramamvvm.R
import com.proa.futuramamvvm.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding
            .bottomNavigationView
            .setupWithNavController(
                navController
            )

        val appBarConfiguration =
            AppBarConfiguration(
                setOf(
                    R.id.homeNavigationFragment,
                    R.id.menuNavigationFragment
                ))

        setupActionBarWithNavController(navController,appBarConfiguration)
    }
}