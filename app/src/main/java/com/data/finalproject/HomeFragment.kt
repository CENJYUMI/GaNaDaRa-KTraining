package com.data.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.data.finalproject.Basic.BasicMainFragment
import com.data.finalproject.Basic.VowelsFragment
import com.data.finalproject.databinding.FragmentBasicMainBinding
import com.data.finalproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.basicBtn.setOnClickListener {
            val basicMainFragment = BasicMainFragment()
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, basicMainFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }



        return view
    }


}