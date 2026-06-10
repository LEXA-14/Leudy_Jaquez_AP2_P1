package com.example.leudy_jaquez_ap2_p1.domain.borrame.repository

import com.example.leudy_jaquez_ap2_p1.domain.borrame.model.amonestacion
import kotlinx.coroutines.flow.Flow

interface  borrameRepository {

    fun observeAll(): Flow<List<amonestacion>>

    suspend fun getBorrame(id:Int): amonestacion?
    suspend fun upsert(amonestacion: amonestacion): Int
    suspend fun delete(id:Int)
    suspend fun exists(id: Int): Boolean
}