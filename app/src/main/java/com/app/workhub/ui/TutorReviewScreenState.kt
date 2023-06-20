package com.app.workhub.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.app.workhub.data.getReviewers
import com.app.workhub.models.Reviewer

data class TutorReviewScreenState(
    var reviewerName : String = "",
    val reviewers : MutableList<Reviewer> = getReviewers().toMutableList(),
    val addedReviewers : SnapshotStateList<AddedReviewer> = mutableStateListOf()
)

data class AddedReviewer(
    var reviewerName : String = ""
)

