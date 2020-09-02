package com.example.numbergenerator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CoinFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.coin_fragment, container, false)
        val reusableMethods = ReusableMethods()

        setUpToolBar()

        val txtNumberOfCoins = view.findViewById<EditText>(R.id.edtNumberOfCoins)
        val txtSides = view.findViewById<TextView>(R.id.txtSides)
        val txtHeads = view.findViewById<TextView>(R.id.txtHeads)
        val txtTails = view.findViewById<TextView>(R.id.txtTails)
        val txtSides1 = view.findViewById<TextView>(R.id.txtSides1)
        val txtHeads1 = view.findViewById<TextView>(R.id.txtHeads1)
        val txtTails1 = view.findViewById<TextView>(R.id.txtTails1)
        val btnFlip = view.findViewById<FloatingActionButton>(R.id.btnFlip)

        val sides: MutableList<String> = ArrayList()
        var heads = 0
        var tails = 0

        btnFlip.setOnClickListener {
            val numberOfCoins = txtNumberOfCoins.text.toString()

            when {
                numberOfCoins != "" -> {
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

                    heads = 0
                    tails = 0
                    sides.clear()
                }
                else -> {
                    Toast.makeText(
                        this.requireContext(),
                        "Please insert a number of coins to flip!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    private fun setUpToolBar () {
        val actionBar = (activity as AppCompatActivity).supportActionBar

        actionBar!!.title = "Coin Flipper"
    }
}