package com.example.numbergenerator

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class TeamsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setUpToolBar()
        return inflater.inflate(R.layout.teams_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)

        super.onCreate(savedInstanceState)
    }

    private fun setUpToolBar () {
        val actionBar = (activity as AppCompatActivity).supportActionBar

        actionBar!!.title = "Team Generator"
    }
}