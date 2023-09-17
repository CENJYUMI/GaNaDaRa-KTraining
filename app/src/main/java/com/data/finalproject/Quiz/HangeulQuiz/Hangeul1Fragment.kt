package com.data.finalproject.Quiz.HangeulQuiz

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
import com.data.finalproject.Quiz.HangeulQuiz.QuizQuestion
import com.data.finalproject.Quiz.QuizFragment
import com.data.finalproject.R
import com.data.finalproject.databinding.FragmentHangeul1Binding

class Hangeul1Fragment : Fragment() {

    private lateinit var binding: FragmentHangeul1Binding
    private lateinit var alertDialog: AlertDialog

    private val quizQuestions = listOf(
        QuizQuestion("ㅔ", arrayOf("e", "u", "k", "i"), 0),
        QuizQuestion("ㅂ", arrayOf("ng", "h", "j/ch", "b/p"), 3),
        QuizQuestion("ㅜ", arrayOf("u", "i", "a", "eu"), 0),
        QuizQuestion("ㅌ", arrayOf("p", "t", "j/ch", "m"), 1),
        QuizQuestion("ㅓ", arrayOf("i", "a", "eo", "e"), 2),
        QuizQuestion("ㅢ", arrayOf("we", "wae", "ui", "wi"), 2),
        QuizQuestion("ㅠ", arrayOf("yo", "yu", "e", "yae"), 1),
        QuizQuestion("ㅞ", arrayOf("wi", "yu", "wa", "we"), 3),
        QuizQuestion("ㅟ", arrayOf("wa", "ui", "wi", "wo"), 2),
        QuizQuestion("ㅙ", arrayOf("wae", "wi", "woe", "ui"), 0)
    ).shuffled()

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHangeul1Binding.inflate(inflater, container, false)
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

    private fun displayQuestion(){
        binding.questionText.text = quizQuestions[currentQuestionIndex].question
        binding.option1.text = quizQuestions[currentQuestionIndex].options[0]
        binding.option2.text = quizQuestions[currentQuestionIndex].options[1]
        binding.option3.text = quizQuestions[currentQuestionIndex].options[2]
        binding.option4.text = quizQuestions[currentQuestionIndex].options[3]
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
