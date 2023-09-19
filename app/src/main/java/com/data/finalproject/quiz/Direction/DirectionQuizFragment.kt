package com.data.finalproject.quiz.Direction

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
import com.data.finalproject.R
import com.data.finalproject.databinding.FragmentDirectionQuizBinding
import com.data.finalproject.quiz.QuizFragment
import com.data.finalproject.quiz.dateTime.QuizQuestion3
import com.data.finalproject.quiz.numbersUnitQuiz.QuizQuestion2


class DirectionQuizFragment : Fragment() {

    private lateinit var binding: FragmentDirectionQuizBinding
    private lateinit var alertDialog: AlertDialog

    private val quizQuestions = listOf(
        QuizQuestion4("쓰레기통은  어디에 있습니까?", arrayOf("선풍기 옆에 있습니다","공구함 위에 있습니다", "작업대 밑에 있습니다","문과 빗자루 사이에 있습니다"), 2, R.drawable.oneq),
        QuizQuestion4("화장실 어디에 있습니까?", arrayOf("숙직실 안에 있습니다", "창고 옆에 있습니다", "계단 맞은편에 있습니다", "숙직실과 세탁실 사이에 있습니다"), 0, R.drawable.twoq),
        QuizQuestion4("여행사는 어디에 있습니까?", arrayOf("병원 아래층에 있습니다", "약국과 같은 층에 있습니다", "우체국 옆에 있습니다", "커피숍과 약국 사이에 있습니다"), 1, R.drawable.threeq),
        QuizQuestion4("은행은 어디에 있습니까?", arrayOf("편의점 앞에 있습니다", "우체국 옆에 있습니다", "학교 맞은편에 있습니다", "병원과 약국 사이에 있습니다"), 2, R.drawable.fourq),
        QuizQuestion4("휴대폰은 어디에 있습니까?", arrayOf("쓰레기통 옆에 있습니다", "작업대 위에 있습니다", "공구함 밑에 있습니다", "문과 작업대 사이에 있습니다"), 1, R.drawable.fiveq),
        QuizQuestion4("편의점은 어디에 있습니까?", arrayOf("우체국 옆에 있습니다", "학교 앞에 있습니다", "약국 맞은편에 있습니다", "병원과 약국 사이에 있습니다"), 3, R.drawable.sixq),
        QuizQuestion4("숙소는 어디에 있습니까?", arrayOf("관리실 옆에 있습니다", "샤워실 건나편에 있습니다", "식당과 휴게실 사이에 있습니다", "식당 맞은편에 있습니다"), 3, R.drawable.sevenq),
        QuizQuestion4("컴퓨터실은 어디에 있습니까?", arrayOf("휴게실 위층에 있습니다", "기숙사 아래층에 있습니다", "샤워실 옆에 있습니다", "세탁실과 기숙사 사이에 있습니다"), 0, R.drawable.eightq),
        QuizQuestion4("고용센터는 어디에 있습니까?", arrayOf("약국 옆에 있습니다", "지하철역 뒤에 있습니다", "병원 앞에 있습니다", "은행 건나편에 있습니다"), 1, R.drawable.nineq),
        QuizQuestion4("매표소는 어디에 있습니까?", arrayOf("경찰서 뒤에 있습니다", "우체국 앞에 있습니다", "편의점 옆에 있습니다", "은행 건너편에 있습니다"), 3, R.drawable.tenq),
        )

    private var currentQuestionIndex = 0
    private var score = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDirectionQuizBinding.inflate(inflater, container, false)
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