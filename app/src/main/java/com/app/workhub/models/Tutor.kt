package com.app.workhub.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tutor(
    val name :String = "",
    val profileImage : Int = 0,
    val rate :String = "",
    val reviews :Int = 0
) : Parcelable
