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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.workhub.data.getReviewers
import com.app.workhub.models.Reviewer


@Composable
fun TutorReviewScreen(
    modifier: Modifier = Modifier,
    reviewViewModel: TutorReviewViewModel = viewModel()
) {
    Column(
        modifier = modifier
    ) {
        //toolbar (this would be removed later for scaffold , for now just use it)
        CustomToolbar(title = "Select Reviewer", icon = Icons.Rounded.ArrowBack)

        //search field composable
        ReviewerSearchField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            reviewerName = reviewViewModel.state.reviewerName,
            onReviewerNameSearchChange = { name -> reviewViewModel.setReviewerName(name) }
        )

        //reviewers section composable
        Column {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "Reviewers ( ${reviewViewModel.state.addedReviewers.size} )"
            )

            LazyColumn(contentPadding = PaddingValues(16.dp)) {

                items(items = getReviewers()) { reviewerItem ->

                    ReviewListItem(
                        modifier = Modifier.fillMaxWidth(),
                        reviewerName = reviewerItem.name,
                        reviewerImageId = reviewerItem.profileImage,
                        isReviewerAdded = reviewViewModel.isReviewerAdded(reviewerItem.name),
                        onReviewerChecked = { reviewViewModel.addReviewer(reviewerItem.name) }
                    )

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
private fun ReviewerSearchField(
    modifier: Modifier,
    reviewerName: String,
    onReviewerNameSearchChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = reviewerName,
        label = { Text(text = "search for reviewer") },
        onValueChange = { onReviewerNameSearchChange(it) }
    )
}

@Composable
fun ReviewListItem(
    modifier: Modifier = Modifier,
    reviewerName: String,
    reviewerImageId: Int,
    isReviewerAdded: Boolean,
    onReviewerChecked: (String) -> Unit
) {

    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = reviewerImageId),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(end = 16.dp)
                .size(30.dp)
                .clip(shape = CircleShape),
            contentDescription = null
        )

        Text(text = reviewerName)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp)
        ) {
            Checkbox(
                modifier = Modifier.align(Alignment.CenterEnd),
                checked = isReviewerAdded,
                onCheckedChange = { onReviewerChecked(reviewerName) }
            )
        }

    }

}


@Preview(showBackground = true)
@Composable
fun PreviewReviewScreen() {
    TutorReviewScreen()
}