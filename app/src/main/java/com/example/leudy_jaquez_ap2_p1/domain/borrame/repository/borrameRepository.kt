package com.example.leudy_jaquez_ap2_p1.domain.borrame.repository

import com.example.leudy_jaquez_ap2_p1.domain.borrame.model.borrame
import kotlinx.coroutines.flow.Flow

interface  borrameRepository {

    fun observeAll(): Flow<List<borrame>>

    suspend fun getBorrame(id:Int): borrame?
    suspend fun upsert(borrame: borrame): Int
    suspend fun delete(id:Int)
    suspend fun exists(id: Int): Boolean
}