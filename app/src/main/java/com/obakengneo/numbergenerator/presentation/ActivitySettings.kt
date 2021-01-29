package com.obakengneo.numbergenerator.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.obakengneo.db.SharedPref
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.util.Utility

class ActivitySettings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mode = Utility().setTheme(this, this)
        setContentView(R.layout.activity_settings)
        setUpToolBar()

        val sharedPref = SharedPref(this)
        val enableSwitch = findViewById<SwitchCompat>(R.id.enableDark) as SwitchCompat

        enableSwitch.isChecked = mode
        enableSwitch.setOnCheckedChangeListener { _, isChecked ->
            when {
                isChecked -> {
                    sharedPref.setNightModeState(true)
                    restartApp()
                }
                else -> {
                    sharedPref.setNightModeState(false)
                    restartApp()
                }
            }
        }
    }

    private fun setUpToolBar() {
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.settings)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar

        actionBar!!.setCustomView(R.layout.action_bar)
        actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)

        val txtActionBarTitle: TextView = findViewById<TextView>(R.id.tvTitle)
        val title = "Settings"
        txtActionBarTitle.text = title
    }

    private fun restartApp() {
        val intent = Intent(this, ActivitySettings::class.java)
        startActivity(intent)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        return true
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}