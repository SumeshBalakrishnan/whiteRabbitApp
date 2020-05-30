package com.whiterabbit.test.db.converter

import com.google.gson.Gson

class ListConverter {

    var gson = Gson()

/*    @TypeConverter
    fun fromTimestamp(data: String?): List<Exercise>? {

        if (data == null){
            return Collections.emptyList()
        }
        val listType = object : TypeToken<ArrayList<String>>() {}.type
        return gson.fromJson(data, listType)


    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Exercise>?): String? {
        return gson.toJson(someObjects)
    }*/


}