package com.techcafe.todone

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.techcafe.todone.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupWithNavController(bottom_navigation_view, navController)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.app_name, R.string.app_name
        )
        drawer_layout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navView.getHeaderView(0).setOnClickListener {
            navController.navigate(R.id.profile)
            drawer_layout.closeDrawer(nav_view)
        }

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.drawer_menu_projects -> navController.navigate(R.id.projects)
                R.id.drawer_menu_settings -> navController.navigate(R.id.settings)
                R.id.drawer_menu_profile -> navController.navigate(R.id.profile)
                R.id.drawer_menu_about_app -> navController.navigate(R.id.aboutapp)
                R.id.drawer_menu_sign_in -> navController.navigate(R.id.action_home_fragment_to_sign_in_graph)
            }
            drawer_layout.closeDrawer(nav_view)
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
