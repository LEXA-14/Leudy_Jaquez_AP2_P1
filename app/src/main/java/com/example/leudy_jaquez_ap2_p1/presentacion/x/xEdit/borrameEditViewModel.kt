package com.example.leudy_jaquez_ap2_p1.presentacion.x.xEdit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.leudy_jaquez_ap2_p1.domain.borrame.model.amonestacion
import com.example.leudy_jaquez_ap2_p1.domain.borrame.usecase.DeleteByIdUseCase
import com.example.leudy_jaquez_ap2_p1.domain.borrame.usecase.GetByIdUseCase
import com.example.leudy_jaquez_ap2_p1.domain.borrame.usecase.UpsertUseCases
import com.example.leudy_jaquez_ap2_p1.domain.borrame.validaciones.validateMonto
import com.example.leudy_jaquez_ap2_p1.domain.borrame.validaciones.validateNombre
import com.example.leudy_jaquez_ap2_p1.domain.borrame.validaciones.validateRazon
import com.example.leudy_jaquez_ap2_p1.navegacion.screen
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class borrameEditViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getByIdUseCase: GetByIdUseCase,
    private val deleteUseCase: DeleteByIdUseCase,
    private val upsertUseCases: UpsertUseCases
):
ViewModel(){

    private val _state = MutableStateFlow(borrameEditState())
    val state: StateFlow<borrameEditState> = _state.asStateFlow()

    private val Id: Int = savedStateHandle.toRoute<screen.borrameForm>().id

    //init
    //fun onEvent
    //delete()
    //load()
    //onsave

    init {
        load(Id)
    }

    fun onEvent(event: borrameEditEvent){
        return when(event) {
            borrameEditEvent.delete -> delete()
            is borrameEditEvent.load -> load(Id)
            is borrameEditEvent.montoChanged -> _state.update { it.copy(monto = event.value) }
            is borrameEditEvent.nombreChanged -> _state.update { it.copy(nombre =event.value ) }
            borrameEditEvent.onSave -> onSave()
            is borrameEditEvent.razonChanged -> _state.update { it.copy(razon =event.value) }
        }
    }

    fun load(id: Int) {
        if (id == 0) {
            _state.update { it.copy(isNew = true, idAmonestacion = 0) }
            return
        }
        viewModelScope.launch {
            val amonestacion = getByIdUseCase(id)

            if (amonestacion != null) {
                viewModelScope.launch {
                    _state.update {
                        it.copy(
                            isNew = false,
                            idAmonestacion = id,
                            nombre = amonestacion.nombres,
                            razon = amonestacion.razon,
                            monto = amonestacion.monto.toString()
                        )
                    }
                }
            } else {
                _state.update { it.copy(isNew = true, idAmonestacion = 0) }
            }
        }
    }


     fun onSave(){
        val nombreValido= validateNombre(state.value.nombre?:"")
        val razonValida= validateRazon(state.value.razon?:"")
        val montoValido= validateMonto(state.value.monto?.toDoubleOrNull()?:0.0)

        if(!nombreValido.isValid || !razonValida.isValid || !montoValido.isValid){
            _state.update { it.copy(nombreError = nombreValido.mensaje,
                razonError = razonValida.mensaje,
                montoError = montoValido.mensaje) }
            return
        }
        viewModelScope.launch {
            val amonestacion = amonestacion(
                amonestacionId = state.value.idAmonestacion ?: 0,
                nombres = state.value.nombre ?: "",
                razon = state.value.razon ?: "",
                monto = state.value.monto?.toDoubleOrNull() ?: 0.0,
            )
            upsertUseCases(amonestacion).onSuccess {
                _state.update { it.copy(saved = true) }
            }
//            if(upsertUseCases(amonestacion).onFailure {
//                _state.update { it.copy(saved = false, isSaving = false) }
//                }
            /*upsertUseCases(amonestacion).fold(
                onSuccess = Result.success { newId ->
                    _state.update { it.copy(saved = true, idAmonestacion = newId) }
                },
                onFailure = Result.failure { error ->
                    _state.update { it.copy(saved = false, isSaving = false, mensaje = error) }
                }
            )*/
        }

    }

    fun delete(){
        val id=state.value.idAmonestacion?:return
        viewModelScope.launch {
            _state.update { it.copy(isDelete = true) }
            deleteUseCase(id)
            _state.update { it.copy(isDelete = false, deleted = true) }

        }
    }



        }




