package com.example.numbergenerator

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class DiceFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.dice_fragment, container, false)

        val reusableMethods = ReusableMethods()

        val txtNumberOfDice = view.findViewById<TextView>(R.id.txtNumberOfDice)
        val txtNumberOfEachDie = view.findViewById<TextView>(R.id.txtNumberOfEachDie)
        val txtRolls = view.findViewById<TextView>(R.id.txtRolls)
        val txtSumOfDie = view.findViewById<TextView>(R.id.txtSumOfDie)
        val btnRoll = view.findViewById<Button>(R.id.btnRoll)
        val btnNumberOfDice1 = view.findViewById<Button>(R.id.btnNumberOfDice1)
        val btnNumberOfDice2 = view.findViewById<Button>(R.id.btnNumberOfDice2)
        val btnNumberOfDice3 = view.findViewById<Button>(R.id.btnNumberOfDice3)
        val btnNumberOfDice4 = view.findViewById<Button>(R.id.btnNumberOfDice4)
        val btnSides4 = view.findViewById<Button>(R.id.btnSides4)
        val btnSides8 = view.findViewById<Button>(R.id.btnSides8)
        val btnSides12 = view.findViewById<Button>(R.id.btnSides12)
        val btnSides16 = view.findViewById<Button>(R.id.btnSides16)

        var numberOfDice = 0
        var numberOfSides = 0
        var sum = 0

        val rolls: MutableList<String> = ArrayList()

        btnNumberOfDice1.setOnClickListener {
            numberOfDice = 1
            txtNumberOfDice.text = numberOfDice.toString()
        }

        btnNumberOfDice2.setOnClickListener {
            numberOfDice = 2
            txtNumberOfDice.text = numberOfDice.toString()
        }

        btnNumberOfDice3.setOnClickListener {
            numberOfDice = 3
            txtNumberOfDice.text = numberOfDice.toString()
        }

        btnNumberOfDice4.setOnClickListener {
            numberOfDice = 4
            txtNumberOfDice.text = numberOfDice.toString()
        }

        btnSides4.setOnClickListener {
            numberOfSides = 4
            txtNumberOfEachDie.text = numberOfSides.toString()
        }

        btnSides8.setOnClickListener {
            numberOfSides = 8
            txtNumberOfEachDie.text = numberOfSides.toString()
        }

        btnSides12.setOnClickListener {
            numberOfSides = 12
            txtNumberOfEachDie.text = numberOfSides.toString()
        }

        btnSides16.setOnClickListener {
            numberOfSides = 16
            txtNumberOfEachDie.text = numberOfSides.toString()
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
}