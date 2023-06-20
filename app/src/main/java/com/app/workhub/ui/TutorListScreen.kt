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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.workhub.R
import com.app.workhub.models.Tutor
import com.app.workhub.ui.theme.WorkHubTheme

@Composable
fun TutorListScreen(
    modifier: Modifier = Modifier,
    tutors: List<Tutor> = emptyList(),
    onTutorItemClicked: (Tutor) -> Unit = {}
) {
    Column(modifier = modifier.fillMaxSize()) {

        Text(
            modifier = Modifier.padding(16.dp),
            text = "Tutors",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        TutorListItem(tutors = tutors, onTutorItemClicked = onTutorItemClicked)
    }
}

@Composable
fun TutorListItem(
    modifier: Modifier = Modifier,
    tutors: List<Tutor>,
    onTutorItemClicked: (Tutor) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items = tutors) {
            TutorItem(
                tutor = it,
                onTutorItemClicked = onTutorItemClicked,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TutorItem(modifier: Modifier = Modifier, tutor: Tutor, onTutorItemClicked: (Tutor) -> Unit) {
    Card(
        modifier = modifier
            .background(
                color = colorResource(id = R.color.tutor_item_color),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onTutorItemClicked(tutor) },
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WorkHubTheme {
        TutorListScreen()
    }
}