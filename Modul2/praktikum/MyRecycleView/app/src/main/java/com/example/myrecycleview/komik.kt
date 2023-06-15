package com.example.myrecycleview


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class komik(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
