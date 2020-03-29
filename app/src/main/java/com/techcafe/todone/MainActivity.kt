package com.techcafe.todone

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.techcafe.todone.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        nav_view.getHeaderView(0).setOnClickListener {
            val intent = ProfileActivity.createIntent(this)
            startActivity(intent)
            drawer_layout.closeDrawer(nav_view)
        }

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.drawer_menu_projects -> navController.navigate(R.id.projects)
                R.id.drawer_menu_settings -> navController.navigate(R.id.settings)
                R.id.drawer_menu_profile -> {
                    val intent = ProfileActivity.createIntent(this)
                    startActivity(intent)
                }
                R.id.drawer_menu_about_app -> navController.navigate(R.id.aboutapp)
                R.id.drawer_menu_sign_in -> navController.navigate(R.id.action_home_fragment_to_sign_in_graph)
            }
            drawer_layout.closeDrawer(nav_view)
            true
        }
    }
}
