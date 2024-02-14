package com.example.counter5_1

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.counter5_1.counter.CounterView
import com.example.counter5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    private lateinit var binding: ActivityMainBinding
    private var presenter = Injector.getCounterPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        presenter.initView(this)
        with(binding) {
            btnIncrement.setOnClickListener {
                presenter.inc()
            }
            btnDecrement.setOnClickListener {
                presenter.dec()
            }
        }
    }

    override fun showCounter(counter: Int) {
        binding.tvResult.text = counter.toString()
    }

    override fun updateFontSize(font: Float) {
        binding.tvResult.textSize = font
    }

    override fun setDecBtnVisibility(visibility: Int) {
        binding.btnDecrement.visibility = visibility
    }

    override fun showToastByCondition(boolean: Boolean) {
        if(boolean){
            Toast.makeText(this, "Поздравляем", Toast.LENGTH_SHORT).show()
        }
    }

    override fun setResultTextColor(color: Int) {
        binding.tvResult.setTextColor(color)
    }
}