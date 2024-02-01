package com.example.learningapplication.activities

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.learningapplication.viewModel.ViewModel

class ViewModelFactory(var context: Context) : ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModel::class.java)){
            return ViewModel(context) as T
        }
        throw IllegalArgumentException("UnknownClass")
    }
}