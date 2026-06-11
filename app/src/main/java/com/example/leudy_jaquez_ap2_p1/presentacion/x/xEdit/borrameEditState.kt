package com.example.leudy_jaquez_ap2_p1.presentacion.x.xEdit

 data class borrameEditState (
     val idAmonestacion:Int?=null,
     val nombre:String?="",
     val razon: String?="",
     val monto:String?="",

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
