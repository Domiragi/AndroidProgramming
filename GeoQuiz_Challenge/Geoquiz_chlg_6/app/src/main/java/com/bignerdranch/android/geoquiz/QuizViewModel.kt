package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    private val cheatedBank = mutableListOf<Int>()

    var currentIndex = 0
    var isCheater = false
    var isCheating = false

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
        if (cheatedBank.size == questionBank.size) cheatedBank.clear()
    }

    fun cheating(){
        if (!(cheatedBank.contains(currentIndex))) cheatedBank.add(currentIndex)
    }

    fun cheatedAns(): Boolean {
        return (cheatedBank.contains(currentIndex))
    }

    fun wipe() {
        isCheating = false
    }

}