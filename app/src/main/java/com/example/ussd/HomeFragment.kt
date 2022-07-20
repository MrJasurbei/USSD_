package com.example.ussd

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridView
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.ussd.databinding.FragmentHomeBinding
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlinx.android.synthetic.main.fragment_data_about_tariff.*
import kotlinx.android.synthetic.main.fragment_tariff.*


class HomeFragment : Fragment(),TariffVPAdapter.onPageClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val traffics: List<String> = listOf("50", "100", "150", "500", "1GB", "2GB", "5GB", "10GB", "15GB ")
    val sms: List<String> = listOf("50", "100", "150", "200", "250", "300", "400", "500", "600")
    val titles = arrayOf("USSD", "Tarif", "Xizmat", "Minut", "Internet", "SMS")
    val icons = arrayOf(
        R.drawable.hash,
        R.drawable.credit_card,
        R.drawable.sliders,
        R.drawable.phone,
        R.drawable.earth,
        R.drawable.message
    )
    private var tariffPagerList:MutableList<TariffList> = ArrayList()
    lateinit var adapter: GridAdapter
    private lateinit var tariffVPAdapter: TariffVPAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataToVpList()
        tariffVPAdapter = TariffVPAdapter(requireContext(),tariffPagerList)
        binding.viewPager.adapter = tariffVPAdapter
        binding.viewPager.offscreenPageLimit = tariffPagerList.size
        tariffVPAdapter.setOnPageClickListener(this)
        binding.wormDotsIndicator.setViewPager(binding.viewPager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        adapter = GridAdapter(requireContext(), titles, icons)
        binding.gridContainer.adapter = adapter
        binding.gridContainer.adapter = adapter
        setHasOptionsMenu(true)
        
        binding.gridContainer.setOnItemClickListener { adapterView, view, i, l ->
            Log.d("@@@", "${i} $l")
            when(i){
                4->{parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, TariffFragment(traffics, "Trafik tekshirish", "Internet Paketlar")).commit()}
                5->{
                    Log.d("@@@", "Text  $l")

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view, TariffFragment(sms, "SMS ni tekshirish", "SMS paketlar")).commit()}
            }
        }

        return binding.root
    }
    private fun setDataToVpList(){
        tariffPagerList.clear()
        tariffPagerList.add(TariffList("Oddiy 10", "10 MIN", "10 SMS", "10 MB", "10 000 so'm"))
        tariffPagerList.add(TariffList("Street", "2250 MIN", "750 SMS", "6500 MB", "39 900 so'm"))
        tariffPagerList.add(TariffList("Bolajon", "200 MIN", "200 SMS", "2000 MB", "18 000 so'm"))
        tariffPagerList.add(TariffList("Royal", "1500 MIN", "1500 SMS", "14000 MB", "69 000 so'm"))
    }



    override fun onPageClicked(position: Int) {
     val bundle = Bundle()
        val dataAboutTariffFragment = DataAboutTariffFragment()
        bundle.putString("tname", tariffPagerList[position].tariffName)
        bundle.putString("min", tariffPagerList[position].minutes)
        bundle.putString("sms", tariffPagerList[position].sms)
        bundle.putString("mb", tariffPagerList[position].internet)
        bundle.putString("price", tariffPagerList[position].price)
        dataAboutTariffFragment.arguments = bundle
        parentFragmentManager.beginTransaction().replace(R.id.fragment_container_view, dataAboutTariffFragment).commit()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
