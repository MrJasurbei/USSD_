package com.example.ussd

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GridAdapter(val context: Context, val titles: Array<String>, val icons: Array<Int>) :
    BaseAdapter() {

    override fun getCount(): Int {
        return icons.size
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val row = layoutInflater.inflate(R.layout.grid_item, null)
        val textTitle = row.findViewById<TextView>(R.id.grid_icon_name)
        val gridIcon = row.findViewById<ImageView>(R.id.grid_image)
        textTitle.text = titles[p0]
        gridIcon.setImageResource(icons[p0])
        return row
    }
}