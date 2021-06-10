package com.sunasterisk.loltournaments.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.sunasterisk.loltournaments.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
    }

    fun initComponents() {
        val navController = Navigation.findNavController(this@MainActivity, R.id.fragmentHost)
        bottomNav.apply {
            add(MeowBottomNavigation.Model(R.id.homeFragment, R.drawable.ic_home))
            add(MeowBottomNavigation.Model(R.id.teamsFragment, R.drawable.ic_teams))
            add(MeowBottomNavigation.Model(R.id.favoriteFragment, R.drawable.ic_favorite))
            add(MeowBottomNavigation.Model(R.id.moreFragment, R.drawable.ic_more))

            show(R.id.homeFragment, true)

            setOnShowListener {
                when (it.id) {
                    R.id.homeFragment -> navController.navigate(R.id.homeFragment)
                    R.id.teamsFragment -> navController.navigate(R.id.teamsFragment)
                    R.id.favoriteFragment -> navController.navigate(R.id.favoriteFragment)
                    R.id.moreFragment -> navController.navigate(R.id.moreFragment)
                }
            }
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
