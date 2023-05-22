package com.example.calculatorapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculatorapplication.R
import com.example.calculatorapplication.databinding.FragmentScientificBinding

class ScientificFragment : Fragment() {

    private lateinit var binding : FragmentScientificBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentScientificBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnCancel.setOnClickListener {

            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ScientificFragment()
    }
}