package com.example.numbergenerator.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.numbergenerator.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        findViewById<NavigationView>(R.id.navigationView).setNavigationItemSelectedListener(this)
        val drawLayout = findViewById<DrawerLayout>(R.id.drawer)
        val toggle = ActionBarDrawerToggle(
            this,
            drawLayout,
            toolbar,
            R.string.drawerOpen,
            R.string.drawerClose
        )
        drawLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setUpBottomNavBar(navController)
    }

    private fun setUpBottomNavBar(navController: NavController) {
        bottom_nav.let { NavigationUI.setupWithNavController(it, navController) }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> {
            }
            R.id.share -> {
            }
            R.id.rate -> {
            }
            R.id.about -> {
            }
        }
        return true
    }
}
