package com.obakengneo.numbergenerator.presentation

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.util.Utility
import kotlinx.android.synthetic.main.color_fragment.view.*

class ColorFragment : Fragment() {

    private lateinit var txtColor: TextView
    private lateinit var txtHex: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.color_fragment, container, false)

        txtColor = view.findViewById<TextView>(R.id.txtColor)
        txtHex = view.findViewById<TextView>(R.id.txtHex)

        setColor(view)

        view.btnGetColor.setOnClickListener {
            setColor(view)
        }

        return view
    }

    private fun setColor(view: View) {
        val colorNames = resources.getStringArray(R.array.colorNames)
        val colorHex = resources.getStringArray(R.array.hexNames)

        val randomNumber = Utility().rand(1, colorNames.size - 1)
        val ta = resources.obtainTypedArray(R.array.colors)
        val colorToUse = ta.getResourceId(randomNumber, 0)

        view.imgColor.setImageResource(colorToUse)
        txtColor.text = colorNames[randomNumber]
        txtHex.text = colorHex[randomNumber]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_copyto_clipboard, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.copy) {
            val myClipboard: ClipboardManager =
                activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val myClip = ClipData.newPlainText(
                "text",
                "Color: " + txtColor.text + "\nHexaDecimal:" + txtHex.text
            )

            myClipboard.setPrimaryClip(myClip)

            Utility().displayToast(this.requireContext(), "Color copied to clipboard!")
        }
        return super.onOptionsItemSelected(item)
    }
}