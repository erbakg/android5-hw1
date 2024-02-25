package com.example.counter5_1

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.counter5_1.counter.CounterView
import com.example.counter5_1.databinding.ActivityMainBinding
import com.example.counter5_1.model.CounterViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CounterViewModel by viewModels<CounterViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        observe()
    }

    private fun observe() {
        viewModel.apply {
            counter.observe(this@MainActivity) {
                binding.tvResult.text = it.toString()
            }
            fontSize.observe(this@MainActivity) {
                binding.tvResult.textSize = it
            }
            btnVisibility.observe(this@MainActivity) {
                binding.btnDecrement.visibility = it
            }
            showToast.observe(this@MainActivity) {
                it?.let {
                    if(it){
                        Toast.makeText(applicationContext, "Поздравляем", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            textColor.observe(this@MainActivity) {
                binding.tvResult.setTextColor(it)
            }
        }

    }

    private fun initClickers() {
        with(binding) {
            btnIncrement.setOnClickListener {
                viewModel.increment()
            }
            btnDecrement.setOnClickListener {
                viewModel.decrement()
            }
        }
    }

}