package com.app.workhub.models

data class Reviewer(
    val name :String,
    val profileImage :Int,
    val isSelectedForReview :Boolean = false,
)
