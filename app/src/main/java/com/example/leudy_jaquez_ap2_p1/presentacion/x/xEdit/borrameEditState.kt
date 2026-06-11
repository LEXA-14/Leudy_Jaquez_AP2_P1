package com.example.leudy_jaquez_ap2_p1.presentacion.x.xEdit

 data class borrameEditState (
     val idAmonestacion:Int?=null,
     val nombre:String?=null,
     val razon: String?=null,
     val monto:String?=null,

     val nombreError:String?=null,
     val razonError: String?=null,
     val montoError: String?=null,

     val mensaje: String?=null,

        val isNew: Boolean = true,
        val saved: Boolean=false,
        val isSaving: Boolean  = false,
        val isDelete: Boolean=false,
        val deleted: Boolean=false,
        val dato: String = ""
    )
