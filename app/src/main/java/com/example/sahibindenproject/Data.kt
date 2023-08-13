package com.example.sahibindenproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(val id:Int, val explanation:String, val name:String, val image:String):
    Parcelable{

    }
