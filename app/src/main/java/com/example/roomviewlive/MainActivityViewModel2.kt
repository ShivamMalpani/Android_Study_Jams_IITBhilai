package com.example.roomviewlive

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.roomandrecycleview.db.UserEntity
import com.example.roomandrecycleview.db2.RoomAppDb2
import com.example.roomandrecycleview.db2.UserEntity2

class MainActivityViewModel2(app: Application): AndroidViewModel(app) {
    var allUsers : MutableLiveData<List<UserEntity2>> = MutableLiveData()

    init{
        getAllUsers()
    }

    fun getAllUsersObservers(): MutableLiveData<List<UserEntity2>> {
        return allUsers
    }

    fun getAllUsers() {
        val userDao = RoomAppDb2.getAppDatabase((getApplication()))?.userDao()
        val list = userDao?.getAllUserInfo()

        allUsers.postValue(list)
    }

    fun insertUserInfo(entity: UserEntity2){
        val userDao = RoomAppDb2.getAppDatabase(getApplication())?.userDao()
        userDao?.insertUser(entity)
        getAllUsers()
    }

    fun updateUserInfo(entity: UserEntity2){
        val userDao = RoomAppDb2.getAppDatabase(getApplication())?.userDao()
        userDao?.updateUser(entity)
        getAllUsers()
    }

    fun deleteUserInfo(entity: UserEntity2){
        val userDao = RoomAppDb2.getAppDatabase(getApplication())?.userDao()
        userDao?.deleteUser(entity)
        getAllUsers()
    }
}