package com.obakengneo.numbergenerator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.adapter.MyViewPagerAdapter

class SecurityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.security_fragment, container, false)
        val viewPager: ViewPager = view.findViewById(R.id.viewPager)
        val tabs: TabLayout = view.findViewById(R.id.tabs)
        val adapter = MyViewPagerAdapter(childFragmentManager)

        adapter.addFragment(PasswordFragment(), "Password")
        adapter.addFragment(RandomFragment(), "Numbers")


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
        actionBar!!.title = "Password/Numbers"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
    }
}