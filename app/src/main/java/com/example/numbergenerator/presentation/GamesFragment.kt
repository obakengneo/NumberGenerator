package com.example.numbergenerator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.numbergenerator.R
import com.example.numbergenerator.adapter.MyViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class GamesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.games_fragment, container, false)
        val viewPager: ViewPager = view.findViewById(R.id.viewPager)
        val tabs: TabLayout = view.findViewById(R.id.tabs)
        val adapter = MyViewPagerAdapter(childFragmentManager)

        adapter.addFragment(DiceFragment(), "Dices")
        adapter.addFragment(CoinFragment(), "Coins")
        adapter.addFragment(CardFragment(), "Cards")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        setUpToolBar()

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    private fun setUpToolBar() {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar!!.title = "Games"
    }
}