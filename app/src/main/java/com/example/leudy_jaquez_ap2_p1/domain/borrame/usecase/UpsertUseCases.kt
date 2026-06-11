package com.example.leudy_jaquez_ap2_p1.domain.borrame.usecase

import com.example.leudy_jaquez_ap2_p1.domain.borrame.model.amonestacion
import com.example.leudy_jaquez_ap2_p1.domain.borrame.repository.borrameRepository
import com.example.leudy_jaquez_ap2_p1.domain.borrame.validaciones.validateMonto
import com.example.leudy_jaquez_ap2_p1.domain.borrame.validaciones.validateNombre
import com.example.leudy_jaquez_ap2_p1.domain.borrame.validaciones.validateRazon
import javax.inject.Inject

class UpsertUseCases @Inject constructor(
    private val repository: borrameRepository
){
    suspend operator fun invoke(amonestacion: amonestacion): Result<Int>{
        val nombreValido= validateNombre(amonestacion.nombres)
        val razonValida= validateRazon(amonestacion.razon)
        val montoValido= validateMonto(amonestacion.monto)

        if(!nombreValido.isValid){
            return Result.failure(IllegalArgumentException(nombreValido.mensaje))
        }
        if(!razonValida.isValid){
            return Result.failure(IllegalArgumentException(razonValida.mensaje))
        }
        if(!montoValido.isValid){
            return Result.failure(IllegalArgumentException(montoValido.mensaje))
        }
        return runCatching {repository.upsert(amonestacion)}

    }
}


class GetByIdUseCase @Inject constructor(
    private val repository: borrameRepository
){
    suspend operator fun invoke(id: Int)=repository.getBorrame(id)
}

class DeleteByIdUseCase @Inject constructor(
    private val repository: borrameRepository
){
    suspend  operator fun invoke(id: Int)=repository.delete(id)
}

class ObserveAllUseCase @Inject constructor(
    private val repository: borrameRepository
){
    operator fun invoke()=repository.observeAll()
}