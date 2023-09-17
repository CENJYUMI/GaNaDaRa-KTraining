package com.data.finalproject.CombiRules

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.data.finalproject.R
import com.data.finalproject.databinding.FragmentCombiRulesBinding
import com.data.finalproject.databinding.FragmentWithoutBadchimBinding


class WithoutBadchimFragment : Fragment() {

    private lateinit var binding: FragmentWithoutBadchimBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWithoutBadchimBinding.inflate(inflater, container, false)
        val view = binding.root




        return view
    }


}