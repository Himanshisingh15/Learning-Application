package com.example.learningapplication.modelClass

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class QuestionsData (

    @SerializedName("serial_no")
    var serNo : Int,

    @SerializedName("question")
    var ques : String,

    @SerializedName("answer")
    var ans : String,

    @SerializedName("is_html")
    var isHtml : Boolean,

    @SerializedName("read_more_url")
    var url : String,

    @SerializedName("image_url")
    var imgUrl : String
) : Serializable
