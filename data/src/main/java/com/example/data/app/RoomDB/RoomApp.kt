package com.example.data.app.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.Dao.CodeDao
import com.example.data.Entities.BarcodeUsers
//import com.example.data.Entities.barcodeTypeConventer
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [BarcodeUsers::class], version = 2, exportSchema = false)
//@TypeConverters(barcodeTypeConventer::class)
abstract class RoomApp: RoomDatabase() {

    abstract fun codeDao(): CodeDao?


    companion object {

        private var INSTANCE: RoomApp? = null

        fun getAppDatabase(context: Context): RoomApp? {
            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(
                        context.applicationContext, RoomApp::class.java, "AppDB"

                )
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }

    }


