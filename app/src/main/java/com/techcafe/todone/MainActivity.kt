package com.techcafe.todone

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_drawer_header.*
import kotlinx.android.synthetic.main.nav_drawer_header.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val navController = findNavController(R.id.nav_host_fragment)
        setupWithNavController(bottom_navigation_view, navController)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.app_name, R.string.app_name
        )
        drawer_layout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        nav_view.getHeaderView(0).setOnClickListener {
            Toast.makeText(applicationContext, "headerだよ", Toast.LENGTH_SHORT).show()
            drawer_layout.closeDrawer(nav_view)
        }

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.drawer_menu_1 -> {
                    Toast.makeText(applicationContext, "item1だよ", Toast.LENGTH_SHORT).show()
                }
                R.id.drawer_menu_2 -> {
                    Toast.makeText(applicationContext, "item2だよ", Toast.LENGTH_SHORT).show()
                }
                R.id.drawer_menu_3 -> {
                    Toast.makeText(applicationContext, "item3だよ", Toast.LENGTH_SHORT).show()
                }
            }
            drawer_layout.closeDrawer(nav_view)
            true
        }
    }
}
