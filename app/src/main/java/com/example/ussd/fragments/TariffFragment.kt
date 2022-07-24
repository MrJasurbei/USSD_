package com.example.ussd.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ussd.R
import com.example.ussd.adapter.ExAdapter2
import com.example.ussd.adapter.ExpandableAdapter
import com.example.ussd.databinding.FragmentTariffBinding


class TariffFragment(val listOfTitles: List<String>, val listOfData: List<String>,val textButton: String,
                     val textToolbar: String) : Fragment() {
    private var _binding:FragmentTariffBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTariffBinding.inflate(inflater, container, false)

        val requestCode = arguments?.getInt("requestCode")
        if (requestCode==1){
            binding.expandableListView1.visibility = View.VISIBLE
            binding.checkTraffic.visibility = View.VISIBLE
            val expandableAdapter = ExAdapter2(requireContext(), listOfTitles)
           binding.expandableListView1.setAdapter(expandableAdapter)

        }else if (requestCode == 0){
            binding.expandableListView1.visibility = View.VISIBLE
            binding.topLayout.visibility = View.VISIBLE
            val expandableAdapter = ExpandableAdapter(requireContext(), listOfTitles, listOfData)
            binding.expandableListView1.setAdapter(expandableAdapter)
        }
        else if(requestCode == 2){
            binding.expandableListView2.visibility = View.VISIBLE
            val expandableAdapter = ExAdapter2(requireContext(), listOfTitles)
            binding.expandableListView2.setAdapter(expandableAdapter)
        }
        else{
            binding.expandableListView2.visibility = View.VISIBLE
            val expandableAdapter = ExpandableAdapter(requireContext(), listOfTitles, listOfData)
            binding.expandableListView2.setAdapter(expandableAdapter)
        }


        binding.backArrow.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container_view, HomeFragment()).commit()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.checkTariff.text = textButton
        binding.toolbarTraffics.title = textToolbar
        binding.checkTariff.text = textButton
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}