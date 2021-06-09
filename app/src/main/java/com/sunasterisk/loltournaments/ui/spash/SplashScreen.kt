package com.sunasterisk.loltournaments.ui.spash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sunasterisk.loltournaments.ui.main.MainActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(MainActivity.getIntent(this))
        finish()
    }
}
