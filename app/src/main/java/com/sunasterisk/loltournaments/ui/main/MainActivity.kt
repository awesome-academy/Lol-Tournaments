package com.sunasterisk.loltournaments.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.sunasterisk.loltournaments.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val navController by lazy { Navigation.findNavController(this, R.id.fragmentHost) }
    private val menuList = listOf(
        R.id.homeFragment,
        R.id.teamsFragment,
        R.id.favoriteFragment,
        R.id.moreFragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav.setupWithNavController(navController)
    }

    private fun openExitDialog() {
        AlertDialog.Builder(this).apply {
            setMessage(MESSAGE_EXIT)
            setPositiveButton(OPTION_YES) { _, _ -> finish() }
            setNegativeButton(OPTION_NO, null)
            show()
        }
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id in menuList) {
            openExitDialog()
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        const val MESSAGE_EXIT = "Do you want exit app?"
        const val OPTION_YES = "YES"
        const val OPTION_NO = "NO"

        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
