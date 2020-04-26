package com.techcafe.todone

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManagerFactory
import com.techcafe.todone.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var manager: SplitInstallManager

    private val listener = SplitInstallStateUpdatedListener { state ->
        when (state.status()) {
            SplitInstallSessionStatus.DOWNLOADING -> {
                // ダウンロード中
                Timber.d("ダウンロード中")
                val total = state.totalBytesToDownload()
                val downloaded = state.bytesDownloaded()
            }
            SplitInstallSessionStatus.INSTALLING -> {
                // インストール中
                Timber.d("インストール中")
            }
            SplitInstallSessionStatus.INSTALLED -> {
                // インストール終了
                val navHostFragment =
                    supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                val navController = navHostFragment.navController
                navController.navigate(R.id.settings)
            }
            SplitInstallSessionStatus.FAILED -> {
                // 失敗
                Timber.d("失敗")
            }
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.installActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(toolbar)

        manager = if (BuildConfig.DEBUG) {
            FakeSplitInstallManagerFactory.create(this, this.getExternalFilesDir(null))
        } else {
            SplitInstallManagerFactory.create(this)
        }

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
                R.id.drawer_menu_settings -> loadModule(navController)
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

    override fun onStart() {
        super.onStart()
        manager.registerListener(listener)
    }

    override fun onStop() {
        super.onStop()
        manager.unregisterListener(listener)
    }

    private fun loadModule(navController: NavController) {

        navController.navigate(R.id.settings)

        if (manager.installedModules.contains("settings")) {
            // 既にインストール済みのとき
            Timber.d("すでにインストール済みだよ")
            navController.navigate(R.id.settings)
            return
        }

        val request = SplitInstallRequest.newBuilder()
            .addModule("settings")
            .build()
        Timber.d("インストールStartした")
        manager.startInstall(request)
            .addOnSuccessListener { /* インストールリクエストが成功したとき */ }
            .addOnFailureListener { /* インストールリクエストが失敗したとき */ }
    }
}
