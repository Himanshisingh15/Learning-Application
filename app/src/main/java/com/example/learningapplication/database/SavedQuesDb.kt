package com.example.learningapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.learningapplication.interfaces.SavedQuesDao
import com.example.learningapplication.modelClass.SavedQues

@Database(entities = [SavedQues::class], version = 1)
abstract class SavedQuesDb : RoomDatabase() {

    abstract val savedQuesDao : SavedQuesDao

    companion object{
        @Volatile
        private var INSTANCE : SavedQuesDb? = null

        fun getInstance(context: Context) : SavedQuesDb {
            var instance = INSTANCE
            if (instance == null){
                instance = Room.databaseBuilder(context, SavedQuesDb::class.java, "savedQuesDb").build()
            }
            return instance
        }
    }
}