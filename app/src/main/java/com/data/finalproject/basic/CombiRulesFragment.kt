package com.data.finalproject.basic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.data.finalproject.combiRules.WithoutBadchimFragment
import com.data.finalproject.R
import com.data.finalproject.databinding.FragmentCombiRulesBinding

class CombiRulesFragment : Fragment() {

    private lateinit var binding: FragmentCombiRulesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCombiRulesBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.layoutWithout.setOnClickListener {
            val withoutBadchimFragment = WithoutBadchimFragment()
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, withoutBadchimFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.sampleBtn.setOnClickListener {
            val withoutBadchim2Fragment = WithoutBadchimFragment()
            val fragmentTransaction2 = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction2.replace(R.id.fragment_container, withoutBadchim2Fragment)
            fragmentTransaction2.addToBackStack(null)
            fragmentTransaction2.commit()
        }





        return view

    }



}