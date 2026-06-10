package com.example.leudy_jaquez_ap2_p1.presentacion.x.xEdit



import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.leudy_jaquez_ap2_p1.domain.borrame.usecase.getByIdUseCase
import com.example.leudy_jaquez_ap2_p1.navegacion.screen
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
    getByIdUseCase: getByIdUseCase
):
ViewModel(){

    private val _state = MutableStateFlow(borrameEditState())
    val state: StateFlow<borrameEditState> = _state.asStateFlow()

    private val Id: Int = savedStateHandle.toRoute<screen.borrameForm>().Id

    //init
    //fun onEvent
    //delete()
    //load()
    //onsave

    fun load(id: Int){
        if(id==0){
            _state.update { it.copy(isNew = true, idAmonestacion = 0) }
            return
        }
        val amonestacion= getByIdUseCase(id)

        _state.update { it.copy(
            idAmonestacion = id,
            nombre = amonestacion.
        ) }
        viewModelScope.launch {
            _state.update { it.copy() }
        }
    }
}

