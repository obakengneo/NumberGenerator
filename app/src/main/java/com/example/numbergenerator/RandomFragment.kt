package com.example.numbergenerator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.bottom_menu.view.*

class RandomFragment : Fragment() {
    private val reusableMethods = ReusableMethods()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.random_fragment, container, false)
        setUpToolBar()

        val dropDown = view.findViewById<ImageButton>(R.id.btnOptions)
        val txtDraw = view.findViewById<TextView>(R.id.txtDraw)
        val btnEnter = view.findViewById<FloatingActionButton>(R.id.btnEnter)

        var lengthOfNumbers = 6
        var maximumNumber = 52

        dropDown.setOnClickListener {
            val bottomSheetDialogView: View = layoutInflater.inflate(R.layout.bottom_menu, null)
            val bottomSheetDialog = BottomSheetDialog(this.requireContext())

            bottomSheetDialog.setContentView(bottomSheetDialogView)
            bottomSheetDialog.show()

            bottomSheetDialogView.lotto.setOnClickListener {
                txtDraw.text = getString(R.string.lotto_heading)
                lengthOfNumbers = 6
                maximumNumber = 52
                bottomSheetDialog.dismiss()
            }

            bottomSheetDialogView.dailyLotto.setOnClickListener {
                txtDraw.text = getString(R.string.daily_lotto_heading)
                lengthOfNumbers = 5
                maximumNumber = 36
                bottomSheetDialog.dismiss()
            }

            bottomSheetDialogView.powerball.setOnClickListener {
                txtDraw.text = getString(R.string.powerball_heading)
                lengthOfNumbers = 6
                maximumNumber = 50
                bottomSheetDialog.dismiss()
            }
        }

        btnEnter.setOnClickListener {
            populateNumbers(view, lengthOfNumbers, maximumNumber)
        }

        return view
    }

    private fun populateNumbers (view:View, lengthOfNumbers:Int, maximumNumber: Int) {
        val scrollView = view.findViewById<ScrollView>(R.id.scrollNumbers)
        scrollView.visibility = View.VISIBLE

        val btnFirstNumberRowOne = view.findViewById<Button>(R.id.btnFirstNumberRowOne)
        val btnFirstNumberRowTwo = view.findViewById<Button>(R.id.btnFirstNumberRowTwo)
        val btnFirstNumberRowThree = view.findViewById<Button>(R.id.btnFirstNumberRowThree)
        val btnFirstNumberRowFour = view.findViewById<Button>(R.id.btnFirstNumberRowFour)

        val btnSecondNumberRowOne = view.findViewById<Button>(R.id.btnSecondNumberRowOne)
        val btnSecondNumberRowTwo = view.findViewById<Button>(R.id.btnSecondNumberRowTwo)
        val btnSecondNumberRowThree = view.findViewById<Button>(R.id.btnSecondNumberRowThree)
        val btnSecondNumberRowFour = view.findViewById<Button>(R.id.btnSecondNumberRowFour)

        val btnThirdNumberRowOne = view.findViewById<Button>(R.id.btnThirdNumberRowOne)
        val btnThirdNumberRowTwo = view.findViewById<Button>(R.id.btnThirdNumberRowTwo)
        val btnThirdNumberRowThree = view.findViewById<Button>(R.id.btnThirdNumberRowThree)
        val btnThirdNumberRowFour = view.findViewById<Button>(R.id.btnThirdNumberRowFour)

        val btnFourthNumberRowOne = view.findViewById<Button>(R.id.btnFourthNumberRowOne)
        val btnFourthNumberRowTwo = view.findViewById<Button>(R.id.btnFourthNumberRowTwo)
        val btnFourthNumberRowThree = view.findViewById<Button>(R.id.btnFourthNumberRowThree)
        val btnFourthNumberRowFour = view.findViewById<Button>(R.id.btnFourthNumberRowFour)

        val btnFifthNumberRowOne = view.findViewById<Button>(R.id.btnFifthNumberRowOne)
        val btnFifthNumberRowTwo = view.findViewById<Button>(R.id.btnFifthNumberRowTwo)
        val btnFifthNumberRowThree = view.findViewById<Button>(R.id.btnFifthNumberRowThree)
        val btnFifthNumberRowFour = view.findViewById<Button>(R.id.btnFifthNumberRowFive)

        val btnBonus1 = view.findViewById<Button>(R.id.btnBonus1)
        val btnBonus2 = view.findViewById<Button>(R.id.btnBonus2)
        val btnBonus3 = view.findViewById<Button>(R.id.btnBonus3)
        val btnBonus4 = view.findViewById<Button>(R.id.btnBonus4)

        when (lengthOfNumbers) {
            5 -> {
                btnBonus1.visibility = View.GONE
                btnBonus2.visibility = View.GONE
                btnBonus3.visibility = View.GONE
                btnBonus4.visibility = View.GONE
            }
            else -> {
                btnBonus1.visibility = View.VISIBLE
                btnBonus2.visibility = View.VISIBLE
                btnBonus3.visibility = View.VISIBLE
                btnBonus4.visibility = View.VISIBLE
            }
        }

        var list = getListOfRandomNumbers(lengthOfNumbers, maximumNumber)

        btnFirstNumberRowOne.text = list[0].toString()
        btnSecondNumberRowOne.text = list[1].toString()
        btnThirdNumberRowOne.text = list[2].toString()
        btnFourthNumberRowOne.text = list[3].toString()
        btnFifthNumberRowOne.text = list[4].toString()
        btnBonus1.text = getBonusNumber(maximumNumber, list).toString()

        list = getListOfRandomNumbers(lengthOfNumbers, maximumNumber)
        btnFirstNumberRowTwo.text = list[0].toString()
        btnSecondNumberRowTwo.text = list[1].toString()
        btnThirdNumberRowTwo.text = list[2].toString()
        btnFourthNumberRowTwo.text = list[3].toString()
        btnFifthNumberRowTwo.text = list[4].toString()
        btnBonus2.text = getBonusNumber(maximumNumber, list).toString()

        list = getListOfRandomNumbers(lengthOfNumbers, maximumNumber)
        btnFirstNumberRowThree.text = list[0].toString()
        btnSecondNumberRowThree.text = list[1].toString()
        btnThirdNumberRowThree.text = list[2].toString()
        btnFourthNumberRowThree.text = list[3].toString()
        btnFifthNumberRowThree.text = list[4].toString()
        btnBonus3.text = getBonusNumber(maximumNumber, list).toString()


        list = getListOfRandomNumbers(lengthOfNumbers, maximumNumber)
        btnFirstNumberRowFour.text = list[0].toString()
        btnSecondNumberRowFour.text = list[1].toString()
        btnThirdNumberRowFour.text = list[2].toString()
        btnFourthNumberRowFour.text = list[3].toString()
        btnFifthNumberRowFour.text = list[4].toString()
        btnBonus4.text = getBonusNumber(maximumNumber, list).toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)

        super.onCreate(savedInstanceState)
    }

    private fun setUpToolBar () {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar!!.title = "Lotto Simulator"
    }

    private fun getListOfRandomNumbers (count:Int, maximumNumber:Int):MutableList<Int> {
        val list: MutableList<Int> = ArrayList()

        for (i in 1..count) {
            val num = reusableMethods.rand(1, maximumNumber)
            list.add(num)
        }

        return list
    }

    private fun getBonusNumber(maximumNumber: Int, list: MutableList<Int>):Int {
        return if (maximumNumber == 50) {
            reusableMethods.rand(1, 20)
        } else {
            try {
                list[5]
            } catch (e:Exception) {
                0
            }
        }
    }
}