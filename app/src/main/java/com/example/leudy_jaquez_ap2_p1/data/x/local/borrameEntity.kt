package com.example.leudy_jaquez_ap2_p1.data.x.local

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity(tableName="Borrame")
data class borrameEntity (
    @PrimaryKey(autoGenerate=true)
    val id: Int=0
)
