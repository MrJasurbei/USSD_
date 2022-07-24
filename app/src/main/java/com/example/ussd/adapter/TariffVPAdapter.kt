package com.example.ussd.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.ussd.R
import com.example.ussd.TariffList
import kotlinx.android.synthetic.main.tariff_vp_item.view.*

class TariffVPAdapter(val context: Context, val dataList: MutableList<TariffList>):PagerAdapter() {

    private var listener: onPageClickListener? = null

    override fun getCount(): Int {
        return dataList.size
    }

    override fun isViewFromObject(view: View, image: Any): Boolean {
       return view == image
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.tariff_vp_item, container, false)
        val data = dataList[position]
        view.vp_tariff_name.text = data.tariffName
        view.vp_min.text = data.minutes
        view.vp_mb.text = data.internet
        view.vp_sms.text = data.sms
        view.vp_price.text = data.price
        view.setOnClickListener { listener?.onPageClicked(position) }
        container.addView(view, 0)
        return view
    }
    fun setOnPageClickListener(listener: onPageClickListener){
        this.listener = listener
    }
    interface onPageClickListener{
        fun onPageClicked(position: Int)
    }
}