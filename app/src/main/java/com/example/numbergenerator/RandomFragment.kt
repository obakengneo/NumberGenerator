package com.example.numbergenerator

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.lang.Exception

class RandomFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.random_fragment, container, false)

        setUpToolBar()

        val reusableMethods = ReusableMethods()

        val edtFrom = view.findViewById<EditText>(R.id.edtFrom)
        val edtTo = view.findViewById<EditText>(R.id.edtTo)
        val number = view.findViewById<EditText>(R.id.number)
        val btnGetRange = view.findViewById<Button>(R.id.btnEnter)
        val result = view.findViewById<TextView>(R.id.txtValue)

        btnGetRange.setOnClickListener{
            try {
                val firstValue: Int = edtFrom.text.toString().toInt()
                val secondValue: Int = edtTo.text.toString().toInt()
                val count: Int = number.text.toString().toInt()
                val list: MutableList<Int> = ArrayList()
                var num = 0

                if (secondValue > firstValue) {
                    var value = ""
                    for (i in 1..count) {
                        if (secondValue - firstValue > count) {
                            if (i == 1) {
                                do {
                                    num = reusableMethods.rand(firstValue, secondValue)
                                } while (!reusableMethods.duplicate(list, num))

                                value += num.toString()
                                list.add(num)
                            } else {
                                do {
                                    num = reusableMethods.rand(firstValue, secondValue)
                                } while (!reusableMethods.duplicate(list, num))

                                list.add(num)
                                value += ", $num"
                            }

                            val valueToBeDisplayed = "Number(s): $value"
                            result.text = valueToBeDisplayed
                        } else {
                            Toast.makeText(this.requireContext(),"Please make sure the amount of numbers you need are within the range of $firstValue and $secondValue!", Toast.LENGTH_LONG).show()
                            break
                        }
                    }

                } else {
                    Toast.makeText(this.requireContext(),"The Minimum range number cannot be greater than the Maximum range number!", Toast.LENGTH_LONG).show()
                }

            } catch (e: Exception) {
                Toast.makeText(this.requireContext(),"Please fill in a valid number in all the fields!", Toast.LENGTH_LONG).show()
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

        actionBar!!.title = "RNG"
    }
}