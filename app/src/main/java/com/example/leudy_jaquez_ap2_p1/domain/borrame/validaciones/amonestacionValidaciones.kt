package com.example.leudy_jaquez_ap2_p1.domain.borrame.validaciones

import androidx.core.text.isDigitsOnly

data class validationResult(
    val isValid: Boolean,
    val mensaje: String?
)

fun validateNombre(nombre: String): validationResult{
    return when{
        nombre.isBlank() -> validationResult(false,"El campo nombre no puede estar en blanco")

        else -> {
            validationResult(true,null)
        }
    }
}

fun validateRazon(razon: String):validationResult{
    return when{
        razon.isBlank()-> validationResult(false,"El campo razon no puede estar en blanco")
        else -> {
            validationResult(true,null)
        }
    }
}

fun validateMonto(monto: Double): validationResult{
    return when{
        monto<=0-> validationResult(false,"El monto de la amonestacion no puede ser igual o menor a 0")
        else -> {
            validationResult(true,null)
        }
    }
}