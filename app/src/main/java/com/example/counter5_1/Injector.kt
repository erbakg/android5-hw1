package com.example.counter5_1

import com.example.counter5_1.counter.CounterModel
import com.example.counter5_1.counter.CounterPresenter

class Injector {
    companion object {
        fun getCounterPresenter() = CounterPresenter()
        fun getCounterModel() = CounterModel()
    }
}