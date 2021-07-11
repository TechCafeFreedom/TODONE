package com.techcafe.todone

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.techcafe.todone.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupWithNavController(binding.bottomNavigationView, navController)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.toolbar, R.string.app_name, R.string.app_name
        )
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navView.getHeaderView(0).setOnClickListener {
            navController.navigate(R.id.profile)
            binding.drawerLayout.closeDrawer(binding.navView)
        }

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.drawer_menu_settings -> navController.navigate(R.id.settings)
                R.id.drawer_menu_profile -> navController.navigate(R.id.profile)
                R.id.drawer_menu_about_app -> navController.navigate(R.id.aboutapp)
                R.id.drawer_menu_auth -> navController.navigate(R.id.auth)
            }
            binding.drawerLayout.closeDrawer(binding.navView)
            true
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.toolbar.isVisible = when (destination.id) {
                R.id.profile -> false
                R.id.edit_profile -> false
                else -> true
            }
            binding.bottomNavigationView.isVisible = when (destination.id) {
                R.id.profile -> false
                R.id.edit_profile -> false
                else -> true
            }
        }
    }
}
