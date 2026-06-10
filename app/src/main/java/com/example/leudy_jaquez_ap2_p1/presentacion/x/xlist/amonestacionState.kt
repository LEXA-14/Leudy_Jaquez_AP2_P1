package com.example.leudy_jaquez_ap2_p1.presentacion.x.xlist

import com.example.leudy_jaquez_ap2_p1.domain.borrame.model.amonestacion

data class amonestacionState
    (
    val isLoading: Boolean=false,
    val listaAmonestacion:List<amonestacion> = emptyList(),
    val navigateToCreate: Boolean=false,
    val navigateToEdit:Int?=null,
    val message:String?=null


            )