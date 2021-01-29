package com.obakengneo.numbergenerator.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.model.TeamsModel
import com.obakengneo.numbergenerator.util.Utility

class TeamsAdapter(var mCtx: Context, var resources: Int, var items: List<TeamsModel>) :
    ArrayAdapter<TeamsModel>(mCtx, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view = layoutInflater.inflate(resources, null)
        val names: TextView = view.findViewById(R.id.txtTeamNames)
        val index: TextView = view.findViewById(R.id.txtTeam)
        val imgCopy: ImageView = view.findViewById(R.id.imgCopy)
        val imgRefresh: ImageView = view.findViewById(R.id.imgRefresh)
        val mItem: TeamsModel = items[position]
        val team = "Team " + mItem.index
        var builder = stringBuilder(mItem)

        index.text = team
        names.text = builder.toString()

        imgCopy.setOnClickListener {
            val myClipboard: ClipboardManager =
                context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val myClip = ClipData.newPlainText("text", team + "\n\n" + names.text.toString())

            myClipboard.setPrimaryClip(myClip)
            Utility().displayToast(this.context, "$team copied to clipboard!")
        }

        imgRefresh.setOnClickListener {
            val list: MutableList<String> = ArrayList()

            for (details in mItem.teamList) {
                list.add(details)
            }

            list.shuffle()

            builder = stringBuilder(TeamsModel("", list))
            names.text = builder.toString()
        }

        return view
    }

    private fun stringBuilder(mItem: TeamsModel): java.lang.StringBuilder {
        val builder = StringBuilder()
        var count = 1

        for (details in mItem.teamList) {
            builder.append("$count. $details\n")
            count++
        }
        return builder
    }
}