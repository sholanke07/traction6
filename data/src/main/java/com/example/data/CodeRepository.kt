package com.example.data

import androidx.lifecycle.LiveData
import com.example.data.Dao.CodeDao
import com.example.data.Entities.BarcodeUsers

/*class CodeRepository(private val codeDao: CodeDao) {

    val readAllData: LiveData<List<BarcodeUsers>> = codeDao.readAllData()

    suspend fun addUser(barcodeUsers: BarcodeUsers){
        codeDao.addUser(barcodeUsers)
    }
}*/