package com.obakengneo.numbergenerator.presentation

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.CheckBox
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.util.Utility


class RandomFragment : Fragment() {
    private lateinit var result: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.random_fragment, container, false)
        val seek = view.findViewById<SeekBar>(R.id.sBarNumberCount)
        val progressOnBar = view.findViewById<TextView>(R.id.txtNumbersCount)
        val btnGetRange = view.findViewById<FloatingActionButton>(R.id.btnEnter)
        result = view.findViewById<TextView>(R.id.txtValue)

        btnGetRange.setOnClickListener {
            generateNumbers(seek.progress, view)
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

    private fun generateNumbers(count: Int, view: View) {
        val edtFrom = view.findViewById<EditText>(R.id.edtFrom)
        val edtTo = view.findViewById<EditText>(R.id.edtTo)
        val allowDuplicates = view.findViewById<CheckBox>(R.id.chkAllowDuplicates)

        try {
            val firstValue: Int = edtFrom.text.toString().toInt()
            val secondValue: Int = edtTo.text.toString().toInt()
            val list: MutableList<Int> = ArrayList()
            var num: Int

            if (secondValue > firstValue) {
                for (i in 1..count) {
                    if (secondValue - firstValue >= count - 1 || allowDuplicates.isChecked) {
                        if (!allowDuplicates.isChecked) {
                            do {
                                num = Utility().rand(firstValue, secondValue)
                            } while (!Utility().duplicate(list, num))

                            list.add(num)
                        } else {
                            num = Utility().rand(firstValue, secondValue)
                            list.add(num)
                        }

                        result.text = Utility().getCommaSeparatedString(list)
                    } else {
                        Utility().displayToast(
                            this.requireContext(),
                            "Please make sure the amount of numbers you need are within the range of $firstValue and $secondValue!"
                        )
                        break
                    }
                }
            } else {
                Utility().displayToast(
                    this.requireContext(),
                    "The Minimum range number cannot be greater than the Maximum range number!"
                )
            }
        } catch (e: Exception) {
            Utility().displayToast(
                this.requireContext(), "Please fill in a valid number in all the fields!"
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
            val myClip = ClipData.newPlainText("text", "Numbers: " + result.text)
            myClipboard.setPrimaryClip(myClip)

            Utility().displayToast(this.requireContext(), "Results copied to clipboard!")
        }
        return super.onOptionsItemSelected(item)
    }
}