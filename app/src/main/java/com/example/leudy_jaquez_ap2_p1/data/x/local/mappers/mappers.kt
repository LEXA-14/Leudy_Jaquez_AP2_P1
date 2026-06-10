package com.example.leudy_jaquez_ap2_p1.data.x.local.mappers

import com.example.leudy_jaquez_ap2_p1.data.x.local.amonestacionEntity
import com.example.leudy_jaquez_ap2_p1.domain.borrame.model.amonestacion


fun amonestacionEntity.ToDomain(): amonestacion =amonestacion(
    amonestacionId = amonestacionId,
    nombres = nombres,
    razon = razon,
    monto = monto

)

fun amonestacion.ToEntity(): amonestacionEntity= amonestacionEntity(
    amonestacionId = amonestacionId,
    nombres = nombres,
    razon = razon,
    monto = monto
)