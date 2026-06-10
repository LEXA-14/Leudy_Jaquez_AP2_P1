package com.example.leudy_jaquez_ap2_p1.presentacion.x.xlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leudy_jaquez_ap2_p1.domain.borrame.usecase.deleteByIdUseCase
import com.example.leudy_jaquez_ap2_p1.domain.borrame.usecase.observeAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class borrameViewModel @Inject constructor(
    private val observeAllUseCase: observeAllUseCase,
    private val deleteByIdUseCase: deleteByIdUseCase
): ViewModel() {

    private val _state= MutableStateFlow(amonestacionState(true))
    val state: StateFlow<amonestacionState> = _state.asStateFlow()

    init {
        load()
    }

    fun onEvent(event: amonestacionEvent){
        return when (event){
            amonestacionEvent.clearMessage -> _state.update { it.copy(message = null) }
            amonestacionEvent.createNew -> _state.update { it.copy(navigateToCreate = true) }
            is amonestacionEvent.delete -> delete(event.id)
            is amonestacionEvent.edit -> _state.update { it.copy(navigateToEdit = event.id) }
            amonestacionEvent.load -> load()
            is amonestacionEvent.showMessage -> _state.update { it.copy(message = event.mensaje) }
        }



    }

       fun load(){
           viewModelScope.launch {
               observeAllUseCase().collectLatest { list->_state.update { it.copy(isLoading = false, listaAmonestacion = list) }}
           }
    }

    fun delete(id: Int){
        viewModelScope.launch {
            deleteByIdUseCase(id)
        }
    }

}