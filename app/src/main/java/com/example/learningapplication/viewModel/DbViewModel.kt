package com.example.learningapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningapplication.modelClass.SavedQues
import com.example.learningapplication.repository.DbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DbViewModel(private var dbRepository: DbRepository) : ViewModel() {
    var markAsRead : MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    init {

    }

    fun insertQues(savedQues: SavedQues){
        if (markAsRead.value!!){
            viewModelScope.launch(Dispatchers.IO){

            }
        }

    }
}