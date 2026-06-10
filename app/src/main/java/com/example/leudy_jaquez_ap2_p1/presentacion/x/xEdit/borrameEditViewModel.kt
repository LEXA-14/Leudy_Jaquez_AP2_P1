package com.example.leudy_jaquez_ap2_p1.presentacion.x.xEdit



import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.leudy_jaquez_ap2_p1.navegacion.screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class borrameEditViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
):
ViewModel(){

    private val _state = MutableStateFlow(borrameEditState())
    val state: StateFlow<borrameEditState> = _state.asStateFlow()

    private val Id: Int = savedStateHandle.toRoute<screen.borrameForm>().Id
}

