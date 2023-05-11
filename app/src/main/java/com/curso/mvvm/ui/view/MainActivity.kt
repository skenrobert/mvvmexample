package com.curso.mvvm.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.curso.mvvm.R
import com.curso.mvvm.databinding.ActivityMainBinding
import com.curso.mvvm.quotemain.QuoteMainActivity
import com.curso.mvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//@AndroidEntryPoint //config of HiltAndroidApp (root.MvvmApp), You have to prepare the class to be injectable in here
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnQuote = findViewById<Button>(R.id.btnQuote)
        btnQuote.setOnClickListener { navigateToQuoteApp() }


        val btnLoginApi = findViewById<Button>(R.id.btnLoginApi)
        btnLoginApi.setOnClickListener { navigateToLoginApiApp() }


//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)



//        quoteViewModel.onCreate()
//
//        quoteViewModel.quoteModel.observe(this, Observer {// quote api
//            binding.tvQuote.text = it.quote
//            binding.tvAuthor.text = it.author
//        })
//        quoteViewModel.isLoading.observe(this, Observer {// progress bar activity main
//            binding.loading.isVisible = it
//        })
//
//        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

    }

    private fun navigateToQuoteApp() {
        val intent = Intent(this, QuoteMainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToLoginApiApp() {
        val intent = Intent(this, LoginApiActivity::class.java)
        startActivity(intent)
    }

}