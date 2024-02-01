package com.example.learningapplication.repository

import com.example.learningapplication.interfaces.SavedQuesDao
import com.example.learningapplication.modelClass.SavedQues

class DbRepository(private var savedQuesDao: SavedQuesDao) {

    suspend fun insertQues(savedQues: SavedQues) : String{
        return savedQuesDao.insertQues(savedQues)
    }

    suspend fun fetchQues() : Int {
        return savedQuesDao.selectQues()
    }

    suspend fun updateQues(savedQues: SavedQues) : Int {
        return savedQuesDao.updateQues(savedQues)
    }

    suspend fun deleteQues(savedQues: SavedQues) : Int {
        return savedQuesDao.deleteQues(savedQues)
    }
}