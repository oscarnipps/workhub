package com.app.workhub.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.workhub.R
import com.app.workhub.models.Reviewer


@Composable
fun TutorReviewScreen() {
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
                text = "Select Reviewer",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = "",
            onValueChange = {}
        )

        Column {
            Text(modifier = Modifier.padding(start = 16.dp), text = "Reviewers ( 0 )")

            LazyColumn(contentPadding = PaddingValues(16.dp)) {

                items(items = getReviewers()) {
                    ReviewListItem(it)
                    Divider(modifier = Modifier.padding(start = 32.dp, end = 16.dp))
                }
            }
        }

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            contentPadding = PaddingValues(12.dp),
            shape = RoundedCornerShape(24.dp)
        ) {
            //add icon to button
            Text(text = "Proceed")
        }
    }
}

@Composable
fun ReviewListItem(reviewer: Reviewer) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = reviewer.profileImage),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(end = 16.dp)
                .size(30.dp)
                .clip(shape = CircleShape),
            contentDescription = null
        )

        Text(
            text = reviewer.name
        )

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(end = 8.dp)) {
            Checkbox(
                modifier = Modifier.align(Alignment.CenterEnd),
                checked = false,
                onCheckedChange = {}
            )
        }

    }

}

fun getReviewers(): List<Reviewer> {
    return listOf(
        Reviewer("panini davies ali", R.drawable.tutor3),
        Reviewer("piki jones ", R.drawable.tutor4),
        Reviewer("alison becker", R.drawable.tutor2),
        Reviewer("james deen", R.drawable.tutor1),
        Reviewer("peter gregory", R.drawable.tutor4)
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewReviewScreen() {
    TutorReviewScreen()
}