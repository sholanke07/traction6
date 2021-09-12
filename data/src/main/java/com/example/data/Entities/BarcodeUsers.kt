package com.example.data.Entities

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName = "barcode_table")
data class BarcodeUsers(
       /* @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id") var id: Int = 0,
        @ColumnInfo(name = "barcode") var barcade_result: String = " "*/


        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var barcode_result: String = ""

        )
/*class barcodeTypeConventer {
        @TypeConverter
        fun FromString(value: String): ArrayList<String>{

                val listType = object : TypeToken<ArrayList<String>>(){}.type
                return Gson().fromJson(value, listType)

        }

        fun FromArrayList(list: ArrayList<String>): String{
                return Gson().toJson(list)

        }
}*/



