package com.dherranz1.app.memory

import android.util.Log

class MemoryDataStore <T> {
    private val memoryDataStore = mutableMapOf<String,T>()

    fun put(id: String, obj : T) =
        memoryDataStore.put(id, obj)

    fun get(id: String) : T? =
        memoryDataStore[id]

    fun getAll() : List<T> =
        memoryDataStore.map { element ->
            element.value
        }

}