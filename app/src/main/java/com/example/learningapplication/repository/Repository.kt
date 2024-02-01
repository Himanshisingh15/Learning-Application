package com.example.learningapplication.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.learningapplication.ReadAssetQuestions
import com.example.learningapplication.modelClass.QuestionDataList

class Repository(var context: Context) {
    var readAssetData = ReadAssetQuestions(context)
    var androidQuesData = MutableLiveData<QuestionDataList>()
    var kotlinQuesData = MutableLiveData<QuestionDataList>()
    var javaQuesData = MutableLiveData<QuestionDataList>()

    fun readJsonData() : MutableLiveData<QuestionDataList>{

        androidQuesData.value = readAssetData.data

        return androidQuesData
    }

    fun readKotlinData() : MutableLiveData<QuestionDataList>{
        kotlinQuesData.value = readAssetData.kotlinData

        return kotlinQuesData
    }

    fun readJavaData() : MutableLiveData<QuestionDataList>{
        javaQuesData.value = readAssetData.javaData

        return javaQuesData
    }

}