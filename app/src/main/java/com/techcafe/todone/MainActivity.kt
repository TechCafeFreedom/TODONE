package com.techcafe.todone

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
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
            navController.navigate(R.id.profile, null)
            Toast.makeText(applicationContext, "headerだよ", Toast.LENGTH_SHORT).show()
            drawer_layout.closeDrawer(nav_view)
        }

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.drawer_menu_setting -> {
                    Toast.makeText(applicationContext, "Settingだよ", Toast.LENGTH_SHORT).show()
                }
            }
            drawer_layout.closeDrawer(nav_view)
            true
        }
    }
}
