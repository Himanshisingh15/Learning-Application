package com.example.learningapplication.activities

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.learningapplication.R
import com.example.learningapplication.databinding.ActivityWebViewBinding
import com.example.learningapplication.modelClass.QuestionsData
import com.example.learningapplication.viewModel.ViewModel

class WebViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityWebViewBinding
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web_view)
        viewModel = ViewModelProvider(this, ViewModelFactory(this))[ViewModel::class.java]
        val url = intent.getStringExtra("url")
        webView(url!!)

    }

    fun webView(url: String){
        if (url.isNotEmpty()){
            binding.webView.visibility = View.VISIBLE
            binding.webView.loadUrl(url)
            binding.webView.webChromeClient = WebChromeClient()
            binding.webView.settings.javaScriptEnabled = true
            binding.webView.webViewClient = object : WebViewClient(){
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    binding.progressBar.visibility = View.VISIBLE
                }
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }
}