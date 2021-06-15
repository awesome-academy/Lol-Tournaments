package com.sunasterisk.loltournaments.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.sunasterisk.loltournaments.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
    }

    private fun initComponents() {
        val navController = Navigation.findNavController(this@MainActivity, R.id.fragmentHost)
        bottomNav.apply {
            setupWithNavController(navController)
            setOnNavigationItemSelectedListener {
                if (it.itemId != bottomNav.selectedItemId) {
                    navController.navigate(it.itemId)
                }
                true
            }
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
