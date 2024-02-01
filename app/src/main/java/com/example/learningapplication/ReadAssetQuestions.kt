package com.example.learningapplication

import android.content.Context
import com.example.learningapplication.modelClass.QuestionDataList
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

class ReadAssetQuestions(var context: Context) {

    var data = Gson().fromJson(readJsonAllQuestions(), QuestionDataList::class.java)
    var kotlinData = Gson().fromJson(readKotlinQues(), QuestionDataList::class.java)
    var javaData = Gson().fromJson(readJavaQues(), QuestionDataList::class.java)

    fun readJsonAllQuestions() : String? {
        var json : String? = null

        try {
            val inputStream : InputStream = context.assets.open("android_ques.json")
            json = inputStream.bufferedReader().use { it.readText() }
        }
        catch (e : IOException){

        }
        return json
    }

    fun readKotlinQues() : String? {
        var jsonKotlin : String? = null

        try {
            val inputStream : InputStream = context.assets.open("kotlin_ques.json")
            jsonKotlin = inputStream.bufferedReader().use { it.readText() }
        }
        catch (e : IOException){

        }
        return jsonKotlin
    }

    fun readJavaQues() : String? {
        var jsonJava : String? = null

        try {
            val inputStream : InputStream = context.assets.open("java_ques.json")
            jsonJava = inputStream.bufferedReader().use { it.readText() }
        }
        catch (e : IOException){

        }
        return jsonJava
    }
}