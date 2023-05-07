package com.curso.mvvm.quotemain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.curso.mvvm.databinding.ActivityMainBinding
import com.curso.mvvm.databinding.ActivityQuoteMainBinding
import com.curso.mvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint //config of HiltAndroidApp (root.MvvmApp), You have to prepare the class to be injectable in here
class QuoteMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuoteMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer {// quote api
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })
        quoteViewModel.isLoading.observe(this, Observer {// progress bar activity main
            binding.loading.isVisible = it
        })

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

    }
}