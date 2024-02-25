package com.example.counter5_1.model

import android.graphics.Color
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    val counter: MutableLiveData<Int> = MutableLiveData()
    val fontSize: MutableLiveData<Float> = MutableLiveData()
    val btnVisibility: MutableLiveData<Int> = MutableLiveData()
    val showToast: MutableLiveData<Boolean> = MutableLiveData()
    val textColor: MutableLiveData<Int> = MutableLiveData()
    fun increment() {
        val currentValue = counter.value ?: 0
        counter.value = currentValue + 1
        setTextSizeByCondition()
        hideDecrementBtn()
        showToastByCondition()
        changeTextColorByCondition()
    }

    fun decrement() {
        val currentValue = counter.value ?: 0
        counter.value = currentValue - 1
        setTextSizeByCondition()
        hideDecrementBtn()
        showToastByCondition()
        changeTextColorByCondition()
    }

    private fun setTextSizeByCondition() {
        val currentValue = counter.value ?: 0
        if (currentValue == 5) {
            fontSize.value = 40f
        } else {
            fontSize.value = 30f
        }
    }

    private fun hideDecrementBtn() {
        val currentValue = counter.value ?: 0
        if (currentValue % 2 == 0) {
            btnVisibility.value = View.GONE
        } else {
            btnVisibility.value = View.VISIBLE
        }
    }

    private fun showToastByCondition() {
        val currentValue = counter.value ?: 0
        showToast.value = currentValue == 10
    }

    private fun changeTextColorByCondition() {
        val currentValue = counter.value ?: 0
        if (currentValue == 15) {
            textColor.value = Color.GREEN
        } else {
            textColor.value = Color.BLACK
        }
    }
}