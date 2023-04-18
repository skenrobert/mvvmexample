package com.curso.mvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.curso.mvvm.databinding.ActivityMainBinding
import com.curso.mvvm.ui.viewmodel.QuoteViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding

    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}