package com.example.numbergenerator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar!!.title = "Random Generator"

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val tabs: TabLayout = findViewById(R.id.tabs)

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(RandomFragment(), "RNG")
        adapter.addFragment(PasswordFragment(), "Password")
        adapter.addFragment(DiceFragment(), "Dice")
        adapter.addFragment(CoinFragment(), "Coin")
        adapter.addFragment(LottoFragment(), "Teams")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}
