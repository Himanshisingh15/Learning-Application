package com.example.learningapplication.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapplication.repository.Repository
import com.example.learningapplication.modelClass.QuestionDataList

class ViewModel(var context: Context) : ViewModel() {

    var repository = Repository(context)
    var readMoreUrl : String = ""

    fun readAssetData() : MutableLiveData<QuestionDataList>{
        return repository.readJsonData()
    }

    fun readKotlinAssetData() : MutableLiveData<QuestionDataList>{
        return repository.readKotlinData()
    }

    fun readJavaAssetData() : MutableLiveData<QuestionDataList>{
        return repository.readJavaData()
    }

}