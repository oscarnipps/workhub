package com.app.workhub.navigation

import com.app.workhub.Constants.NAME_ARG_KEY
import com.app.workhub.Constants.PROFILE_IMAGE_ARG_KEY
import com.app.workhub.Constants.RATE_ARG_KEY
import com.app.workhub.Constants.REVIEWS_ARG_KEY

sealed class WorkHubDestinations(val route: String) {
    object TutorListScreen : WorkHubDestinations("tutor_list")

    object TutorDetailsScreen : WorkHubDestinations("tutor_details")

    object TutorReviewScreen : WorkHubDestinations("tutor_review")

    fun withArgs(vararg args: Any): String {
        return buildString {

            append(route)

            args.forEach { arg -> append("/$arg") }
        }
    }
}


