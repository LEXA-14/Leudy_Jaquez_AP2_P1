package com.example.leudy_jaquez_ap2_p1.presentacion.x.xlist

 sealed class amonestacionEvent {

    object load: amonestacionEvent()
     object clearMessage: amonestacionEvent()
     object createNew: amonestacionEvent()

     data class showMessage(val mensaje: String?): amonestacionEvent()
     data class edit(val id:Int?): amonestacionEvent()
     data class delete(val id: Int): amonestacionEvent()
}