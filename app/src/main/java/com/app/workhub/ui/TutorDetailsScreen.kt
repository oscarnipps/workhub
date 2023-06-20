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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.workhub.R

@Composable
fun TutorDetailScreen(
    modifier: Modifier = Modifier,
    onConfirmButtonClicked: () -> Unit = {},
    screenState: TutorDetailsScreenState
) {
    Column(
        modifier = modifier
    ) {
        //todo: (this would be removed later for scaffold , for now just use it)
        CustomToolbar(title = "Details",icon = Icons.Rounded.ArrowBack)

        TutorImage(
            modifier = Modifier
                .size(200.dp, 300.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .align(Alignment.CenterHorizontally),
            imageId = screenState.tutorProfileImage
        )

        ProfileName(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp, bottom = 16.dp),
            name = screenState.tutorName
        )

        RateDetail(
            modifier = Modifier.fillMaxWidth(),
            rate = screenState.tutorRate
        )

        EngagementSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 16.dp),
            reviews = screenState.tutorReview
        )

        ConfirmButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            onConfirmButtonClicked
        )
    }
}

@Composable
private fun ConfirmButton(modifier: Modifier, onConfirmButtonClicked: () -> Unit) {
    Button(
        onClick = {
            onConfirmButtonClicked()
        },
        modifier = modifier,
        contentPadding = PaddingValues(12.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(text = "Confirm Tutor")
    }
}

@Composable
private fun EngagementSection(modifier: Modifier, reviews: Int) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterHorizontally),
        ) {

        Reviews(
            modifier = Modifier
                .size(120.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = colorResource(id = R.color.profile_item_color)),
            reviews = reviews
        )

        Socials(
            modifier = Modifier
                .size(120.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = colorResource(id = R.color.profile_item_color))
        )
    }
}

@Composable
private fun Socials(modifier: Modifier) {
    Column(
        modifier = modifier,
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

@Composable
private fun Reviews(modifier: Modifier, reviews: Int) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_reviews),
            modifier = Modifier.size(48.dp),
            contentDescription = null
        )
        Text(text = "$reviews reviews")
    }
}

@Composable
private fun RateDetail(modifier: Modifier, rate: String) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
    ) {
        Text(text = "Hourly rate")
        Text(text = rate, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun ProfileName(modifier: Modifier, name: String) {
    Text(
        text = name,
        fontSize = 18.sp,
        modifier = modifier
    )
}

@Composable
fun CustomToolbar(modifier: Modifier = Modifier,title : String,icon : ImageVector) {
    Row(
        modifier = modifier
            .padding(24.dp)
            .height(32.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun TutorImage(modifier: Modifier = Modifier, imageId: Int) {
    Image(
        painter = painterResource(id = imageId),
        contentScale = ContentScale.Crop,
        modifier = modifier,
        contentDescription = null
    )
}

@Preview(showBackground = true)
@Composable
fun ShowPreview() {
    TutorDetailScreen(screenState = TutorDetailsScreenState())
}