package com.example.sahibindenproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(val id:Int, val categoryName:String, val categoryDetail:String, val categoryLogo:Int):
    Parcelable {

    }
