package com.example.data.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.data.Entities.BarcodeUsers

@Dao
interface CodeDao {

   // @Query("SELECT * FROM barcode_table ORDER BY id ASC")
    @Query("SELECT * FROM barcode_table")
    fun getAllUserInfo(): List<BarcodeUsers>?

    @Insert
    //(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: BarcodeUsers?)

    @Delete
    fun deleteUser(user: BarcodeUsers?)

    @Update
    fun updateUser(user: BarcodeUsers?)











   /* @Insert
    fun insert(user:BarcodeUsers)

    @Update
    fun update(user:BarcodeUsers)

    @Update
    fun delete(user:BarcodeUsers)

    @Query("SELECT * FROM barcode_table")
    fun getAllUsers():List<BarcodeUsers>

    @Query("SELECT * FROM barcode_table WHERE id==:id")
    fun getUserWithId(id:Int):BarcodeUsers*/

}