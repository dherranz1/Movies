package com.dherranz1.app

interface JsonSerializer {
    fun <T> toJson(obj : T, objclass : Class<T>) : String
    fun <T> fromJson(json : String, objclass : Class<T>) : T
}