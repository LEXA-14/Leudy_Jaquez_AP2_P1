package com.example.leudy_jaquez_ap2_p1.presentacion.x.xlist

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel

class borrameViewModel @Inject constructor(): ViewModel() {

    private val _state= MutableStateFlow(amonestacionState(true))
    val state: StateFlow<amonestacionState> = _state.asStateFlow()

}