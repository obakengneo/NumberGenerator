package com.example.numbergenerator

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class DiceFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.dice_fragment, container, false)

        setUpToolBar()

        val reusableMethods = ReusableMethods()

        val txtRolls = view.findViewById<TextView>(R.id.txtRolls)
        val txtSumOfDie = view.findViewById<TextView>(R.id.txtSumOfDie)
        val btnRoll = view.findViewById<Button>(R.id.btnRoll)
        val btnNumberOfDice1 = view.findViewById<Button>(R.id.btnNumberOfDice1)
        val btnNumberOfDice2 = view.findViewById<Button>(R.id.btnNumberOfDice2)
        val btnNumberOfDice3 = view.findViewById<Button>(R.id.btnNumberOfDice3)
        val btnNumberOfDice4 = view.findViewById<Button>(R.id.btnNumberOfDice4)
        val btnSides4 = view.findViewById<Button>(R.id.btnSides4)
        val btnSides6 = view.findViewById<Button>(R.id.btnSides6)
        val btnSides10 = view.findViewById<Button>(R.id.btnSides10)
        val btnSides8 = view.findViewById<Button>(R.id.btnSides8)
        val btnSides12 = view.findViewById<Button>(R.id.btnSides12)
        val btnSides16 = view.findViewById<Button>(R.id.btnSides16)

        var numberOfDice = 0
        var numberOfSides = 0
        var sum = 0

        val rolls: MutableList<String> = ArrayList()

        btnNumberOfDice1.setOnClickListener {
            numberOfDice = 1
            btnNumberOfDice1.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnNumberOfDice3.setBackgroundResource(R.drawable.small_btn_background)
            btnNumberOfDice2.setBackgroundResource(R.drawable.small_btn_background)
            btnNumberOfDice4.setBackgroundResource(R.drawable.small_btn_background)

            btnNumberOfDice4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnNumberOfDice1.setTextColor(resources.getColor(android.R.color.black))
            btnNumberOfDice2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnNumberOfDice3.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnNumberOfDice2.setOnClickListener {
            numberOfDice = 2
            btnNumberOfDice2.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnNumberOfDice1.setBackgroundResource(R.drawable.small_btn_background)
            btnNumberOfDice4 .setBackgroundResource(R.drawable.small_btn_background)
            btnNumberOfDice3.setBackgroundResource(R.drawable.small_btn_background)

            btnNumberOfDice2.setTextColor(resources.getColor(android.R.color.black))
            btnNumberOfDice1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnNumberOfDice4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnNumberOfDice3.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnNumberOfDice3.setOnClickListener {
            numberOfDice = 3
            btnNumberOfDice3.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnNumberOfDice1.setBackgroundResource(R.drawable.small_btn_background)
            btnNumberOfDice2.setBackgroundResource(R.drawable.small_btn_background)
            btnNumberOfDice4.setBackgroundResource(R.drawable.small_btn_background)

            btnNumberOfDice3.setTextColor(resources.getColor(android.R.color.black))
            btnNumberOfDice1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnNumberOfDice2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnNumberOfDice4.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnNumberOfDice4.setOnClickListener {
            numberOfDice = 4
            btnNumberOfDice4.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnNumberOfDice1.setBackgroundResource(R.drawable.small_btn_background)
            btnNumberOfDice2.setBackgroundResource(R.drawable.small_btn_background)
            btnNumberOfDice3.setBackgroundResource(R.drawable.small_btn_background)

            btnNumberOfDice4.setTextColor(resources.getColor(android.R.color.black))
            btnNumberOfDice1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnNumberOfDice2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnNumberOfDice3.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnSides4.setOnClickListener {
            numberOfSides = 4

            btnSides4.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnSides6.setBackgroundResource(R.drawable.small_btn_background)
            btnSides8.setBackgroundResource(R.drawable.small_btn_background)
            btnSides10.setBackgroundResource(R.drawable.small_btn_background)
            btnSides12.setBackgroundResource(R.drawable.small_btn_background)
            btnSides16.setBackgroundResource(R.drawable.small_btn_background)

            btnSides4.setTextColor(resources.getColor(android.R.color.black))
            btnSides6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides12.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides16.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnSides8.setOnClickListener {
            numberOfSides = 8

            btnSides8.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnSides6.setBackgroundResource(R.drawable.small_btn_background)
            btnSides4.setBackgroundResource(R.drawable.small_btn_background)
            btnSides10.setBackgroundResource(R.drawable.small_btn_background)
            btnSides12.setBackgroundResource(R.drawable.small_btn_background)
            btnSides16.setBackgroundResource(R.drawable.small_btn_background)

            btnSides8.setTextColor(resources.getColor(android.R.color.black))
            btnSides6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides12.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides16.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnSides12.setOnClickListener {
            numberOfSides = 12

            btnSides12.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnSides6.setBackgroundResource(R.drawable.small_btn_background)
            btnSides8.setBackgroundResource(R.drawable.small_btn_background)
            btnSides10.setBackgroundResource(R.drawable.small_btn_background)
            btnSides4.setBackgroundResource(R.drawable.small_btn_background)
            btnSides16.setBackgroundResource(R.drawable.small_btn_background)

            btnSides12.setTextColor(resources.getColor(android.R.color.black))
            btnSides6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides16.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnSides16.setOnClickListener {
            numberOfSides = 16

            btnSides16.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnSides6.setBackgroundResource(R.drawable.small_btn_background)
            btnSides8.setBackgroundResource(R.drawable.small_btn_background)
            btnSides10.setBackgroundResource(R.drawable.small_btn_background)
            btnSides12.setBackgroundResource(R.drawable.small_btn_background)
            btnSides4.setBackgroundResource(R.drawable.small_btn_background)

            btnSides16.setTextColor(resources.getColor(android.R.color.black))
            btnSides6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides12.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides4.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnSides6.setOnClickListener {
            numberOfSides = 6

            btnSides6.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnSides4.setBackgroundResource(R.drawable.small_btn_background)
            btnSides8.setBackgroundResource(R.drawable.small_btn_background)
            btnSides10.setBackgroundResource(R.drawable.small_btn_background)
            btnSides12.setBackgroundResource(R.drawable.small_btn_background)
            btnSides16.setBackgroundResource(R.drawable.small_btn_background)

            btnSides6.setTextColor(resources.getColor(android.R.color.black))
            btnSides4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides12.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides16.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnSides10.setOnClickListener {
            numberOfSides = 10

            btnSides10.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnSides6.setBackgroundResource(R.drawable.small_btn_background)
            btnSides8.setBackgroundResource(R.drawable.small_btn_background)
            btnSides4.setBackgroundResource(R.drawable.small_btn_background)
            btnSides12.setBackgroundResource(R.drawable.small_btn_background)
            btnSides16.setBackgroundResource(R.drawable.small_btn_background)

            btnSides10.setTextColor(resources.getColor(android.R.color.black))
            btnSides6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides12.setTextColor(resources.getColor(R.color.colorPrimary))
            btnSides16.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnRoll.setOnClickListener {
            for (i in 1..numberOfDice) {
                val num = reusableMethods.rand(1, numberOfSides)

                sum += num
                rolls.add(num.toString())
            }

            val filtered = "[]"
            val displayResults = rolls.toString().filterNot { filtered.indexOf(it) > -1 }

            txtRolls.text = ("Roll(s): $displayResults")
            txtSumOfDie.text = ("Sum: $sum")
            rolls.clear()
            sum = 0
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)

        super.onCreate(savedInstanceState)
    }

    private fun setUpToolBar () {
        val actionBar = (activity as AppCompatActivity).supportActionBar

        actionBar!!.title = "Dice Roller"
    }

    private fun setBackgroundColor () {

    }
}