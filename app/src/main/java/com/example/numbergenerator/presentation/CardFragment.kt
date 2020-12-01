package com.example.numbergenerator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.numbergenerator.R
import com.example.numbergenerator.adapter.CardsAdapter
import com.example.numbergenerator.model.Card
import com.example.numbergenerator.util.ReusableMethods
import com.google.android.material.floatingactionbutton.FloatingActionButton


class CardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.card_fragment, container, false)
        val seek = view.findViewById<SeekBar>(R.id.sBarNumberOfCards)
        val progressOnBar = view.findViewById<TextView>(R.id.txtNumberOfCards)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvCards)
        val btnShuffleCards = view.findViewById<FloatingActionButton>(R.id.btnShuffleCards)
        val gridLayoutManager = GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = gridLayoutManager
        recyclerView.setHasFixedSize(true)

        btnShuffleCards.setOnClickListener {
            val cards = context?.let { CardsAdapter(it, getCards(seek.progress)) }
            recyclerView.adapter = cards
        }

        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                progressOnBar.text = seek.progress.toString()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                progressOnBar.text = seek.progress.toString()
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                progressOnBar.text = seek.progress.toString()
            }
        })

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    private fun getCards(numberOfCards: Int): ArrayList<Card> {
        val reusableMethods = ReusableMethods()
        val cards: ArrayList<Card> = ArrayList()
        val randomNumbers = reusableMethods.getRandomNumbersWithNoDuplicates(51, numberOfCards)

        for (i in 1..randomNumbers.size) {
            cards.add(Card(thumbImages[randomNumbers[i - 1]]))
        }

        return cards
    }

    private val thumbImages = arrayOf<Int>(
        R.drawable.ca, R.drawable.ha,
        R.drawable.c2, R.drawable.h2,
        R.drawable.c3, R.drawable.h3,
        R.drawable.c4, R.drawable.h4,
        R.drawable.c5, R.drawable.h5,
        R.drawable.c6, R.drawable.h6,
        R.drawable.c7, R.drawable.h7,
        R.drawable.c8, R.drawable.h8,
        R.drawable.c9, R.drawable.h9,
        R.drawable.c10, R.drawable.h10,
        R.drawable.cj, R.drawable.hj,
        R.drawable.cq, R.drawable.hk,
        R.drawable.ck, R.drawable.hq,
        R.drawable.da, R.drawable.aa,
        R.drawable.d2, R.drawable.s2,
        R.drawable.d3, R.drawable.s3,
        R.drawable.d4, R.drawable.s4,
        R.drawable.d5, R.drawable.s5,
        R.drawable.d6, R.drawable.s6,
        R.drawable.d7, R.drawable.s7,
        R.drawable.d8, R.drawable.s8,
        R.drawable.d9, R.drawable.s9,
        R.drawable.d10, R.drawable.s10,
        R.drawable.dj, R.drawable.sj,
        R.drawable.dq, R.drawable.sk,
        R.drawable.dk, R.drawable.sq
    )
}