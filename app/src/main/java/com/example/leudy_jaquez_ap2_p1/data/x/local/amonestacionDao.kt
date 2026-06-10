package com.example.leudy_jaquez_ap2_p1.data.x.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface amonestacionDao {

    @Upsert
    suspend fun upsert(amonestacioEntity: amonestacionEntity)

    @Delete
    suspend fun delete(amonestacionEntity: amonestacionEntity)

    @Query("Select * from Borrame")
    fun observeAll(): Flow<List<amonestacionEntity>>

    @Query("Delete from borrame where amonestacionId=:id")
    suspend fun deleteById(id: Int)

    @Query("SELECT * FROM Borrame where amonestacionId=:id")
    suspend fun getById(id:Int): amonestacionEntity?
}