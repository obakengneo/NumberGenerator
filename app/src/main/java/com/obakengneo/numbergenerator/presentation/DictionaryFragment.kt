package com.obakengneo.numbergenerator.presentation

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.util.Utility
import kotlinx.android.synthetic.main.dictionary_fragment.view.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets


class DictionaryFragment : Fragment() {

    private lateinit var txtWord: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.dictionary_fragment, container, false)
        txtWord = view.findViewById<TextView>(R.id.txtWord)

        var word = getWord(view)
        view.btnGetWord.setOnClickListener {
            word = getWord(view)
        }

        view.txtLink.setOnClickListener {
            val url = "https://dictionary.cambridge.org/dictionary/english/$word"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        return view
    }

    private fun capitaliseFirstLetter(s: String?): String {
        return if (s != null && s.isNotEmpty()) {
            s.substring(0, 1).toUpperCase() + s.substring(1)
        } else ""
    }

    private fun getWord(view: View): String {
        var word = ""

        try {
            val sb: ArrayList<String> = ArrayList()
            val st: InputStream = this.requireActivity().assets.open("dictionary.txt")
            val br = BufferedReader(InputStreamReader(st, StandardCharsets.UTF_8))
            var str: String?

            while (br.readLine().also { str = it } != null) {
                sb.add(str!!)
            }

            br.close()

            word = capitaliseFirstLetter(sb[Utility().rand(1, sb.size) - 1])
            txtWord.text = word

        } catch (ex: IOException) {
            ex.printStackTrace()
        }

        return word
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
            val myClip = ClipData.newPlainText("text", txtWord.text)

            myClipboard.setPrimaryClip(myClip)

            Utility().displayToast(this.requireContext(), "Word copied to clipboard!")
        }
        return super.onOptionsItemSelected(item)
    }
}