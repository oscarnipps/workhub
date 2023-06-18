package com.app.workhub.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.workhub.R
import com.app.workhub.models.Tutor
import com.app.workhub.navigation.WorkHubDestinations
import com.app.workhub.ui.theme.WorkHubTheme

@Composable
fun TutorListScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Tutors",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        TutorListItem(navController)
    }
}

@Composable
fun TutorListItem(navController: NavController) {
    val tutors by remember { mutableStateOf(getTutors()) }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items = tutors) {
            TutorItem(tutor = it, navController)
        }
    }
}

@Composable
fun TutorItem(tutor: Tutor, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.tutor_item_color),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                navController.navigate(
                    WorkHubDestinations.TutorDetailsScreen.withArgs(
                        tutor.name,
                        tutor.profileImage,
                        tutor.reviews,
                        tutor.rate
                    )
                ){

                }
            },
        elevation = 6.dp
    ) {
        Column {
            Text(
                text = tutor.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                style = TextStyle(),
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_fee),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(start = 8.dp, end = 4.dp)
                )

                Text(text = tutor.rate)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_reviews),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(start = 8.dp, end = 4.dp)
                )

                Text(text = tutor.reviews.toString())
            }
        }
    }

}

fun getTutors(): List<Tutor> {
    return listOf(
        Tutor("jane wilson", R.drawable.tutor1, "$24", 100),
        Tutor("diego simone", R.drawable.tutor2, "$27", 120),
        Tutor("sasha davies", R.drawable.tutor3, "$29", 80),
        Tutor("jacob ali", R.drawable.tutor4, "$30", 150),
        Tutor("jacob ali", R.drawable.tutor4, "$30", 150),
        Tutor("jacob ali", R.drawable.tutor4, "$30", 150),
        Tutor("jacob ali", R.drawable.tutor4, "$30", 150),
        Tutor("jacob ali", R.drawable.tutor4, "$30", 150),
        Tutor("jacob ali", R.drawable.tutor4, "$30", 150),
        Tutor("derrick soweto", R.drawable.tutor5, "$35", 321)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WorkHubTheme {
        TutorListScreen(navController = rememberNavController())
    }
}