package com.obakengneo.numbergenerator.presentation

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.util.Utility

class CoinFragment : Fragment() {
    private lateinit var txtSides: TextView

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
        val btnFlips7 = view.findViewById<Button>(R.id.btnFlips7)
        val btnFlips8 = view.findViewById<Button>(R.id.btnFlips8)
        val btnFlips9 = view.findViewById<Button>(R.id.btnFlips9)
        val btnFlips10 = view.findViewById<Button>(R.id.btnFlips10)
        val btnFlips11 = view.findViewById<Button>(R.id.btnFlips11)
        val btnFlips12 = view.findViewById<Button>(R.id.btnFlips12)
        val btnFlip = view.findViewById<FloatingActionButton>(R.id.btnFlip)
        txtSides = view.findViewById<TextView>(R.id.txtSides)

        var numberOfCoins: Int = 0

        val value = TypedValue()
        this.requireContext().theme.resolveAttribute(android.R.attr.colorPrimaryDark, value, true)

        btnFlips1.setOnClickListener {
            numberOfCoins = 1
            btnFlips1.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips10.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips7.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips8.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips9.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips11.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips12.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips1.setTextColor(value.data)
            btnFlips10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips7.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips9.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips11.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips12.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips2.setOnClickListener {
            numberOfCoins = 2
            btnFlips2.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips10.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips7.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips8.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips9.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips11.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips12.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips2.setTextColor(value.data)
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips7.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips9.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips11.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips12.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips3.setOnClickListener {
            numberOfCoins = 3
            btnFlips3.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips10.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips7.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips8.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips9.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips11.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips12.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips3.setTextColor(value.data)
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips7.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips9.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips11.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips12.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips4.setOnClickListener {
            numberOfCoins = 4
            btnFlips4.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips10.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips7.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips8.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips9.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips11.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips12.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips4.setTextColor(value.data)
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips7.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips9.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips11.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips12.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips5.setOnClickListener {
            numberOfCoins = 5
            btnFlips5.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips10.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips7.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips8.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips9.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips11.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips12.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips5.setTextColor(value.data)
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips7.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips9.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips11.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips12.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips6.setOnClickListener {
            numberOfCoins = 6
            btnFlips6.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips10.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips7.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips8.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips9.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips11.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips12.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips6.setTextColor(value.data)
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips7.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips9.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips11.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips12.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips7.setOnClickListener {
            numberOfCoins = 7
            btnFlips7.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips10.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips8.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips9.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips11.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips12.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips7.setTextColor(value.data)
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips9.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips11.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips12.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips8.setOnClickListener {
            numberOfCoins = 8
            btnFlips8.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips7.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips10.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips9.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips11.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips12.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips8.setTextColor(value.data)
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips7.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips9.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips11.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips12.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips9.setOnClickListener {
            numberOfCoins = 9
            btnFlips9.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips7.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips8.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips10.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips11.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips12.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips9.setTextColor(value.data)
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips7.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips11.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips12.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips10.setOnClickListener {
            numberOfCoins = 10
            btnFlips10.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips7.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips8.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips9.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips11.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips12.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips10.setTextColor(value.data)
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips7.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips9.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips11.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips12.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips11.setOnClickListener {
            numberOfCoins = 11
            btnFlips11.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips7.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips8.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips9.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips10.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips12.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips11.setTextColor(value.data)
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips7.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips9.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips12.setTextColor(resources.getColor(R.color.colorPrimary))
        }

        btnFlips12.setOnClickListener {
            numberOfCoins = 12
            btnFlips12.setBackgroundResource(R.drawable.small_btn_clicked_background)
            btnFlips1.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips3.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips4.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips2.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips5.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips6.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips7.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips8.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips9.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips10.setBackgroundResource(R.drawable.small_btn_background)
            btnFlips11.setBackgroundResource(R.drawable.small_btn_background)

            btnFlips12.setTextColor(value.data)
            btnFlips1.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips3.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips4.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips2.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips5.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips6.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips7.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips8.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips9.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips10.setTextColor(resources.getColor(R.color.colorPrimary))
            btnFlips11.setTextColor(resources.getColor(R.color.colorPrimary))
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
                    val result = Utility().rand(0, 1)

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
                Utility().displayToast(
                    this.requireContext(),
                    "Please select number of coins to flip!"
                )
            }
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
            val myClip = ClipData.newPlainText("text", "Sides: " + txtSides.text)

            myClipboard.setPrimaryClip(myClip)

            Utility().displayToast(this.requireContext(), "Results copied to clipboard!")
        }
        return super.onOptionsItemSelected(item)
    }
}