package com.example.learningapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.learningapplication.repository.DbRepository

class DbViewModelFactory(var dbRepository: DbRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DbViewModel::class.java)){
            return DbViewModel(dbRepository) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}