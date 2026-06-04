package com.example.leudy_jaquez_ap2_p1.navegacion

import kotlinx.serialization.Serializable

sealed class screen {
     @Serializable
     data object borrameList: screen()

    @Serializable
    data class borrameForm(val id:Int=0): screen()

}