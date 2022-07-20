package com.example.ussd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.ussd.databinding.FragmentTariffBinding


class TariffFragment(val list: List<String>, val textButton: String, val textToolbar: String) : Fragment() {
    private var _binding:FragmentTariffBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTariffBinding.inflate(inflater, container, false)

        val requestCode = arguments?.getInt("requestCode")
        if (requestCode==1){
            binding.checkTraffic.visibility = View.VISIBLE
            val expandableAdapter = ExAdapter2(requireContext(), list)
           binding.expandableListView.setAdapter(expandableAdapter)

        }else{
            binding.topLayout.visibility = View.VISIBLE
            val expandableAdapter = ExpandableAdapter(requireContext(), list)
            binding.expandableListView.setAdapter(expandableAdapter)
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