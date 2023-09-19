package com.data.finalproject.basic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.data.finalproject.quiz.QuizFragment
import com.data.finalproject.R
import com.data.finalproject.databinding.FragmentBasicMainBinding


class BasicMainFragment : Fragment() {

    private lateinit var binding: FragmentBasicMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBasicMainBinding.inflate(inflater, container, false)
        val view = binding.root

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

        binding.UnitsBtn.setOnClickListener {
            val unitsFragment = UnitsFragment()
            val fragmentTransaction4 = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction4.replace(R.id.fragment_container, unitsFragment)
            fragmentTransaction4.addToBackStack(null)
            fragmentTransaction4.commit()
        }

        binding.dateBtn.setOnClickListener {
            val dateFragment = DateFragment()
            val fragmentTransaction5 = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction5.replace(R.id.fragment_container, dateFragment)
            fragmentTransaction5.addToBackStack(null)
            fragmentTransaction5.commit()
        }

        binding.timeBtn.setOnClickListener {
            val timeFragment = TimeFragment()
            val fragmentTransaction6 = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction6.replace(R.id.fragment_container, timeFragment)
            fragmentTransaction6.addToBackStack(null)
            fragmentTransaction6.commit()
        }

        binding.locBtn.setOnClickListener {
            val directionFragment = DirectionFragment()
            val fragmentTransaction7 = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction7.replace(R.id.fragment_container, directionFragment)
            fragmentTransaction7.addToBackStack(null)
            fragmentTransaction7.commit()
        }

        binding.RulesBtn.setOnClickListener {
            val rulesFragment = CombiRulesFragment()
            val fragmentTransaction8 = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction8.replace(R.id.fragment_container, rulesFragment)
            fragmentTransaction8.addToBackStack(null)
            fragmentTransaction8.commit()
        }

        binding.quizBtn.setOnClickListener {
            val quizFragment = QuizFragment()
            val fragmentTransaction9 = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction9.replace(R.id.fragment_container, quizFragment)
            fragmentTransaction9.addToBackStack(null)
            fragmentTransaction9.commit()
        }

        return view
    }
}
