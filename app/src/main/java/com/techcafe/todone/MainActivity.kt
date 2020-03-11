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

        nav_header.setOnClickListener {
            navController.navigate(R.id.profile, null)
            drawer_layout.closeDrawer(nav_view)
        }

        item_settings.setOnClickListener {
            Toast.makeText(this, "Item Settings", Toast.LENGTH_SHORT).show()
            drawer_layout.closeDrawer(nav_view)
        }
        switch_settings.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                true -> Toast.makeText(this, "ダークテーマ！", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "ダークテーマじゃない！", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
