package com.example.numbergenerator.presentation

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.numbergenerator.R
import com.example.numbergenerator.util.Utility
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DiceFragment : Fragment() {

    private lateinit var txtRolls: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.dice_fragment, container, false)
        val btnRoll = view.findViewById<FloatingActionButton>(R.id.btnRoll)
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
        txtRolls = view.findViewById<TextView>(R.id.txtRolls)
        var numberOfDice = 0
        var numberOfSides = 0

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
            generateResults(view, numberOfDice, numberOfSides)
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    private fun generateResults(view: View, numberOfDice: Int, numberOfSides: Int) {
        val txtSumOfDie = view.findViewById<TextView>(R.id.txtSumOfDie)
        val txtRollsResults = view.findViewById<TextView>(R.id.txtRolls1)
        val txtSumOfDieResults = view.findViewById<TextView>(R.id.txtSumOfDie1)
        val rolls: MutableList<String> = ArrayList()
        var sum = 0

        for (i in 1..numberOfDice) {
            if (numberOfSides > 3) {
                val num = Utility().rand(1, numberOfSides)

                sum += num
                rolls.add(num.toString())
            }
        }

        if (numberOfSides != 0 && numberOfDice != 0) {
            val filtered = "[]"
            var displayResults = rolls.toString().filterNot { filtered.indexOf(it) > -1 }

            if (displayResults == "") {
                displayResults = "0"
            }

            txtRollsResults.text = ("Roll(s): ")
            txtSumOfDieResults.text = ("Sum: ")

            txtRolls.text = displayResults
            txtSumOfDie.text = "$sum"

            rolls.clear()
        } else {
            Utility().displayToast(
                this.requireContext(),
                "Please select number of dices and sides you need!"
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_copyto_clipboard, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.copy) {
            val myClipboard: ClipboardManager =
                activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val myClip = ClipData.newPlainText("text", txtRolls.text)
            myClipboard.setPrimaryClip(myClip)

            Utility().displayToast(this.requireContext(), "Results copied to clipboard!")
        }
        return super.onOptionsItemSelected(item)
    }
}