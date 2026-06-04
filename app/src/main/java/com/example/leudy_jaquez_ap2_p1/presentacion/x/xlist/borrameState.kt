package com.example.leudy_jaquez_ap2_p1.presentacion.x.xlist

import com.example.leudy_jaquez_ap2_p1.domain.borrame.model.borrame

data class borrameState
    (
            val isLoading: Boolean=false,
            val listaBorrame:List<borrame> = emptyList(),
            val navigateToCreate: Boolean=false

            )