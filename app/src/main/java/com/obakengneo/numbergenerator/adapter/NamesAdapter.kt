package com.obakengneo.numbergenerator.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.model.Model
import com.obakengneo.numbergenerator.util.Utility

class NamesAdapter(var mCtx: Context, var resources: Int, var items: List<Model>) :
    ArrayAdapter<Model>(mCtx, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view = layoutInflater.inflate(resources, null)
        val name: TextView = view.findViewById(R.id.txtName)
        val index: TextView = view.findViewById(R.id.txtIndex)
        val imgDelete: ImageView = view.findViewById(R.id.imgDelete)
        val mItem: Model = items[position]

        name.text = mItem.nameOfPerson
        index.text = mItem.index

        imgDelete.setOnClickListener {
            val names = Utility().getArrayList("TempNames", mItem.activity)

            names.removeAt(position)
            Utility().saveArrayList(names, "TempNames", mItem.activity)

            remove(getItem(position))
            notifyDataSetChanged()
        }

        return view
    }
}