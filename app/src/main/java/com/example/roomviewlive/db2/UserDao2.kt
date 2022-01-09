package com.example.roomandrecycleview.db2

import androidx.room.*
import com.example.roomandrecycleview.db2.UserEntity2

@Dao
interface UserDao2 {


    @Query("SELECT * FROM userinfo2 ORDER BY id DESC")
    fun getAllUserInfo(): List<UserEntity2>?


    @Insert
    fun insertUser(user: UserEntity2?)

    @Delete
    fun deleteUser(user: UserEntity2?)

    @Update
    fun updateUser(user: UserEntity2?)

}