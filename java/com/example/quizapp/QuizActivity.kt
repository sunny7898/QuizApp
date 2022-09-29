package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        showQuizFragment()
    }

    fun showQuizFragment() {
        var quizFragment = QuestionFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.quizLayout, quizFragment, "Quiz Fragment")
            .commit()
    }
}