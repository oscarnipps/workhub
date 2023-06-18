package com.app.workhub.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.app.workhub.Constants
import com.app.workhub.Constants.TUTOR_DETAILS_SCREEN_ROUTE_PARAM
import com.app.workhub.ui.TutorDetailScreen
import com.app.workhub.ui.TutorDetailsScreenState
import com.app.workhub.ui.TutorListScreen

@Composable
fun WorkHubNavHost(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = WorkHubDestinations.TutorListScreen.route
    ) {

        composable(route = WorkHubDestinations.TutorListScreen.route) {
            TutorListScreen(navController)
        }

        composable(
            route = WorkHubDestinations.TutorDetailsScreen.route + TUTOR_DETAILS_SCREEN_ROUTE_PARAM,
            arguments = listOf(
                navArgument(Constants.NAME_ARG_KEY) {
                    type = NavType.StringType
                    nullable = false
                    defaultValue = ""
                },

                navArgument(Constants.PROFILE_IMAGE_ARG_KEY) {
                    type = NavType.IntType
                    nullable = false
                },

                navArgument(Constants.RATE_ARG_KEY) {
                    type = NavType.StringType
                    nullable = false
                    defaultValue = ""
                },

                navArgument(Constants.REVIEWS_ARG_KEY) {
                    type = NavType.IntType
                    nullable = false
                    defaultValue = 0
                }
            )
        ) { navBackStackEntry ->

            navBackStackEntry.arguments?.let {
                val detailsScreenState = TutorDetailsScreenState(
                    it.getString(Constants.NAME_ARG_KEY, ""),
                    it.getInt(Constants.PROFILE_IMAGE_ARG_KEY),
                    it.getInt(Constants.REVIEWS_ARG_KEY),
                    it.getString(Constants.RATE_ARG_KEY, "")
                )

                TutorDetailScreen(navController, detailsScreenState)
            }
        }
    }
}