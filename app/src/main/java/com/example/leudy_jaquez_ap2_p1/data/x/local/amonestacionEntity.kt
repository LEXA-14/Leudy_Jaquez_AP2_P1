package com.example.leudy_jaquez_ap2_p1.data.x.local

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity(tableName="Borrame")
data class amonestacionEntity (
    @PrimaryKey(autoGenerate=true)
    val amonestacionId: Int=0,
    val nombres:String,
    val razon: String,
    val monto: Double
)
