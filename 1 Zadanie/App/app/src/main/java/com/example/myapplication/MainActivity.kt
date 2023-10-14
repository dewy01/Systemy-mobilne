package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView


    private val questions = listOf(
        Question(R.string.q_activity, true),
        Question(R.string.q_find_resources, false),
        Question(R.string.q_listener, true),
        Question(R.string.q_resources, true),
        Question(R.string.q_version, false)
    )

    private var currentIndex = 0

    private fun checkAnswerCorrectness(userAnswer: Boolean) {
        val correctAnswer = questions[currentIndex].isTrueAnswer()
        val resultMessageId: Int = if (userAnswer == correctAnswer) {
            R.string.correct_answer
        } else {
            R.string.incorrect_answer
        }
        Toast.makeText(this,resultMessageId,Toast.LENGTH_SHORT).show()
    }

    private fun setNextQuestion() {
        currentIndex = (currentIndex + 1) % questions.size
        displayQuestion()
    }

    private fun displayQuestion() {
        questionTextView.setText(questions[currentIndex].getQuestionId())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

                    trueButton = findViewById(R.id.true_button)
                    falseButton = findViewById(R.id.false_button)
                    nextButton = findViewById(R.id.next_button)
                    questionTextView = findViewById(R.id.question_text_view)

                    trueButton.setOnClickListener {
                        checkAnswerCorrectness(true)
                    }

                    falseButton.setOnClickListener {
                        checkAnswerCorrectness(false)
                    }

                    nextButton.setOnClickListener {
                        currentIndex = (currentIndex + 1) % questions.size
                        setNextQuestion()
                    }

                    setNextQuestion()

    }
}

