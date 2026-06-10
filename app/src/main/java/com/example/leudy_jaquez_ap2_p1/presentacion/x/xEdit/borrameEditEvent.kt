package com.example.leudy_jaquez_ap2_p1.presentacion.x.xEdit

 sealed class borrameEditEvent {

    data class load( val id: Int): borrameEditEvent()

     data class nombreChanged(val value: String?): borrameEditEvent()
     data class razonChanged( val value: String?): borrameEditEvent()
     data class montoChanged(val montoChanged: String?): borrameEditEvent()

     data object delete: borrameEditEvent()
     data object onSave: borrameEditEvent()
}