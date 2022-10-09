package com.carrasco.agenda

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact (val nombre:String, val telefono:String, val email:String, val imageURL:String) : Parcelable