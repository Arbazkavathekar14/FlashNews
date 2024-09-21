package com.example.flashnews.database

import androidx.room.TypeConverter
import com.example.flashnews.Models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source):String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name,name)
    }
}