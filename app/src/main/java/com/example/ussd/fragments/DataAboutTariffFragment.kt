package com.example.ussd.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ussd.R


class DataAboutTariffFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_data_about_tariff, container, false)
        val bannerTariffName = view.findViewById<TextView>(R.id.text_name_of_tariff)
        val bannerMinutesText = view.findViewById<TextView>(R.id.minutes_text)
        val bannerSmsText = view.findViewById<TextView>(R.id.sms_text)
        val bannerMbText = view.findViewById<TextView>(R.id.internetMb_text)
        val priceOfTariff = view.findViewById<TextView>(R.id.tariff_price)
        val belowTariffName = view.findViewById<TextView>(R.id.tariff_name)
        val belowTariffPayment = view.findViewById<TextView>(R.id.tariff_payment)


        val tariffName = arguments?.getString("tname")
        val min = arguments?.getString("min")
        val sms = arguments?.getString("sms")
        val mb = arguments?.getString("mb")
        val price = arguments?.getString("price")

        bannerTariffName.text = tariffName.toString()
        bannerMinutesText.text = min.toString()
        bannerSmsText.text = sms.toString()
        bannerMbText.text = mb.toString()
        priceOfTariff.text = price.toString()
        belowTariffName.text = tariffName.toString()
        belowTariffPayment.text = price.toString()
        return view
    }
}