package com.data.finalproject.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.data.finalproject.quiz.dateTime.DateTimeFragment
import com.data.finalproject.quiz.hangeulQuiz.Hangeul1Fragment
import com.data.finalproject.quiz.numbersUnitQuiz.NumbersUnitsFragment
import com.data.finalproject.R
import com.data.finalproject.databinding.FragmentQuizBinding
import com.data.finalproject.quiz.Direction.DirectionQuizFragment


class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        val view = binding.root



        binding.hangeul.setOnClickListener {
            val hangulFragment = Hangeul1Fragment()
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, hangulFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.numUnit.setOnClickListener {
            val numUnitFragment = NumbersUnitsFragment()
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container,numUnitFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.dateTime.setOnClickListener {
            val dateTimeFragment = DateTimeFragment()
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container,dateTimeFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.locDirection.setOnClickListener {
            val locDirectionFragment = DirectionQuizFragment()
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container,locDirectionFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }



        return view
    }


}