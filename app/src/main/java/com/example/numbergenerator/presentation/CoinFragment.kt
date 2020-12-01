package com.example.numbergenerator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.numbergenerator.R
import com.example.numbergenerator.util.ReusableMethods
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CoinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.coin_fragment, container, false)
        val btnFlips1 = view.findViewById<Button>(R.id.btnFlips1)
        val btnFlips2 = view.findViewById<Button>(R.id.btnFlips2)
        val btnFlips3 = view.findViewById<Button>(R.id.btnFlips3)
        val btnFlips4 = view.findViewById<Button>(R.id.btnFlips4)
        val btnFlips5 = view.findViewById<Button>(R.id.btnFlips5)
        val btnFlips6 = view.findViewById<Button>(R.id.btnFlips6)
        val btnFlip = view.findViewById<FloatingActionButton>(R.id.btnFlip)

        var numberOfCoins: Int = 0

        btnFlips1.setOnClickListener {
            numberOfCoins = 1
            btnFlips1.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips1.setTextColor(resources.getColor(android.R.color.black))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips2.setOnClickListener {
            numberOfCoins = 2
            btnFlips2.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips2.setTextColor(resources.getColor(android.R.color.black))
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips3.setOnClickListener {
            numberOfCoins = 3
            btnFlips3.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips3.setTextColor(resources.getColor(android.R.color.black))
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips4.setOnClickListener {
            numberOfCoins = 4
            btnFlips4.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips4.setTextColor(resources.getColor(android.R.color.black))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips5.setOnClickListener {
            numberOfCoins = 5
            btnFlips5.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips5.setTextColor(resources.getColor(android.R.color.black))
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips6.setOnClickListener {
            numberOfCoins = 6
            btnFlips6.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips6.setTextColor(resources.getColor(android.R.color.black))
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlip.setOnClickListener {
            generateResults(view, numberOfCoins)
        }
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    private fun generateResults(view: View, numberOfCoins: Int) {
        val reusableMethods = ReusableMethods()
        val txtSides = view.findViewById<TextView>(R.id.txtSides)
        val txtHeads = view.findViewById<TextView>(R.id.txtHeads)
        val txtTails = view.findViewById<TextView>(R.id.txtTails)
        val txtSides1 = view.findViewById<TextView>(R.id.txtSides1)
        val txtHeads1 = view.findViewById<TextView>(R.id.txtHeads1)
        val txtTails1 = view.findViewById<TextView>(R.id.txtTails1)
        val sides: MutableList<String> = ArrayList()
        var heads = 0
        var tails = 0

        when {
            numberOfCoins != 0 -> {
                for (i in 1..numberOfCoins.toInt()) {
                    val result = reusableMethods.rand(0, 1)

                    if (result == 0) {
                        sides.add("Heads")
                        heads++
                    } else {
                        sides.add("Tails")
                        tails++
                    }
                }

                val filtered = "[]"
                val displaySides = sides.toString().filterNot { filtered.indexOf(it) > -1 }

                txtSides1.text = ("Side(s): ")
                txtHeads1.text = ("# of Heads: ")
                txtTails1.text = ("# of Tails: ")

                txtSides.text = (displaySides)
                txtHeads.text = ("$heads")
                txtTails.text = ("$tails")

                sides.clear()
            }
            else -> {
                Toast.makeText(
                    this.requireContext(),
                    "Please select number of coins to flip!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}