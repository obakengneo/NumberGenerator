package com.example.numbergenerator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar

        actionBar!!.title = "Random Generator"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setUpBottomNavBar(navController)
    }

    private fun setUpBottomNavBar(navController: NavController) {
        bottom_nav.let { NavigationUI.setupWithNavController(it, navController) }
    }
}
