package com.app.workhub.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.app.workhub.models.Reviewer

class TutorReviewViewModel : ViewModel() {

    var state by mutableStateOf(TutorReviewScreenState())
        private set

    fun setReviewerName(reviewerName: String) {
        state = state.copy(reviewerName = reviewerName)
    }

    fun isReviewerAdded(reviewerName: String): Boolean {
        return true
    }

    fun addReviewer(reviewerName: String) {
        var addedReviewers = state.addedReviewers

        addedReviewers.add(AddedReviewer(reviewerName))

        state = state.copy(
            addedReviewers = addedReviewers
        )
    }
}