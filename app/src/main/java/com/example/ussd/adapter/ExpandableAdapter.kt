package com.example.ussd.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.Button
import android.widget.TextView
import com.example.ussd.R

class ExpandableAdapter(val context: Context, val titles:List<String>, val data: List<String>): BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return titles.size
    }

    override fun getChildrenCount(p0: Int): Int {
      return 1
    }

    override fun getGroup(p0: Int): String {
        return titles[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any? {
        return null
    }

    override fun getGroupId(parentId: Int): Long {
        return parentId.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
      var convertView = p2
        if (convertView == null){
           val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.title_expand_layout, null)
        }
        val textTitle = convertView!!.findViewById<TextView>(R.id.text_title)
        val circleText = convertView!!.findViewById<TextView>(R.id.circle_text)
        textTitle.text = getGroup(p0)

        circleText.text = data[p0]
        return convertView
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
       var convertView = p3
        if (convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.child_expand_title, null)
        }
        val submitButton = convertView!!.findViewById<Button>(R.id.child_button)

      return convertView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
       return true
    }
}