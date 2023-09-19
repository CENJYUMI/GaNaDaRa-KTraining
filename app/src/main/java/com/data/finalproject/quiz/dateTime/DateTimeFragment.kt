package com.data.finalproject.quiz.dateTime

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
import com.data.finalproject.databinding.FragmentDateTimeBinding


class DateTimeFragment : Fragment() {

    private lateinit var binding: FragmentDateTimeBinding
    private lateinit var alertDialog: AlertDialog

    private val quizQuestions = listOf(
        QuizQuestion3("남: 오늘 회의는 몇 시에 \n있습니까? \n여: 오후 세 시 반입니다.",arrayOf(R.drawable.oneone, R.drawable.onetwo, R.drawable.onethree, R.drawable.onefour), 1),
        QuizQuestion3("남: 부안교육은 언제예요? \n여: 과장님께서 오후 4 시부터 \n5 시까지라고 하셨어요.",arrayOf(R.drawable.twoone, R.drawable.twotwo, R.drawable.twothree, R.drawable.twofour), 3),
        QuizQuestion3("남: 과장님 생신이 언제세요? \n여: 제 생일은 오 월 십 일입니다.",arrayOf(R.drawable.threeone, R.drawable.threetwo, R.drawable.threethree, R.drawable.threefour), 0),
        QuizQuestion3("남: 투안 씨, 휴가는 언제에요? \n여: 시 월 팔 일부터 십 \n일까지예요.",arrayOf(R.drawable.fourone, R.drawable.fourtwo, R.drawable.fourthree, R.drawable.fourfour), 2),
        QuizQuestion3("남: 이 톱은 얼마예요? \n여: 이천 오백 원입니다.",arrayOf(R.drawable.fiveone, R.drawable.fivetwo, R.drawable.fivethree, R.drawable.fivefour), 1),
        QuizQuestion3("남: 김밥 세 주레 얼마예요? \n여: 오천 백 원이에요.",arrayOf(R.drawable.sixone, R.drawable.sixtwo, R.drawable.sixthree, R.drawable.sixfour), 2),
        QuizQuestion3("남: 회식이 몇 시쯤 끝날까요? \n여: 여덟 시쯤 끝날거예요.",arrayOf(R.drawable.sevenone, R.drawable.seventwo, R.drawable.seventhree, R.drawable.sevenfour), 3),
        QuizQuestion3("남: 포도 한 상자에 얼마예요? \n여: 2kg 짜리가 이만 육천 \n원이예요.",arrayOf(R.drawable.eightone, R.drawable.eighttwo, R.drawable.eightthree, R.drawable.eightfour), 3),
        QuizQuestion3("남: 지훈 씨는 언제 출장이지요? \n여: 오 월 십삼 일부터 십육 \n일까지예요.",arrayOf(R.drawable.nineone, R.drawable.ninetwo, R.drawable.ninethree, R.drawable.ninefour), 1),
        QuizQuestion3("남: 안녕하세요, 박물관이죠? \n관람시간이 언제예요? \n여: 오전 아홉 시 반부터 \n네 시까지예요.",arrayOf(R.drawable.tenone, R.drawable.tentwo, R.drawable.tenthree, R.drawable.tenfour), 2),
        ).shuffled()

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDateTimeBinding.inflate(inflater, container, false)
        val view = binding.root

        displayQuestion()


        binding.option1image.setOnClickListener {
            checkAnswer(0)
        }
        binding.option2image.setOnClickListener {
            checkAnswer(1)
        }
        binding.option3image.setOnClickListener {
            checkAnswer(2)
        }
        binding.option4image.setOnClickListener {
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
            0 -> binding.option1image.background = shapeDrawable
            1 -> binding.option2image.background = shapeDrawable
            2 -> binding.option3image.background = shapeDrawable
            3 -> binding.option4image.background = shapeDrawable
        }
    }

    private fun wrongButtonColors(buttonIndex: Int) {
        val radius = resources.getDimension(R.dimen.button_corner_radius_1)
        val shapeDrawable = GradientDrawable()
        shapeDrawable.cornerRadius = radius
        shapeDrawable.setColor(Color.RED)

        when(buttonIndex) {
            0 -> binding.option1image.background = shapeDrawable
            1 -> binding.option2image.background = shapeDrawable
            2 -> binding.option3image.background = shapeDrawable
            3 -> binding.option4image.background = shapeDrawable
        }
    }

    private fun resetButtonColors(){
        val radius = resources.getDimension(R.dimen.button_corner_radius_1)
        val shapeDrawable = GradientDrawable()
        shapeDrawable.cornerRadius = radius
        shapeDrawable.setColor(Color.rgb(255, 255, 255))

        binding.option1image.background = shapeDrawable
        binding.option2image.background = shapeDrawable
        binding.option3image.background = shapeDrawable
        binding.option4image.background = shapeDrawable
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
            val fragmentTransaction10 = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction10.replace(R.id.fragment_container, quizFragment)
            fragmentTransaction10.addToBackStack(null)
            fragmentTransaction10.commit()
            alertDialog.dismiss()
            Log.d("Button Click", "Choose Quiz Button Clicked")
        }

        alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun displayQuestion() {
        val currentQuestion = quizQuestions[currentQuestionIndex]
        binding.questionText.text = currentQuestion.question


        Glide.with(this)
            .load(currentQuestion.options[0])
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.option1image)

        Glide.with(this)
            .load(currentQuestion.options[1])
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.option2image)

        Glide.with(this)
            .load(currentQuestion.options[2])
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.option3image)

        Glide.with(this)
            .load(currentQuestion.options[3])
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.option4image)

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


