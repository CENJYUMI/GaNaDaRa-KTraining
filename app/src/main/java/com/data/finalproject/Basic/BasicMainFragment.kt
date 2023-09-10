package com.data.finalproject.Basic

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.data.finalproject.NaviMainActivity
import com.data.finalproject.R
import com.data.finalproject.databinding.FragmentBasicMainBinding
import com.data.finalproject.databinding.FragmentVowelsBinding


class BasicMainFragment : Fragment() {

    private lateinit var binding: FragmentBasicMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBasicMainBinding.inflate(inflater, container, false)
        val view = binding.root

        //fragments
        val naviHome = NaviMainActivity()
        val vowels = VowelsFragment()
        val consonants = ConsonantsFragment()


        binding.vowelsBtn.setOnClickListener {
            val vowelsFragment = VowelsFragment()
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, vowelsFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.consonantsBtn.setOnClickListener {
            val consonantsFragment = ConsonantsFragment()
            val fragmentTransaction2 = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction2.replace(R.id.fragment_container, consonantsFragment)
            fragmentTransaction2.addToBackStack(null)
            fragmentTransaction2.commit()
        }

        binding.NumbersBtn.setOnClickListener {
            val numberFragment = NumberFragment()
            val fragmentTransaction3 = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction3.replace(R.id.fragment_container, numberFragment)
            fragmentTransaction3.addToBackStack(null)
            fragmentTransaction3.commit()
        }


        return view
    }
}
