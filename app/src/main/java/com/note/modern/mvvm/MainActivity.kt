package com.note.modern.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowInsetsControllerCompat
import com.note.modern.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        installSplashScreen()
        setContentView(binding.root)
        changeStatusBarColor()

    }

    private fun changeStatusBarColor() {
        val controllerCompat = WindowInsetsControllerCompat(window, binding.root)
        controllerCompat.isAppearanceLightStatusBars = false
        window.statusBarColor = getColor(R.color.primary_color)
    }
}