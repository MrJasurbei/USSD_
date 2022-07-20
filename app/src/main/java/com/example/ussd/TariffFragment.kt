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

        val expandableAdapter = ExpandableAdapter(requireContext(), list)
         binding.expandableListView.setAdapter(expandableAdapter)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.checkTariff.text = textButton
        binding.toolbarTraffics.title = textToolbar
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}