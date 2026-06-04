package com.example.leudy_jaquez_ap2_p1.data.x.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities=[borrameEntity::class],
    version=0,
    exportSchema=false
)

abstract class CervezaDB:RoomDatabase(){
    abstract fun borrameDao(): borrameDao
}