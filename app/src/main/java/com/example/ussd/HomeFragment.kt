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

        adapter = GridAdapter(requireContext(), Helper.titles, Helper.icons)
        binding.gridContainer.adapter = adapter
        binding.gridContainer.adapter = adapter
        setHasOptionsMenu(true)
        
        binding.gridContainer.setOnItemClickListener { adapterView, view, i, l ->

            when(i){
                1->{
                    transferData(TariffFragment(Helper.tariffs, Helper.textButton[3], Helper.textToolbar[3]), 1)
                }
                4->{
                    transferData(TariffFragment(Helper.traffics, Helper.textButton[0], Helper.textToolbar[0]), 0)
                    //parentFragmentManager.beginTransaction()
                    //.replace(R.id.fragment_container_view, TariffFragment(Helper.traffics, Helper.textButton[0], Helper.textToolbar[0])).commit()

                }
                5->{
                    transferData(TariffFragment(Helper.traffics, Helper.textButton[1], Helper.textToolbar[1]), 0)
//                    parentFragmentManager.beginTransaction()
//                       .replace(R.id.fragment_container_view, TariffFragment(Helper.sms, Helper.textButton[1], Helper.textToolbar[1])).commit()
//
                }
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
    private fun transferData(fragment: Fragment, key: Int){
        val bundle = Bundle()
        bundle.putInt("requestCode", key)
        fragment.arguments = bundle
        parentFragmentManager.beginTransaction().replace(R.id.fragment_container_view, fragment).commit()
    }

}
