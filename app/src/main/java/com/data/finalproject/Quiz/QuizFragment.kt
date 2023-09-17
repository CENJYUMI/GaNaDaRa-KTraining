package com.data.finalproject.Quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.data.finalproject.Quiz.HangeulQuiz.Hangeul1Fragment
import com.data.finalproject.R
import com.data.finalproject.databinding.FragmentQuizBinding


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




        return view
    }


}