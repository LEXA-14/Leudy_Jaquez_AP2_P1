package com.example.leudy_jaquez_ap2_p1.data.x.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface borrameDao {

    @Upsert
    suspend fun upsert(borrameEntity: borrameEntity)

    @Delete
    suspend fun delete(borrameEntity: borrameEntity)

    @Query("Select * from Borrame")
    fun observeAll(): Flow<List<borrameEntity>>

    @Query("SELECT * FROM Borrame where id=:id")
    suspend fun getById(id:Int): borrameEntity?
}