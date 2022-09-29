package com.example.quizapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class QuestionFragment : Fragment() {

    var quiz: Quiz = Quiz()
    var currentQuestionIndex: Int = 0

    lateinit var questionTitle: TextView

    lateinit var optionsRadioGroup: RadioGroup
    lateinit var option0RadioButton: RadioButton
    lateinit var option1RadioButton: RadioButton
    lateinit var option2RadioButton: RadioButton
    lateinit var option3RadioButton: RadioButton
    lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        var fragmentView =  inflater.inflate(R.layout.fragment_question, container, false)
        questionTitle = fragmentView.findViewById(R.id.queTextView)

        optionsRadioGroup = fragmentView.findViewById(R.id.optionsRadioGroup)
        option0RadioButton = fragmentView.findViewById(R.id.radioButton0)
        option1RadioButton = fragmentView.findViewById(R.id.radioButton1)
        option2RadioButton = fragmentView.findViewById(R.id.radioButton2)
        option3RadioButton = fragmentView.findViewById(R.id.radioButton3)

        optionsRadioGroup.setOnCheckedChangeListener(object: RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                var message : String = ""
                var selectedOption = when (p1) {
                    R.id.radioButton0 -> 0
                    R.id.radioButton1 -> 1
                    R.id.radioButton2 -> 2
                    R.id.radioButton3 -> 3
                    else -> -1
                }
                quiz.setUserSelection(currentQuestionIndex, selectedOption)
                Toast.makeText(requireContext(), "Selected Option: $selectedOption", Toast.LENGTH_SHORT).show()

            }

        })

        nextButton = fragmentView.findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            currentQuestionIndex += 1
            if (currentQuestionIndex < quiz.getAllQuestions().size)
                showQuestion(currentQuestionIndex)
            else if (currentQuestionIndex == quiz.getAllQuestions().size-1){
                nextButton.setText("Submit")
            }
            else{
                quiz.printALlAnswers()
                Log.i("Score: " , quiz.getScore().toString())
            }
        }
        return fragmentView
    }

    override fun onResume() {
        super.onResume()
        showQuestion(currentQuestionIndex)
    }

    fun showQuestion (index:Int) {
        var question = quiz.getAllQuestions().get(index)
        questionTitle.text = question.title
        option0RadioButton.text = question.options.get(0)
        option1RadioButton.text = question.options.get(1)
        option2RadioButton.text = question.options.get(2)
        option3RadioButton.text = question.options.get(3)
    }
}