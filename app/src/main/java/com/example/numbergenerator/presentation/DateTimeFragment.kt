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

class DateTimeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.datetime_fragment, container, false)
        val viewPager: ViewPager = view.findViewById(R.id.viewPagerDateTime)
        val tabs: TabLayout = view.findViewById(R.id.tabsDateTime)
        val adapter = MyViewPagerAdapter(childFragmentManager)

        setUpToolBar()

        adapter.addFragment(DateFragment(), "Date")
        adapter.addFragment(TimeFragment(), "Time")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    private fun setUpToolBar() {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar!!.title = "Date/Time"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
    }
}