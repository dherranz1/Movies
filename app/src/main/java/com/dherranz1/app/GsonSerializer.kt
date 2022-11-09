package com.dherranz1.app

import com.google.gson.Gson

class GsonSerializer : IJsonSerializer {

    val gson = Gson()

    override fun <T> toJson(obj: T, objclass: Class<T>): String =
        gson.toJson(obj)


    override fun <T> fromJson(json: String, objclass: Class<T>): T =
        gson.fromJson(json, objclass)

}