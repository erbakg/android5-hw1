package com.example.counter5_1.counter

import android.graphics.Color
import android.view.View
import com.example.counter5_1.Injector
import com.example.counter5_1.R

class CounterPresenter {

    private var model = Injector.getCounterModel()
    private lateinit var view: CounterView

    fun inc() {
        model.increment()
        view.showCounter(model.count)
        setTextSizeByCondition()
        hideDecrementBtn()
        showToastByCondition()
        changeTextColorByCondition()
    }

    fun dec() {
        model.decrement()
        view.showCounter(model.count)
        setTextSizeByCondition()
        hideDecrementBtn()
        showToastByCondition()
        changeTextColorByCondition()
    }

    private fun setTextSizeByCondition() {
        if (model.count == 5) {
            view.updateFontSize(40f)
        } else {
            view.updateFontSize(30f)
        }
    }

    private fun hideDecrementBtn() {
        if (model.count % 2 == 0) {
            view.setDecBtnVisibility(View.GONE)
        } else {
            view.setDecBtnVisibility(View.VISIBLE)
        }
    }

    private fun showToastByCondition() {
        if (model.count == 10) {
            view.showToastByCondition(true)
        } else {
            view.showToastByCondition(false)
        }
    }

    private fun changeTextColorByCondition() {
        if (model.count == 15) {
            view.setResultTextColor(Color.GREEN)
        } else {
            view.setResultTextColor(Color.BLACK)
        }
    }

    fun initView(view: CounterView) {
        this.view = view
    }
}