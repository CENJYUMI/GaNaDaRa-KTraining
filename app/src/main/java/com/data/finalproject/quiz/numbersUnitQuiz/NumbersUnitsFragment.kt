package com.data.finalproject.quiz.numbersUnitQuiz

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

import com.data.finalproject.quiz.QuizFragment
import com.data.finalproject.R

import com.data.finalproject.databinding.FragmentNumbersUnitsBinding


class NumbersUnitsFragment : Fragment() {

    private lateinit var binding: FragmentNumbersUnitsBinding
    private lateinit var alertDialog: AlertDialog

    private val quizQuestions = listOf(
        QuizQuestion2("배추가 얼마나 있습니까?", arrayOf("한 대 있습니다", "두 대 있습니다", "한 포기 있습니다", "두 포기 있습니다"), 3, R.drawable.cabbage),
        QuizQuestion2("면도기가 얼마나 있스니까?", arrayOf("여섯 개 있습니다", "여섯 자루 있습니다", "여덟 개 있습니다", "여덟 자루 있습니다"), 0, R.drawable.razor),
        QuizQuestion2("지마가 얼마나 있스니까?", arrayOf("여섯 벌 있습니다 ", "여덟 벌 있습니다", "여섯 송이 있습니다", "여덟 송이 있습니다"), 1, R.drawable.skirt),
        QuizQuestion2("휴지가 얼마나 있스니까?", arrayOf("한 개 있습니다 ", "두 개 있습니다", "한 대 있습니다", "두 대 있습니다"), 0, R.drawable.tissue),
        QuizQuestion2("연필이 얼마나 있스니까?", arrayOf("세 자루 있습니다 ", "네 자루 있습니다", "세 포대 있습니다", "네 포대 있습니다"), 1, R.drawable.pencil),
        QuizQuestion2("양말이 얼마나 있스니까?", arrayOf("아홉 장 있습니다 ", "열 장 있습니다", "아홉 켤레 있습니다", "열 켤레 있습니다"), 3, R.drawable.socks),
        QuizQuestion2("소가 얼마나 있스니까?", arrayOf("다섯 분 있습니다 ", "일곱 분 있습니다", "다섯 마리 있습니다", "일곱 마리 있습니다"), 2, R.drawable.cow),
        QuizQuestion2("생선이 얼마나 있스니까?", arrayOf("여덟 분 있습니다 ", "일곱 분 있습니다", "여덟 마리 있습니다", "일곱 마리 있습니다"), 2, R.drawable.fish),
        QuizQuestion2("콜라가 어마나 있습니까?", arrayOf("세 병 있습니다 ", "네 병 있습니다", "세 통 있습니다", "네 통 있습니다"), 0, R.drawable.coke),
        QuizQuestion2("차가 어마나 있습니까?", arrayOf("여덟 대 있습니다 ", "일곱 대 있습니다", "여덟 마리 있습니다", "일곱 마리 있습니다"), 1, R.drawable.car),

    ).shuffled()



    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNumbersUnitsBinding.inflate(inflater, container, false)
        val view = binding.root



        displayQuestion()


        binding.option1.setOnClickListener {
            checkAnswer(0)
        }
        binding.option2.setOnClickListener {
            checkAnswer(1)
        }
        binding.option3.setOnClickListener {
            checkAnswer(2)
        }
        binding.option4.setOnClickListener {
            checkAnswer(3)
        }

        return view
    }

    private fun correctButtonColors(buttonIndex: Int){
        val radius = resources.getDimension(R.dimen.button_corner_radius_1)
        val shapeDrawable = GradientDrawable()
        shapeDrawable.cornerRadius = radius
        shapeDrawable.setColor(Color.GREEN)

        when(buttonIndex){
            0 -> binding.option1.background = shapeDrawable
            1 -> binding.option2.background = shapeDrawable
            2 -> binding.option3.background = shapeDrawable
            3 -> binding.option4.background = shapeDrawable
        }
    }

    private fun wrongButtonColors(buttonIndex: Int) {
        val radius = resources.getDimension(R.dimen.button_corner_radius_1)
        val shapeDrawable = GradientDrawable()
        shapeDrawable.cornerRadius = radius
        shapeDrawable.setColor(Color.RED)

        when(buttonIndex) {
            0 -> binding.option1.background = shapeDrawable
            1 -> binding.option2.background = shapeDrawable
            2 -> binding.option3.background = shapeDrawable
            3 -> binding.option4.background = shapeDrawable
        }
    }

    private fun resetButtonColors(){
        val radius = resources.getDimension(R.dimen.button_corner_radius_1)
        val shapeDrawable = GradientDrawable()
        shapeDrawable.cornerRadius = radius
        shapeDrawable.setColor(Color.rgb(255, 87, 34))

        binding.option1.background = shapeDrawable
        binding.option2.background = shapeDrawable
        binding.option3.background = shapeDrawable
        binding.option4.background = shapeDrawable
    }

    private fun showResults(){
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
        val alertDialogBuilder = AlertDialog.Builder(requireContext())

        // Set the custom view for the dialog
        alertDialogBuilder.setView(dialogView)

        // Find and configure elements in your custom dialog layout
        val scoreTextView = dialogView.findViewById<TextView>(R.id.resultText)
        val restartButton = dialogView.findViewById<Button>(R.id.restartBtn)
        val chooseQuizButton = dialogView.findViewById<Button>(R.id.chooseQuizBtn)

        // Set the score text
        val scoreMessage = getString(R.string.score_message, score, quizQuestions.size)
        scoreTextView.text = scoreMessage

        // Set up button click event
        restartButton.setOnClickListener {
            restartQuiz()
            alertDialog.dismiss()
            Log.d("Button Click", "Restart Button Clicked")
        }
        chooseQuizButton.setOnClickListener {
            val quizFragment = QuizFragment()
            val fragmentTransaction9 = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction9.replace(R.id.fragment_container, quizFragment)
            fragmentTransaction9.addToBackStack(null)
            fragmentTransaction9.commit()
            alertDialog.dismiss()
            Log.d("Button Click", "Choose Quiz Button Clicked")
        }

        alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun displayQuestion() {
        val currentQuestion = quizQuestions[currentQuestionIndex]
        binding.questionText.text = currentQuestion.question
        binding.option1.text = currentQuestion.options[0]
        binding.option2.text = currentQuestion.options[1]
        binding.option3.text = currentQuestion.options[2]
        binding.option4.text = currentQuestion.options[3]

        Glide.with(this)
            .load(currentQuestion.imageQ)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.questionImage)

        resetButtonColors()
    }


    private fun checkAnswer(selectedAnswerIndex: Int){
        val correctAnswerIndex = quizQuestions[currentQuestionIndex].correctAnswer

        if (selectedAnswerIndex == correctAnswerIndex){
            score++
            correctButtonColors(selectedAnswerIndex)
        }else{
            wrongButtonColors(selectedAnswerIndex)
            correctButtonColors(correctAnswerIndex)
        }

        if (currentQuestionIndex < quizQuestions.size - 1){
            currentQuestionIndex++
            binding.questionText.postDelayed({ displayQuestion() }, 1500)
        } else {
            showResults()
        }
    }

    private fun restartQuiz(){
        currentQuestionIndex = 0
        score = 0
        displayQuestion()
    }
}