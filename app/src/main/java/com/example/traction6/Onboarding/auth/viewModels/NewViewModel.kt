package com.example.traction6.Onboarding.auth.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import com.example.data.Dao.CodeDao
import com.example.data.Entities.BarcodeUsers
import com.example.data.app.RoomDB.RoomApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch


/*class NewViewModel(application: Application): AndroidViewModel(application) {

    var allUsers: MutableLiveData<List<BarcodeUsers>>

    init {
        allUsers = MutableLiveData()
        getAllUsers()
    }

    fun getAllUsersObservers(): MutableLiveData<List<BarcodeUsers>> {
        return allUsers
    }

    fun getAllUsers() {
        val codeDao = RoomApp.getAppDatabase((getApplication()))?.codeDao()
        val list = codeDao?.getAllUserInfo()

        allUsers.postValue(list)
    }

    fun insertUserInfo(entity: BarcodeUsers) {
        val codeDao = RoomApp.getAppDatabase((getApplication()))?.codeDao()
        codeDao?.insertUser(entity)
        getAllUsers()
    }

    fun deleteUserInfo(entity: BarcodeUsers) {
        val userDao = RoomApp.getAppDatabase((getApplication()))?.codeDao()
        userDao?.deleteUser(entity)
        getAllUsers()
    }
}*/






