package com.app.workhub.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.workhub.R
import com.app.workhub.navigation.WorkHubDestinations

@Composable
fun TutorDetailScreen(navController: NavController, screenState: TutorDetailsScreenState) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        //toolbar (this would be removed later for scaffold , for now just use it)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .height(32.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = "Details",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        //profile image
        Image(
            painter = painterResource(id = screenState.tutorProfileImage),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp, 300.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .align(Alignment.CenterHorizontally),
            contentDescription = null
        )

        //profile name
        Text(
            text = screenState.tutorName,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp, bottom = 16.dp)
        )

        //rate column
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            Text(text = "Hourly rate")
            Text(text = screenState.tutorRate, fontWeight = FontWeight.Bold)
        }

        //engagement
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterHorizontally),

            ) {

            //rating
            Column(
                modifier = Modifier
                    .size(120.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(color = colorResource(id = R.color.profile_item_color)),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_reviews),
                    modifier = Modifier.size(48.dp),
                    contentDescription = null
                )
                Text(text = "${screenState.tutorReview} reviews")
            }

            //socials
            Column(
                modifier = Modifier
                    .size(120.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(color = colorResource(id = R.color.profile_item_color)),
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        modifier = Modifier.size(32.dp),
                        contentDescription = null
                    )
                    Image(
                        painter = painterResource(id = R.drawable.twitter),
                        modifier = Modifier.size(32.dp),
                        contentDescription = null
                    )
                    Image(
                        painter = painterResource(id = R.drawable.instagram),
                        modifier = Modifier.size(32.dp),
                        contentDescription = null
                    )
                }

                Text(text = "Socials")
            }
        }

        Button(
            onClick = {
                navController.navigate(WorkHubDestinations.TutorReviewScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            contentPadding = PaddingValues(12.dp),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(text = "Confirm Tutor")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShowPreview() {
    TutorDetailScreen(
        navController = rememberNavController(),
        screenState = TutorDetailsScreenState()
    )
}