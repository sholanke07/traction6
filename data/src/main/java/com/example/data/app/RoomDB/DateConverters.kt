package com.example.data.app.RoomDB

import androidx.room.TypeConverter
import com.example.data.Entities.BarcodeUsers
import com.google.gson.Gson
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*
import kotlin.collections.ArrayList

/*class DateConverters {

    @TypeConverter
    fun fromList(value : ArrayList<String>) = Json.encodeToString(value)

    @TypeConverter
    fun toList(value: String) = Json.decodeFromString<ArrayList<String>>(value)

   /* @TypeConverter
    fun listToJson(value: List<BarcodeUsers>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<BarcodeUsers>::class.java).toList()*/


}*/




