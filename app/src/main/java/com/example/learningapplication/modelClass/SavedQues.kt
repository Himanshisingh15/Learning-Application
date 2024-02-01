package com.example.learningapplication.modelClass

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "saved_questions")
data class SavedQues(

    @ColumnInfo(name = "Row ID")
    var rowId: Int,

    @ColumnInfo(name = "Question No")
    var ques_no : Int,

    @ColumnInfo(name = "Question")
    var ques : String,

    @ColumnInfo(name = "Answer")
    var ans : String,

    @ColumnInfo(name = "Url")
    var url : String,

    @ColumnInfo(name = "Image Url")
    var imgUrl : String
)
