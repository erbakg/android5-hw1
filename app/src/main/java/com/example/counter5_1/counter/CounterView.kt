package com.example.counter5_1.counter

interface CounterView {

    fun showCounter(counter: Int)

    fun updateFontSize(font: Float)

    fun setDecBtnVisibility(visibility: Int)

    fun showToastByCondition(boolean: Boolean)

    fun setResultTextColor(color: Int)
}