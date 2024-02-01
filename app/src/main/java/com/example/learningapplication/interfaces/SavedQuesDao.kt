package com.example.learningapplication.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.learningapplication.modelClass.SavedQues

@Dao
interface SavedQuesDao {
    @Insert
    suspend fun insertQues(savedQues: SavedQues) : String

    @Query("SELECT * FROM saved_questions")
    suspend fun selectQues() : Int

    @Update
    suspend fun updateQues(savedQues: SavedQues) : Int

    @Delete
    suspend fun deleteQues(savedQues: SavedQues) : Int
}