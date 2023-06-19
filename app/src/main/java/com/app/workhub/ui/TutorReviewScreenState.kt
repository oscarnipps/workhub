package com.app.workhub.ui

import com.app.workhub.models.Reviewer

data class TutorReviewScreenState(
    var reviewerName : String = "",
    var addedReviewers : List<Reviewer> = emptyList()
)
