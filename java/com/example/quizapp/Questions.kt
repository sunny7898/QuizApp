package com.example.quizapp

import android.util.Log

class Question (val title: String, var options: List<String>, var answer: Int)

class Quiz {

    private var questions: List<Question>
    private var userAnswers: MutableList<Int> = mutableListOf<Int>()


    init {
        var question1 = Question (
            "What is the capital of India ?",
            listOf("New Delhi", "Pune", "Kolkata", "Chennai"),
            0
        )

        var question2 = Question (
            "What is the capital of USA ?",
            listOf("Chicago", "Richmond", "Washington", "Las Vegas"),
            2
        )
        questions = listOf(question1, question2)
    }

    fun getAllQuestions() : List<Question> {
        return questions
    }

    fun setUserSelection (index: Int, answer: Int) {
        userAnswers.add(index, answer)
    }

    fun resetAllAnswers() {
        userAnswers.clear()
    }
    fun printALlAnswers() {
        for (item in userAnswers){
            Log.i("Question", "Answer for Question = $item")
        }
    }


    fun getScore() : Int {
        var score = 0
        for (index in questions.indices) {
            if (userAnswers.get(index) == questions.get(index).answer)
                score+= 1
        }

        return score
    }
}