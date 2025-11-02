package es.etg.dam.pmdm.databridge.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Persona(
    var nombre:String,
    var apellido: String,
    var edad: Int

): Parcelable
