package com.curso.mvvm.ui.view

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.activity.viewModels
import com.curso.mvvm.databinding.ActivityLoginApiBinding
import com.curso.mvvm.ui.viewmodel.LoginApiViewModel

class LoginApiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginApiBinding

    private val loginApiViewModel: LoginApiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("logapi", "antes de la declaracion")
        loginApiViewModel.onCreate()

        binding.btnApi.setOnClickListener {
            Log.i("logapi", "Button Pulsado ${binding.btnApi.text.toString()}")
        }
    }
}