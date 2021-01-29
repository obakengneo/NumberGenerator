package com.obakengneo.numbergenerator.presentation

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.util.Utility
import kotlinx.android.synthetic.main.countries_fragment.view.*
import kotlinx.android.synthetic.main.dictionary_fragment.view.btnGetWord
import kotlinx.android.synthetic.main.dictionary_fragment.view.txtLink
import java.io.IOException


class CountryFragment : Fragment() {
    private lateinit var txtCountry: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.countries_fragment, container, false)
        txtCountry = view.findViewById<TextView>(R.id.txtCountry)

        var country = getCountry(view)

        view.btnGetWord.setOnClickListener {
            country = getCountry(view)
        }

        view.txtLink.setOnClickListener {
            val url = "https://en.wikipedia.org/wiki/$country"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        return view
    }

    private fun getImage(c: Context, ImageName: String?): Drawable? {
        Log.d("TAG", ImageName!!)
        return c.resources.getDrawable(
            c.resources.getIdentifier(
                ImageName,
                "drawable",
                c.packageName
            )
        )
    }

    private fun getCountry(view: View): String {
        var country = ""
        try {
            val sb = this.resources.getStringArray(R.array.countries_array)

            country = sb[Utility().rand(1, sb.size - 1)]
            txtCountry.text = country

            val flag = country.toLowerCase().replace(" ", "_")
            view.imgFlags.setImageDrawable(getImage(this.requireContext(), flag.replace("-", "_")))

        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return country
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
            val myClip = ClipData.newPlainText("text", txtCountry.text)

            myClipboard.setPrimaryClip(myClip)

            Utility().displayToast(this.requireContext(), "Country copied to clipboard!")
        }
        return super.onOptionsItemSelected(item)
    }
}